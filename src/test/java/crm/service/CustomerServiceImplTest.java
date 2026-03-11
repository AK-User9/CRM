package crm.service;

import crm.entity.Customer;
import crm.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMaxId() {
        when(customerRepository.getMaxId()).thenReturn(100L);

        Long result = customerService.getMaxId();

        assertEquals(100L, result);
        verify(customerRepository, times(1)).getMaxId();
    }

    @Test
    public void testListAllCustomers() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList());

        Iterable<Customer> result = customerService.listAllCustomers();

        assertNotNull(result);
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void testShowCustomer() {
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setId(customerId);

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        Customer result = customerService.showCustomer(customerId);

        assertNotNull(result);
        assertEquals(customerId, result.getId());
    }

    @Test
    public void testFindAllByEnabledTrue() {
        when(customerRepository.findAllByEnabled(1)).thenReturn(Arrays.asList());

        Iterable<Customer> result = customerService.findAllByEnabledTrue();

        assertNotNull(result);
        verify(customerRepository, times(1)).findAllByEnabled(1);
    }

    @Test
    public void testFindOneByName() {
        String name = "Test Customer";
        Customer customer = new Customer();
        customer.setName(name);

        when(customerRepository.findOneByName(name)).thenReturn(customer);

        Customer result = customerService.findOneByName(name);

        assertNotNull(result);
        assertEquals(name, result.getName());
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setName("New Customer");

        customerService.saveCustomer(customer);

        assertEquals(1, customer.getEnabled());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testServiceAnnotation() {
        assertTrue(CustomerServiceImpl.class.isAnnotationPresent(org.springframework.stereotype.Service.class));
    }
}
