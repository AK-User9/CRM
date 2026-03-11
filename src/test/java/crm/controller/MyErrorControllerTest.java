package crm.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class MyErrorControllerTest {

    @InjectMocks
    private MyErrorController myErrorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testErrorMethod() {
        String result = myErrorController.error();
        assertEquals("error", result);
    }

    @Test
    public void testImplementsErrorController() {
        assertTrue(org.springframework.boot.web.servlet.error.ErrorController.class.isAssignableFrom(MyErrorController.class));
    }

    @Test
    public void testControllerAnnotation() {
        assertTrue(MyErrorController.class.isAnnotationPresent(org.springframework.stereotype.Controller.class));
    }

    @Test
    public void testMyErrorControllerCreation() {
        assertNotNull(myErrorController);
    }
}
