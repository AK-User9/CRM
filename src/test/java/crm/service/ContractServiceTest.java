package crm.service;

import crm.entity.Contract;
import crm.entity.Customer;
import crm.entity.Status;
import crm.entity.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ContractServiceTest {

    @Test
    public void testContractServiceIsInterface() {
        assertTrue(ContractService.class.isInterface());
    }

    @Test
    public void testFindByNameMethodExists() {
        try {
            ContractService.class.getMethod("findByName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByName method should exist");
        }
    }

    @Test
    public void testListAllContractsMethodExists() {
        try {
            ContractService.class.getMethod("listAllContracts");
        } catch (NoSuchMethodException e) {
            fail("listAllContracts method should exist");
        }
    }

    @Test
    public void testShowContractMethodExists() {
        try {
            ContractService.class.getMethod("showContract", Long.class);
        } catch (NoSuchMethodException e) {
            fail("showContract method should exist");
        }
    }

    @Test
    public void testFindAllByValueLessThanEqualMethodExists() {
        try {
            ContractService.class.getMethod("findAllByValueLessThanEqual", BigDecimal.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByValueLessThanEqual method should exist");
        }
    }

    @Test
    public void testFindAllByValueGreaterThanEqualMethodExists() {
        try {
            ContractService.class.getMethod("findAllByValueGreaterThanEqual", BigDecimal.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByValueGreaterThanEqual method should exist");
        }
    }

    @Test
    public void testFindAllByBeginDateMethodExists() {
        try {
            ContractService.class.getMethod("findAllByBeginDate", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByBeginDate method should exist");
        }
    }

    @Test
    public void testFindAllByBeginDateBeforeMethodExists() {
        try {
            ContractService.class.getMethod("findAllByBeginDateBefore", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByBeginDateBefore method should exist");
        }
    }

    @Test
    public void testFindAllByBeginDateAfterMethodExists() {
        try {
            ContractService.class.getMethod("findAllByBeginDateAfter", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByBeginDateAfter method should exist");
        }
    }

    @Test
    public void testFindAllByEndDateMethodExists() {
        try {
            ContractService.class.getMethod("findAllByEndDate", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByEndDate method should exist");
        }
    }

    @Test
    public void testFindAllByEndDateBeforeMethodExists() {
        try {
            ContractService.class.getMethod("findAllByEndDateBefore", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByEndDateBefore method should exist");
        }
    }

    @Test
    public void testFindAllByEndDateAfterMethodExists() {
        try {
            ContractService.class.getMethod("findAllByEndDateAfter", LocalDate.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByEndDateAfter method should exist");
        }
    }

    @Test
    public void testFindAllByStatusMethodExists() {
        try {
            ContractService.class.getMethod("findAllByStatus", Status.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByStatus method should exist");
        }
    }

    @Test
    public void testFindAllByCustomerMethodExists() {
        try {
            ContractService.class.getMethod("findAllByCustomer", Customer.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByCustomer method should exist");
        }
    }

    @Test
    public void testFindAllByCustomerAndUserMethodExists() {
        try {
            ContractService.class.getMethod("findAllByCustomerAndUser", Customer.class, User.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByCustomerAndUser method should exist");
        }
    }

    @Test
    public void testFindAllByUserMethodExists() {
        try {
            ContractService.class.getMethod("findAllByUser", User.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByUser method should exist");
        }
    }

    @Test
    public void testSaveContractMethodExists() {
        try {
            ContractService.class.getMethod("saveContract", Contract.class);
        } catch (NoSuchMethodException e) {
            fail("saveContract method should exist");
        }
    }

    @Test
    public void testFindByNameReturnType() throws NoSuchMethodException {
        assertEquals(Contract.class, ContractService.class.getMethod("findByName", String.class).getReturnType());
    }

    @Test
    public void testListAllContractsReturnType() throws NoSuchMethodException {
        assertEquals(Iterable.class, ContractService.class.getMethod("listAllContracts").getReturnType());
    }

    @Test
    public void testShowContractReturnType() throws NoSuchMethodException {
        assertEquals(Contract.class, ContractService.class.getMethod("showContract", Long.class).getReturnType());
    }
}
