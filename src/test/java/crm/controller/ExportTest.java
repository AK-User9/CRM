package crm.controller;

import crm.entity.User;
import crm.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExportTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private Export exportController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExportControllerCreation() {
        assertNotNull(exportController);
    }

    @Test
    public void testConstructorWithUserService() {
        UserService mockService = mock(UserService.class);
        Export controller = new Export(mockService);
        assertNotNull(controller);
    }

    @Test
    public void testDownload() {
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");

        List<User> users = Arrays.asList(user1, user2);
        when(userService.listAllUsers()).thenReturn(users);

        String result = exportController.download(model);

        verify(userService, times(1)).listAllUsers();
        verify(model, times(1)).addAttribute("users", users);
        assertEquals("", result);
    }

    @Test
    public void testDownloadEmpty() {
        List<User> emptyList = Arrays.asList();
        when(userService.listAllUsers()).thenReturn(emptyList);

        String result = exportController.download(model);

        verify(userService, times(1)).listAllUsers();
        verify(model, times(1)).addAttribute("users", emptyList);
    }

    @Test
    public void testControllerAnnotation() {
        assertTrue(Export.class.isAnnotationPresent(org.springframework.stereotype.Controller.class));
    }

    @Test
    public void testDownloadMapping() throws NoSuchMethodException {
        assertTrue(Export.class.getMethod("download", Model.class)
                .isAnnotationPresent(org.springframework.web.bind.annotation.GetMapping.class));
    }

    @Test
    public void testDownloadReturnsEmptyString() {
        when(userService.listAllUsers()).thenReturn(Arrays.asList());
        String result = exportController.download(model);
        assertEquals("", result);
    }
}
