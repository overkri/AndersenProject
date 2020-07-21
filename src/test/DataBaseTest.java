import main.java.config.JpaConfig;
import main.java.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;
import main.java.exceptions.IdNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { JpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class DataBaseTest {

    private static final long ID = 1L;
    private static final String CUSTOMER_NAME = "IVAN";
    private static final String CUSTOMER_EMAIL = "IVAN@MAIL.RU";
    private static final String CUSTOMER_SURNAME = "IVANOV";
    private static final long ID2 = 2L;

    @Resource
    private main.java.repository.CustomerRepository customerRepository;


    @Test
    public void saveCustomer() {
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setSurname(CUSTOMER_SURNAME);
        customer.setName(CUSTOMER_NAME);
        customer.setEmail(CUSTOMER_EMAIL);
        customerRepository.save(customer);
        customerRepository.save(customer);
        Customer testCustomer = new Customer();
        Optional<Customer> customer2 = customerRepository.findById(ID);
        if (customer2.isPresent()){
            testCustomer = customer2.get();
        }
        assertEquals(CUSTOMER_NAME, testCustomer.getName());
        assertEquals(CUSTOMER_EMAIL, testCustomer.getEmail());
        assertEquals(CUSTOMER_SURNAME, testCustomer.getSurname());
    }
    @Test
    public void deleteCustomer() {
        Customer customer4 = new Customer();
        customer4.setSurname(CUSTOMER_SURNAME);
        customer4.setName(CUSTOMER_NAME);
        customer4.setEmail(CUSTOMER_EMAIL);
        customerRepository.deleteById(ID2);
        Optional<Customer> customer3 = customerRepository.findById(ID2);
        assertEquals(customer3, Optional.empty());
    }
}
