package crm.service;

import crm.entity.Category;
import crm.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    @Test
    public void testCustomerServiceIsInterface() {
        assertTrue(CustomerService.class.isInterface());
    }

    @Test
    public void testGetMaxIdMethodExists() {
        try {
            CustomerService.class.getMethod("getMaxId");
        } catch (NoSuchMethodException e) {
            fail("getMaxId method should exist");
        }
    }

    @Test
    public void testListAllCustomersMethodExists() {
        try {
            CustomerService.class.getMethod("listAllCustomers");
        } catch (NoSuchMethodException e) {
            fail("listAllCustomers method should exist");
        }
    }

    @Test
    public void testShowCustomerMethodExists() {
        try {
            CustomerService.class.getMethod("showCustomer", Long.class);
        } catch (NoSuchMethodException e) {
            fail("showCustomer method should exist");
        }
    }

    @Test
    public void testFindAllByEnabledTrueMethodExists() {
        try {
            CustomerService.class.getMethod("findAllByEnabledTrue");
        } catch (NoSuchMethodException e) {
            fail("findAllByEnabledTrue method should exist");
        }
    }

    @Test
    public void testFindAllByEnabledFalseMethodExists() {
        try {
            CustomerService.class.getMethod("findAllByEnabledFalse");
        } catch (NoSuchMethodException e) {
            fail("findAllByEnabledFalse method should exist");
        }
    }

    @Test
    public void testFindOneByEnabledTrueAndNameMethodExists() {
        try {
            CustomerService.class.getMethod("findOneByEnabledTrueAndName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findOneByEnabledTrueAndName method should exist");
        }
    }

    @Test
    public void testFindOneByNameMethodExists() {
        try {
            CustomerService.class.getMethod("findOneByName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findOneByName method should exist");
        }
    }

    @Test
    public void testFindByEmailMethodExists() {
        try {
            CustomerService.class.getMethod("findByEmail", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByEmail method should exist");
        }
    }

    @Test
    public void testFindByPhoneMethodExists() {
        try {
            CustomerService.class.getMethod("findByPhone", int.class);
        } catch (NoSuchMethodException e) {
            fail("findByPhone method should exist");
        }
    }

    @Test
    public void testFindByCategoriesMethodExists() {
        try {
            CustomerService.class.getMethod("findByCategories", Set.class);
        } catch (NoSuchMethodException e) {
            fail("findByCategories method should exist");
        }
    }

    @Test
    public void testFindByFirstNameMethodExists() {
        try {
            CustomerService.class.getMethod("findByFirstName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByFirstName method should exist");
        }
    }

    @Test
    public void testFindByLastNameMethodExists() {
        try {
            CustomerService.class.getMethod("findByLastName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByLastName method should exist");
        }
    }

    @Test
    public void testFindByFirstNameAndLastNameMethodExists() {
        try {
            CustomerService.class.getMethod("findByFirstNameAndLastName", String.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByFirstNameAndLastName method should exist");
        }
    }

    @Test
    public void testFindByCityMethodExists() {
        try {
            CustomerService.class.getMethod("findByCity", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByCity method should exist");
        }
    }

    @Test
    public void testFindByCityAndAddressMethodExists() {
        try {
            CustomerService.class.getMethod("findByCityAndAddress", String.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByCityAndAddress method should exist");
        }
    }

    @Test
    public void testSaveCustomerMethodExists() {
        try {
            CustomerService.class.getMethod("saveCustomer", Customer.class);
        } catch (NoSuchMethodException e) {
            fail("saveCustomer method should exist");
        }
    }

    @Test
    public void testGetMaxIdReturnType() throws NoSuchMethodException {
        assertEquals(Long.class, CustomerService.class.getMethod("getMaxId").getReturnType());
    }

    @Test
    public void testListAllCustomersReturnType() throws NoSuchMethodException {
        assertEquals(Iterable.class, CustomerService.class.getMethod("listAllCustomers").getReturnType());
    }

    @Test
    public void testShowCustomerReturnType() throws NoSuchMethodException {
        assertEquals(Customer.class, CustomerService.class.getMethod("showCustomer", Long.class).getReturnType());
    }

    @Test
    public void testFindOneByNameReturnType() throws NoSuchMethodException {
        assertEquals(Customer.class, CustomerService.class.getMethod("findOneByName", String.class).getReturnType());
    }

    @Test
    public void testSaveCustomerReturnType() throws NoSuchMethodException {
        assertEquals(void.class, CustomerService.class.getMethod("saveCustomer", Customer.class).getReturnType());
    }
}
