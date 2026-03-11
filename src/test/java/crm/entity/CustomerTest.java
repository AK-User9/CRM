package crm.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void testCustomerCreation() {
        assertNotNull(customer);
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        customer.setId(id);
        assertEquals(id, customer.getId());
    }

    @Test
    public void testSetAndGetName() {
        String name = "Test Customer";
        customer.setName(name);
        assertEquals(name, customer.getName());
    }

    @Test
    public void testSetAndGetEmail() {
        String email = "test@example.com";
        customer.setEmail(email);
        assertEquals(email, customer.getEmail());
    }

    @Test
    public void testSetAndGetPhone() {
        int phone = 123456789;
        customer.setPhone(phone);
        assertEquals(phone, customer.getPhone());
    }

    @Test
    public void testSetAndGetFirstName() {
        String firstName = "John";
        customer.setFirstName(firstName);
        assertEquals(firstName, customer.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String lastName = "Doe";
        customer.setLastName(lastName);
        assertEquals(lastName, customer.getLastName());
    }

    @Test
    public void testSetAndGetCity() {
        String city = "New York";
        customer.setCity(city);
        assertEquals(city, customer.getCity());
    }

    @Test
    public void testSetAndGetAddress() {
        String address = "123 Main St";
        customer.setAddress(address);
        assertEquals(address, customer.getAddress());
    }

    @Test
    public void testSetAndGetEnabled() {
        int enabled = 1;
        customer.setEnabled(enabled);
        assertEquals(enabled, customer.getEnabled());
    }

    @Test
    public void testSetAndGetCategories() {
        Set<Category> categories = new HashSet<>();
        Category category = new Category();
        category.setId(1L);
        category.setName("VIP");
        categories.add(category);

        customer.setCategories(categories);
        assertEquals(categories, customer.getCategories());
        assertEquals(1, customer.getCategories().size());
    }

    @Test
    public void testBuilderPattern() {
        Customer builtCustomer = Customer.builder()
                .id(1L)
                .name("Builder Customer")
                .email("builder@example.com")
                .phone(987654321)
                .firstName("Jane")
                .lastName("Smith")
                .city("Boston")
                .address("456 Oak Ave")
                .enabled(1)
                .build();

        assertNotNull(builtCustomer);
        assertEquals("Builder Customer", builtCustomer.getName());
        assertEquals("builder@example.com", builtCustomer.getEmail());
    }

    @Test
    public void testAllArgsConstructor() {
        Set<Category> categories = new HashSet<>();
        Customer customer = new Customer(1L, "Customer Name", "email@test.com",
            123456789, categories, "First", "Last", "City", "Address", 1);

        assertNotNull(customer);
        assertEquals(1L, customer.getId());
        assertEquals("Customer Name", customer.getName());
    }

    @Test
    public void testNoArgsConstructor() {
        Customer newCustomer = new Customer();
        assertNotNull(newCustomer);
    }

    @Test
    public void testEqualsAndHashCode() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("Test");
        customer1.setEmail("test@test.com");

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Test");
        customer2.setEmail("test@test.com");

        assertEquals(customer1, customer2);
        assertEquals(customer1.hashCode(), customer2.hashCode());
    }

    @Test
    public void testToString() {
        customer.setName("Test Customer");
        String toString = customer.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("Test Customer"));
    }
}
