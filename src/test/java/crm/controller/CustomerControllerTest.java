package crm.controller;

import crm.entity.Customer;
import crm.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowAllCustomers() {
        when(customerService.listAllCustomers()).thenReturn(Arrays.asList());
        String result = customerController.showAllCustomers(model);
        assertEquals("customer/list", result);
        verify(model, times(1)).addAttribute(eq("customers"), any());
    }

    @Test
    public void testShowFormAddCustomer() {
        String result = customerController.showFormAddCustomer(model);
        assertEquals("customer/add", result);
        verify(model, times(1)).addAttribute(eq("customer"), any(Customer.class));
    }

    @Test
    public void testProcessRequestAddCustomerSuccess() {
        Customer customer = new Customer();
        when(bindingResult.hasErrors()).thenReturn(false);

        String result = customerController.processRequestAddCustomer(customer, bindingResult);

        assertEquals("customer/success", result);
        verify(customerService, times(1)).saveCustomer(customer);
    }

    @Test
    public void testProcessRequestAddCustomerWithErrors() {
        Customer customer = new Customer();
        when(bindingResult.hasErrors()).thenReturn(true);

        String result = customerController.processRequestAddCustomer(customer, bindingResult);

        assertEquals("redirect:/customer/add", result);
    }

    @Test
    public void testShowFormEditCustomer() {
        Long customerId = 1L;
        Customer customer = new Customer();
        when(customerService.showCustomer(customerId)).thenReturn(customer);

        String result = customerController.showFormEditCustomer(model, customerId);

        assertEquals("customer/edit", result);
        verify(model, times(1)).addAttribute("customer", customer);
    }

    @Test
    public void testProcessRequestEditCustomerSuccess() {
        Long customerId = 1L;
        Customer customer = new Customer();
        when(bindingResult.hasErrors()).thenReturn(false);

        String result = customerController.processRequestEditCustomer(customerId, customer, bindingResult);

        assertEquals("redirect:/customer/list", result);
        verify(customerService, times(1)).saveCustomer(customer);
    }

    @Test
    public void testShowNameSearchForm() {
        String result = customerController.showNameSearchForm(model);
        assertEquals("customer/name-search", result);
    }

    @Test
    public void testProcessRequestNameSearch() {
        Customer customer = new Customer();
        customer.setName("Test");

        String result = customerController.processRequestNameSearch(customer, model);

        assertEquals("customer/show-one", result);
        verify(customerService, times(1)).findOneByEnabledTrueAndName("Test");
    }

    @Test
    public void testShowEmailSearchForm() {
        String result = customerController.showEmailSearchForm(model);
        assertEquals("customer/email-search", result);
    }

    @Test
    public void testShowPhoneSearchForm() {
        String result = customerController.showPhoneSearchForm(model);
        assertEquals("customer/phone-search", result);
    }

    @Test
    public void testShowFirstNameSearchForm() {
        String result = customerController.showFirstNameSearchForm(model);
        assertEquals("customer/first-name-search", result);
    }

    @Test
    public void testShowLastNameSearchForm() {
        String result = customerController.showLastNameSearchForm(model);
        assertEquals("customer/last-name-search", result);
    }

    @Test
    public void testShowCitySearchForm() {
        String result = customerController.showCitySearchForm(model);
        assertEquals("customer/city-search", result);
    }

    @Test
    public void testControllerAnnotation() {
        assertTrue(CustomerController.class.isAnnotationPresent(org.springframework.stereotype.Controller.class));
    }

    @Test
    public void testRequestMappingAnnotation() {
        assertTrue(CustomerController.class.isAnnotationPresent(org.springframework.web.bind.annotation.RequestMapping.class));
    }
}
