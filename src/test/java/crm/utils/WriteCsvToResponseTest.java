package crm.utils;

import crm.entity.Customer;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WriteCsvToResponseTest {

    @Test
    public void testWriteCustomers() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Test Customer");
        customer.setEmail("test@example.com");
        customer.setPhone(123456789);
        customer.setEnabled(1);

        List<Customer> customers = Arrays.asList(customer);

        assertDoesNotThrow(() -> {
            WriteCsvToResponse.writeCustomers(printWriter, customers);
        });
    }

    @Test
    public void testWriteCustomer() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Single Customer");
        customer.setEmail("single@example.com");
        customer.setPhone(987654321);
        customer.setEnabled(1);

        assertDoesNotThrow(() -> {
            WriteCsvToResponse.writeCustomer(printWriter, customer);
        });
    }

    @Test
    public void testWriteCustomersEmpty() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        List<Customer> emptyList = Arrays.asList();

        assertDoesNotThrow(() -> {
            WriteCsvToResponse.writeCustomers(printWriter, emptyList);
        });
    }
}
