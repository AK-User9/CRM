package crm.controller;

import crm.entity.User;
import crm.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RegisterControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private RegisterController registerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowRegistrationPage() {
        User user = new User();
        String result = registerController.showRegistrationPage(model, user);

        assertEquals("register", result);
        verify(model, times(1)).addAttribute("user", user);
    }

    @Test
    public void testProcessRegistrationFormSuccess() {
        User user = new User();
        user.setUsername("newuser");

        when(userService.findByUsername("newuser")).thenReturn(null);
        when(bindingResult.hasErrors()).thenReturn(false);

        String result = registerController.processRegistrationForm(model, user, bindingResult);

        assertEquals("success", result);
        verify(userService, times(1)).saveUser(user);
    }

    @Test
    public void testProcessRegistrationFormUserExists() {
        User user = new User();
        user.setUsername("existinguser");

        User existingUser = new User();
        existingUser.setUsername("existinguser");

        when(userService.findByUsername("existinguser")).thenReturn(existingUser);

        String result = registerController.processRegistrationForm(model, user, bindingResult);

        assertEquals("register", result);
        verify(model, times(1)).addAttribute(eq("alreadyRegisteredMessage"), anyString());
        verify(userService, never()).saveUser(user);
    }

    @Test
    public void testProcessRegistrationFormWithErrors() {
        User user = new User();
        user.setUsername("newuser");

        when(userService.findByUsername("newuser")).thenReturn(null);
        when(bindingResult.hasErrors()).thenReturn(true);

        String result = registerController.processRegistrationForm(model, user, bindingResult);

        assertEquals("redirect:/register", result);
        verify(userService, never()).saveUser(user);
    }

    @Test
    public void testControllerAnnotation() {
        assertTrue(RegisterController.class.isAnnotationPresent(org.springframework.stereotype.Controller.class));
    }
}
