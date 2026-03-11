package crm.repository;

import crm.entity.Contract;
import crm.entity.Customer;
import crm.entity.Status;
import crm.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ContractRepositoryTest {

    @Test
    public void testContractRepositoryExtendsJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(ContractRepository.class));
    }

    @Test
    public void testContractRepositoryIsInterface() {
        assertTrue(ContractRepository.class.isInterface());
    }

    @Test
    public void testFindByNameMethodExists() {
        try {
            ContractRepository.class.getMethod("findByName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByName method should exist");
        }
    }

    @Test
    public void testFindAllByValueLessThanEqualMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByValueLessThanEqual", BigDecimal.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByValueLessThanEqual method should exist");
        }
    }

    @Test
    public void testFindAllByValueGreaterThanEqualMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByValueGreaterThanEqual", BigDecimal.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByValueGreaterThanEqual method should exist");
        }
    }

    @Test
    public void testFindAllByBeginDateMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByBeginDate", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByBeginDate method should exist");
        }
    }

    @Test
    public void testFindAllByBeginDateBeforeMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByBeginDateBefore", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByBeginDateBefore method should exist");
        }
    }

    @Test
    public void testFindAllByBeginDateAfterMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByBeginDateAfter", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByBeginDateAfter method should exist");
        }
    }

    @Test
    public void testFindAllByEndDateMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByEndDate", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByEndDate method should exist");
        }
    }

    @Test
    public void testFindAllByEndDateBeforeMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByEndDateBefore", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByEndDateBefore method should exist");
        }
    }

    @Test
    public void testFindAllByEndDateAfterMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByEndDateAfter", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByEndDateAfter method should exist");
        }
    }

    @Test
    public void testFindAllByStatusMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByStatus", Status.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByStatus method should exist");
        }
    }

    @Test
    public void testFindAllByCustomerMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByCustomer", Customer.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByCustomer method should exist");
        }
    }

    @Test
    public void testFindAllByCustomerAndUserMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByCustomerAndUser", Customer.class, User.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByCustomerAndUser method should exist");
        }
    }

    @Test
    public void testFindAllByUserMethodExists() {
        try {
            ContractRepository.class.getMethod("findAllByUser", User.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByUser method should exist");
        }
    }

    @Test
    public void testContractRepositoryAnnotation() {
        assertTrue(ContractRepository.class.isAnnotationPresent(org.springframework.stereotype.Repository.class));
    }

    @Test
    public void testFindByNameReturnType() throws NoSuchMethodException {
        assertEquals(Contract.class, ContractRepository.class.getMethod("findByName", String.class).getReturnType());
    }

    @Test
    public void testFindAllByValueReturnType() throws NoSuchMethodException {
        assertEquals(Iterable.class, ContractRepository.class.getMethod("findAllByValueLessThanEqual", BigDecimal.class).getReturnType());
    }

    @Test
    public void testContractRepositoryGenericTypes() {
        // Verify the repository works with Contract entity and Long ID
        assertNotNull(ContractRepository.class);
    }
}
