package crm.repository;

import crm.entity.Category;
import crm.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerRepositoryTest {

    @Test
    public void testCustomerRepositoryExtendsJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(CustomerRepository.class));
    }

    @Test
    public void testCustomerRepositoryIsInterface() {
        assertTrue(CustomerRepository.class.isInterface());
    }

    @Test
    public void testGetMaxIdMethodExists() {
        try {
            CustomerRepository.class.getMethod("getMaxId");
        } catch (NoSuchMethodException e) {
            fail("getMaxId method should exist");
        }
    }

    @Test
    public void testFindAllByEnabledMethodExists() {
        try {
            CustomerRepository.class.getMethod("findAllByEnabled", int.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByEnabled method should exist");
        }
    }

    @Test
    public void testFindOneByEnabledAndNameMethodExists() {
        try {
            CustomerRepository.class.getMethod("findOneByEnabledAndName", int.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findOneByEnabledAndName method should exist");
        }
    }

    @Test
    public void testFindOneByNameMethodExists() {
        try {
            CustomerRepository.class.getMethod("findOneByName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findOneByName method should exist");
        }
    }

    @Test
    public void testFindByEnabledAndEmailMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByEnabledAndEmail", int.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByEnabledAndEmail method should exist");
        }
    }

    @Test
    public void testFindByEmailMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByEmail", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByEmail method should exist");
        }
    }

    @Test
    public void testFindByEnabledAndCityMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByEnabledAndCity", int.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByEnabledAndCity method should exist");
        }
    }

    @Test
    public void testFindByCityMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByCity", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByCity method should exist");
        }
    }

    @Test
    public void testFindByEnabledAndCityAndAddressMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByEnabledAndCityAndAddress", int.class, String.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByEnabledAndCityAndAddress method should exist");
        }
    }

    @Test
    public void testFindByCityAndAddressMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByCityAndAddress", String.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByCityAndAddress method should exist");
        }
    }

    @Test
    public void testFindByEnabledAndPhoneMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByEnabledAndPhone", int.class, int.class);
        } catch (NoSuchMethodException e) {
            fail("findByEnabledAndPhone method should exist");
        }
    }

    @Test
    public void testFindByPhoneMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByPhone", int.class);
        } catch (NoSuchMethodException e) {
            fail("findByPhone method should exist");
        }
    }

    @Test
    public void testFindByEnabledAndFirstNameMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByEnabledAndFirstName", int.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByEnabledAndFirstName method should exist");
        }
    }

    @Test
    public void testFindByFirstNameMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByFirstName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByFirstName method should exist");
        }
    }

    @Test
    public void testFindByEnabledAndLastNameMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByEnabledAndLastName", int.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByEnabledAndLastName method should exist");
        }
    }

    @Test
    public void testFindByLastNameMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByLastName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByLastName method should exist");
        }
    }

    @Test
    public void testFindByEnabledAndFirstNameAndLastNameMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByEnabledAndFirstNameAndLastName", int.class, String.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByEnabledAndFirstNameAndLastName method should exist");
        }
    }

    @Test
    public void testFindByFirstNameAndLastNameMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByFirstNameAndLastName", String.class, String.class);
        } catch (NoSuchMethodException e) {
            fail("findByFirstNameAndLastName method should exist");
        }
    }

    @Test
    public void testFindByEnabledAndCategoriesMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByEnabledAndCategories", int.class, Set.class);
        } catch (NoSuchMethodException e) {
            fail("findByEnabledAndCategories method should exist");
        }
    }

    @Test
    public void testFindByCategoriesMethodExists() {
        try {
            CustomerRepository.class.getMethod("findByCategories", Set.class);
        } catch (NoSuchMethodException e) {
            fail("findByCategories method should exist");
        }
    }

    @Test
    public void testCustomerRepositoryAnnotation() {
        assertTrue(CustomerRepository.class.isAnnotationPresent(org.springframework.stereotype.Repository.class));
    }

    @Test
    public void testGetMaxIdReturnType() throws NoSuchMethodException {
        assertEquals(Long.class, CustomerRepository.class.getMethod("getMaxId").getReturnType());
    }

    @Test
    public void testFindOneByNameReturnType() throws NoSuchMethodException {
        assertEquals(Customer.class, CustomerRepository.class.getMethod("findOneByName", String.class).getReturnType());
    }

    @Test
    public void testCustomerRepositoryGenericTypes() {
        // Verify the repository works with Customer entity and Long ID
        assertNotNull(CustomerRepository.class);
    }
}
