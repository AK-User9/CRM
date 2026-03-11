package crm.controller;

import crm.entity.Customer;
import crm.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CSVControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private HttpServletResponse response;

    @InjectMocks
    private CSVController csvController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCSVControllerCreation() {
        assertNotNull(csvController);
    }

    @Test
    public void testConstructorWithCustomerService() {
        CustomerService mockService = mock(CustomerService.class);
        CSVController controller = new CSVController(mockService);
        assertNotNull(controller);
    }

    @Test
    public void testFindCustomers() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Test Customer");

        List<Customer> customers = Arrays.asList(customer);
        when(customerService.listAllCustomers()).thenReturn(customers);

        csvController.findCustomers(response);

        verify(customerService, times(1)).listAllCustomers();
        verify(response, times(1)).getWriter();
    }

    @Test
    public void testFindCustomer() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("Test Customer");

        when(customerService.showCustomer(customerId)).thenReturn(customer);

        csvController.findCustomer(customerId, response);

        verify(customerService, times(1)).showCustomer(customerId);
        verify(response, times(1)).getWriter();
    }

    @Test
    public void testFindCustomersEmpty() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        List<Customer> emptyList = Arrays.asList();
        when(customerService.listAllCustomers()).thenReturn(emptyList);

        assertDoesNotThrow(() -> csvController.findCustomers(response));
    }

    @Test
    public void testFindCustomerNull() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        Long customerId = 999L;
        when(customerService.showCustomer(customerId)).thenReturn(null);

        assertDoesNotThrow(() -> csvController.findCustomer(customerId, response));
    }

    @Test
    public void testRestControllerAnnotation() {
        assertTrue(CSVController.class.isAnnotationPresent(org.springframework.web.bind.annotation.RestController.class));
    }

    @Test
    public void testFindCustomersMapping() throws NoSuchMethodException {
        assertTrue(CSVController.class.getMethod("findCustomers", HttpServletResponse.class)
                .isAnnotationPresent(org.springframework.web.bind.annotation.GetMapping.class));
    }

    @Test
    public void testFindCustomerMapping() throws NoSuchMethodException {
        assertTrue(CSVController.class.getMethod("findCustomer", Long.class, HttpServletResponse.class)
                .isAnnotationPresent(org.springframework.web.bind.annotation.GetMapping.class));
    }
}
