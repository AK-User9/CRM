package crm.controller;

import crm.entity.Contract;
import crm.service.ContractService;
import crm.service.CustomerService;
import crm.service.UserService;
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

public class ContractControllerTest {

    @Mock
    private ContractService contractService;

    @Mock
    private CustomerService customerService;

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private ContractController contractController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowAllContracts() {
        when(contractService.listAllContracts()).thenReturn(Arrays.asList());
        String result = contractController.showAllContracts(model);
        assertEquals("contract/list", result);
        verify(model, times(1)).addAttribute(eq("contracts"), any());
    }

    @Test
    public void testShowFormAddContract() {
        when(customerService.findAllByEnabledTrue()).thenReturn(Arrays.asList());
        when(userService.listAllUsers()).thenReturn(Arrays.asList());

        String result = contractController.showFormAddContract(model);

        assertEquals("contract/add", result);
        verify(model, times(1)).addAttribute(eq("contract"), any(Contract.class));
    }

    @Test
    public void testProcessRequestAddContractSuccess() {
        Contract contract = new Contract();
        when(bindingResult.hasErrors()).thenReturn(false);

        String result = contractController.processRequestAddContract(contract, bindingResult);

        assertEquals("contract/success", result);
        verify(contractService, times(1)).saveContract(contract);
    }

    @Test
    public void testProcessRequestAddContractWithErrors() {
        Contract contract = new Contract();
        when(bindingResult.hasErrors()).thenReturn(true);

        String result = contractController.processRequestAddContract(contract, bindingResult);

        assertEquals("redirect:/contract/add", result);
    }

    @Test
    public void testShowFormEditContract() {
        Long contractId = 1L;
        Contract contract = new Contract();
        when(contractService.showContract(contractId)).thenReturn(contract);

        String result = contractController.showFormEditContract(model, contractId);

        assertEquals("contract/edit", result);
        verify(model, times(1)).addAttribute("contract", contract);
    }

    @Test
    public void testProcessRequestEditContractSuccess() {
        Long contractId = 1L;
        Contract contract = new Contract();
        when(bindingResult.hasErrors()).thenReturn(false);

        String result = contractController.processRequestEditContract(contractId, contract, bindingResult);

        assertEquals("redirect:/contract/list", result);
        verify(contractService, times(1)).saveContract(contract);
    }

    @Test
    public void testShowNameSearchForm() {
        String result = contractController.showNameSearchForm(model);
        assertEquals("contract/name-search", result);
    }

    @Test
    public void testProcessRequestNameSearch() {
        Contract contract = new Contract();
        contract.setName("Test Contract");

        String result = contractController.processRequestNameSearch(contract, model);

        assertEquals("contract/show-one", result);
        verify(contractService, times(1)).findByName("Test Contract");
    }

    @Test
    public void testShowValueLeesThanEqualSearchForm() {
        String result = contractController.showValueLeesThanEqualSearchForm(model);
        assertEquals("contract/value-le-search", result);
    }

    @Test
    public void testShowValueGreaterThanEqualSearchForm() {
        String result = contractController.showValueGreaterThanEqualSearchForm(model);
        assertEquals("contract/value-ge-search", result);
    }

    @Test
    public void testShowBeginDateSearchForm() {
        String result = contractController.showBeginDateSearchForm(model);
        assertEquals("contract/begin-date-search", result);
    }

    @Test
    public void testShowEndDateSearchForm() {
        String result = contractController.showEndDateSearchForm(model);
        assertEquals("contract/end-date-search", result);
    }

    @Test
    public void testShowStatusSearchForm() {
        String result = contractController.showStatusSearchForm(model);
        assertEquals("contract/status-search", result);
    }

    @Test
    public void testControllerAnnotation() {
        assertTrue(ContractController.class.isAnnotationPresent(org.springframework.stereotype.Controller.class));
    }

    @Test
    public void testRequestMappingAnnotation() {
        assertTrue(ContractController.class.isAnnotationPresent(org.springframework.web.bind.annotation.RequestMapping.class));
    }
}
