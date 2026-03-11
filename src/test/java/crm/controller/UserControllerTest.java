package crm.controller;

import crm.entity.User;
import crm.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @Mock
    private UserDetails currentUserDetails;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUserControllerCreation() {
        assertNotNull(userController);
    }

    @Test
    public void testShowAllUsers() {
        String username = "testuser";
        when(currentUserDetails.getUsername()).thenReturn(username);

        User currentUser = new User();
        currentUser.setUsername(username);

        when(userService.findByUsername(username)).thenReturn(currentUser);
        when(userService.listAllUsers()).thenReturn(Arrays.asList(currentUser));

        String result = userController.showAllUsers(model, currentUserDetails);

        assertEquals("user/list", result);
        verify(model, times(1)).addAttribute("currentUser", currentUser);
        verify(model, times(1)).addAttribute(eq("users"), any());
    }

    @Test
    public void testShowFormEditUser() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userService.showUser(userId)).thenReturn(user);

        String result = userController.showFormEditUser(model, userId);

        assertEquals("user/edit", result);
        verify(model, times(1)).addAttribute("user", user);
    }

    @Test
    public void testProcessRequestEditUserSuccess() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(bindingResult.hasErrors()).thenReturn(false);

        String result = userController.processRequestEditUser(userId, user, bindingResult);

        assertEquals("redirect:/user/list", result);
        verify(userService, times(1)).editUser(user);
    }

    @Test
    public void testProcessRequestEditUserWithErrors() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(bindingResult.hasErrors()).thenReturn(true);

        String result = userController.processRequestEditUser(userId, user, bindingResult);

        assertEquals("redirect:/user/edit/" + userId, result);
        verify(userService, never()).editUser(user);
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userService.showUser(userId)).thenReturn(user);

        String result = userController.deleteUser(userId);

        assertEquals("redirect:/user/list", result);
        verify(userService, times(1)).deleteUser(user);
    }

    @Test
    public void testControllerAnnotation() {
        assertTrue(UserController.class.isAnnotationPresent(org.springframework.stereotype.Controller.class));
    }

    @Test
    public void testRequestMappingAnnotation() {
        assertTrue(UserController.class.isAnnotationPresent(org.springframework.web.bind.annotation.RequestMapping.class));
    }

    @Test
    public void testConstructorWithUserService() {
        UserService mockService = mock(UserService.class);
        UserController controller = new UserController(mockService);
        assertNotNull(controller);
    }
}
