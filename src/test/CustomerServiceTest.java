package test;

import main.entity.Customer;
import main.repository.CustomerRepository;
import main.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    private static final long ID = 1;
    private static final String CUSTOMER_NAME = "IVAN";
    private static final String CUSTOMER_EMAIL = "IVAN@MAIL.RU";
    private static final String CUSTOMER_SURNAME = "IVANOV";



    static CustomerService customerService;

    @BeforeEach()
    void init() {
        CustomerRepository customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepository);
        Customer customer = getCustomer();
        List<Customer> customers = new ArrayList<>();
        when(customerRepository.findById(ID)).thenReturn(java.util.Optional.of(customer));
        when(customerRepository.findAll(any(Sort.class))).thenReturn(customers);
        when(customerRepository.save(any())).thenReturn(customer);
    }

    private Customer getCustomer(){
        Customer customer = new Customer();
        customer.setEmail(CUSTOMER_EMAIL);
        customer.setName(CUSTOMER_NAME);
        customer.setSurname(CUSTOMER_SURNAME);
        customer.setId(ID);
        return customer;
    }

    @Test
    void save() {
        Customer customer = new Customer();
        customer.setEmail(CUSTOMER_EMAIL);
        customer.setName(CUSTOMER_NAME);
        customer.setSurname(CUSTOMER_SURNAME);
        customer.setId(ID);
        customerService.save(customer);
        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        CustomerService customerServiceOther = mock(CustomerService.class);
        customerServiceOther.save(customer);
        verify(customerServiceOther).save(captor.capture());
    }

    @Test
    void listAll() {
        List<Customer> customers = new ArrayList<>();
        List<Customer> returned = customerService.listAll();
        assertEquals(customers, returned);
    }

    @Test
    void get() {
        Customer customer = customerService.get(ID);
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        CustomerService customerServiceOther = mock(CustomerService.class);
        customerServiceOther.get(ID);
        verify(customerServiceOther).get(captor.capture());
        assertEquals(java.util.Optional.of(ID), java.util.Optional.of(captor.getValue()));
        assertEquals(java.util.Optional.of(ID), java.util.Optional.of(customer.getId()));
        assertEquals(CUSTOMER_EMAIL, customer.getEmail());
        assertEquals(CUSTOMER_NAME, customer.getName());
        assertEquals(CUSTOMER_SURNAME, customer.getSurname());
    }

    @Test
    void delete() {
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        CustomerService customerServiceOther = mock(CustomerService.class);
        customerServiceOther.delete(ID);
        verify(customerServiceOther).delete(captor.capture());
    }

    @Test
    void search() {
        List<Customer> searchList = new ArrayList<>();
        List<Customer> returned = customerService.search(CUSTOMER_NAME);
        assertEquals(searchList, returned);
    }
}