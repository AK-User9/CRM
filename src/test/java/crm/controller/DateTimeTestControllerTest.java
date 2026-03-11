package crm.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DateTimeTestControllerTest {

    @Mock
    private Model model;

    @InjectMocks
    private DateTimeTestController dateTimeTestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDateTimeTestControllerCreation() {
        assertNotNull(dateTimeTestController);
    }

    @Test
    public void testDateTimeTest() {
        String result = dateTimeTestController.dateTimeTest(model);

        assertEquals("date/test", result);
        verify(model, times(1)).addAttribute(eq("standardDate"), any());
        verify(model, times(1)).addAttribute(eq("localDateTime"), any());
        verify(model, times(1)).addAttribute(eq("localDate"), any());
        verify(model, times(1)).addAttribute(eq("timestamp"), any());
    }

    @Test
    public void testDateTimeTestAddsAllAttributes() {
        dateTimeTestController.dateTimeTest(model);

        verify(model, times(4)).addAttribute(anyString(), any());
    }

    @Test
    public void testControllerAnnotation() {
        assertTrue(DateTimeTestController.class.isAnnotationPresent(org.springframework.stereotype.Controller.class));
    }

    @Test
    public void testRequestMappingAnnotation() {
        assertTrue(DateTimeTestController.class.isAnnotationPresent(org.springframework.web.bind.annotation.RequestMapping.class));
    }

    @Test
    public void testDateTimeTestMapping() throws NoSuchMethodException {
        assertTrue(DateTimeTestController.class.getMethod("dateTimeTest", Model.class)
                .isAnnotationPresent(org.springframework.web.bind.annotation.GetMapping.class));
    }

    @Test
    public void testDateTimeTestReturnsCorrectView() {
        String viewName = dateTimeTestController.dateTimeTest(model);
        assertTrue(viewName.contains("date"));
        assertTrue(viewName.contains("test"));
    }
}
