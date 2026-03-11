package crm.service;

import crm.entity.Contract;
import crm.entity.Customer;
import crm.entity.Status;
import crm.entity.User;
import crm.repository.ContractRepository;
import crm.repository.CustomerRepository;
import crm.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ContractServiceImplTest {

    @Mock
    private ContractRepository contractRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ContractServiceImpl contractService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByName() {
        String contractName = "Test Contract";
        Contract contract = new Contract();
        contract.setName(contractName);

        when(contractRepository.findByName(contractName)).thenReturn(contract);

        Contract result = contractService.findByName(contractName);

        assertNotNull(result);
        assertEquals(contractName, result.getName());
    }

    @Test
    public void testListAllContracts() {
        when(contractRepository.findAll()).thenReturn(Arrays.asList());

        Iterable<Contract> result = contractService.listAllContracts();

        assertNotNull(result);
        verify(contractRepository, times(1)).findAll();
    }

    @Test
    public void testShowContract() {
        Long contractId = 1L;
        Contract contract = new Contract();
        contract.setId(contractId);

        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));

        Contract result = contractService.showContract(contractId);

        assertNotNull(result);
        assertEquals(contractId, result.getId());
    }

    @Test
    public void testFindAllByValueLessThanEqual() {
        BigDecimal value = new BigDecimal("10000");
        when(contractRepository.findAllByValueLessThanEqual(value)).thenReturn(Arrays.asList());

        Iterable<Contract> result = contractService.findAllByValueLessThanEqual(value);

        assertNotNull(result);
        verify(contractRepository, times(1)).findAllByValueLessThanEqual(value);
    }

    @Test
    public void testFindAllByStatus() {
        Status status = Status.PROPOSED;
        when(contractRepository.findAllByStatus(status)).thenReturn(Arrays.asList());

        Iterable<Contract> result = contractService.findAllByStatus(status);

        assertNotNull(result);
        verify(contractRepository, times(1)).findAllByStatus(status);
    }

    @Test
    public void testFindAllByBeginDate() {
        LocalDate beginDate = LocalDate.now();
        when(contractRepository.findAllByBeginDate(beginDate)).thenReturn(Arrays.asList());

        Iterable<Contract> result = contractService.findAllByBeginDate(beginDate);

        assertNotNull(result);
    }

    @Test
    public void testServiceAnnotation() {
        assertTrue(ContractServiceImpl.class.isAnnotationPresent(org.springframework.stereotype.Service.class));
    }
}
