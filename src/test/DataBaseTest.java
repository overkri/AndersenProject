import main.config.JpaConfig;
import main.entity.Customer;
import main.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

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

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private HotelRepository hotelRepository;

    @Resource
    private ReviewRepository reviewRepository;

    @Resource
    private CountryRepository countryRepository;

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private TourRepository tourRepository;

    @Test
    public void saveCustomer() {
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setSurname(CUSTOMER_SURNAME);
        customer.setName(CUSTOMER_NAME);
        customer.setEmail(CUSTOMER_EMAIL);
        customerRepository.save(customer);
        Customer testCustomer = new Customer();
        Optional<Customer> customer2 = customerRepository.findById(1L);
        if (customer2.isPresent()){
            testCustomer = customer2.get();
        }
        assertEquals(CUSTOMER_NAME, testCustomer.getName());
        assertEquals(CUSTOMER_EMAIL, testCustomer.getEmail());
        assertEquals(CUSTOMER_SURNAME, testCustomer.getSurname());
    }
}
