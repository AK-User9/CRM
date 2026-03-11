package crm.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ContractTest {

    private Contract contract;

    @BeforeEach
    public void setUp() {
        contract = new Contract();
    }

    @Test
    public void testContractCreation() {
        assertNotNull(contract);
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        contract.setId(id);
        assertEquals(id, contract.getId());
    }

    @Test
    public void testSetAndGetName() {
        String name = "Test Contract";
        contract.setName(name);
        assertEquals(name, contract.getName());
    }

    @Test
    public void testSetAndGetContent() {
        String content = "Contract content here";
        contract.setContent(content);
        assertEquals(content, contract.getContent());
    }

    @Test
    public void testSetAndGetValue() {
        BigDecimal value = new BigDecimal("10000.50");
        contract.setValue(value);
        assertEquals(value, contract.getValue());
    }

    @Test
    public void testSetAndGetBeginDate() {
        LocalDate beginDate = LocalDate.of(2024, 1, 1);
        contract.setBeginDate(beginDate);
        assertEquals(beginDate, contract.getBeginDate());
    }

    @Test
    public void testSetAndGetEndDate() {
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        contract.setEndDate(endDate);
        assertEquals(endDate, contract.getEndDate());
    }

    @Test
    public void testSetAndGetStatus() {
        Status status = Status.PROPOSED;
        contract.setStatus(status);
        assertEquals(status, contract.getStatus());
    }

    @Test
    public void testSetAndGetCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Test Customer");

        contract.setCustomer(customer);
        assertEquals(customer, contract.getCustomer());
    }

    @Test
    public void testSetAndGetUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");

        contract.setUser(user);
        assertEquals(user, contract.getUser());
    }

    @Test
    public void testBuilderPattern() {
        LocalDate beginDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        BigDecimal value = new BigDecimal("50000");

        Contract builtContract = Contract.builder()
                .id(1L)
                .name("Builder Contract")
                .content("Test content")
                .value(value)
                .beginDate(beginDate)
                .endDate(endDate)
                .status(Status.IMPLEMENTED)
                .build();

        assertNotNull(builtContract);
        assertEquals("Builder Contract", builtContract.getName());
        assertEquals(value, builtContract.getValue());
    }

    @Test
    public void testAllArgsConstructor() {
        LocalDate beginDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        BigDecimal value = new BigDecimal("10000");

        Contract newContract = new Contract(1L, "Contract Name", "Content",
            value, beginDate, endDate, Status.PROPOSED, null, null);

        assertNotNull(newContract);
        assertEquals(1L, newContract.getId());
        assertEquals("Contract Name", newContract.getName());
    }

    @Test
    public void testNoArgsConstructor() {
        Contract newContract = new Contract();
        assertNotNull(newContract);
    }

    @Test
    public void testEqualsAndHashCode() {
        Contract contract1 = new Contract();
        contract1.setId(1L);
        contract1.setName("Test");
        contract1.setValue(new BigDecimal("1000"));

        Contract contract2 = new Contract();
        contract2.setId(1L);
        contract2.setName("Test");
        contract2.setValue(new BigDecimal("1000"));

        assertEquals(contract1, contract2);
        assertEquals(contract1.hashCode(), contract2.hashCode());
    }

    @Test
    public void testToString() {
        contract.setName("Test Contract");
        String toString = contract.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("Test Contract"));
    }

    @Test
    public void testStatusEnum() {
        contract.setStatus(Status.PROPOSED);
        assertEquals(Status.PROPOSED, contract.getStatus());

        contract.setStatus(Status.NEGOTIATED);
        assertEquals(Status.NEGOTIATED, contract.getStatus());

        contract.setStatus(Status.IMPLEMENTED);
        assertEquals(Status.IMPLEMENTED, contract.getStatus());

        contract.setStatus(Status.DONE);
        assertEquals(Status.DONE, contract.getStatus());
    }
}
