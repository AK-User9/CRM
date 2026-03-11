package crm.service;

import crm.entity.CurrentUser;
import crm.entity.Role;
import crm.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SpringDataUserDetailsServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private SpringDataUserDetailsService userDetailsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsernameSuccess() {
        String username = "testuser";
        Role role = new Role();
        role.setName("ROLE_USER");

        User user = new User();
        user.setUsername(username);
        user.setPassword("password");
        user.setRole(role);

        when(userService.findByUsername(username)).thenReturn(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        verify(userService, times(1)).findByUsername(username);
        assertTrue(userDetails instanceof CurrentUser);
    }

    @Test
    public void testLoadUserByUsernameNotFound() {
        String username = "nonexistent";
        when(userService.findByUsername(username)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(username);
        });

        verify(userService, times(1)).findByUsername(username);
    }

    @Test
    public void testLoadUserByUsernameWithAdminRole() {
        String username = "admin";
        Role role = new Role();
        role.setName("ROLE_ADMIN");

        User user = new User();
        user.setUsername(username);
        user.setPassword("adminpass");
        user.setRole(role);

        when(userService.findByUsername(username)).thenReturn(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        assertEquals(1, userDetails.getAuthorities().size());
    }

    @Test
    public void testLoadUserByUsernameGrantedAuthorities() {
        String username = "testuser";
        Role role = new Role();
        role.setName("ROLE_USER");

        User user = new User();
        user.setUsername(username);
        user.setRole(role);

        when(userService.findByUsername(username)).thenReturn(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        assertNotNull(userDetails.getAuthorities());
        assertEquals(1, userDetails.getAuthorities().size());
    }

    @Test
    public void testImplementsUserDetailsService() {
        assertTrue(UserDetailsService.class.isAssignableFrom(SpringDataUserDetailsService.class));
    }

    @Test
    public void testServiceAnnotation() {
        assertTrue(SpringDataUserDetailsService.class.isAnnotationPresent(org.springframework.stereotype.Service.class));
    }

    @Test
    public void testLoadUserByUsernameNull() {
        when(userService.findByUsername(null)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(null);
        });
    }

    @Test
    public void testLoadUserByUsernameEmptyString() {
        String emptyUsername = "";
        when(userService.findByUsername(emptyUsername)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(emptyUsername);
        });
    }

    @Test
    public void testLoadUserByUsernameReturnsCurrentUser() {
        String username = "user1";
        Role role = new Role();
        role.setName("ROLE_EMPLOYEE");

        User user = new User();
        user.setUsername(username);
        user.setRole(role);

        when(userService.findByUsername(username)).thenReturn(user);

        UserDetails result = userDetailsService.loadUserByUsername(username);

        assertTrue(result instanceof CurrentUser);
        CurrentUser currentUser = (CurrentUser) result;
        assertEquals(user, currentUser.getUser());
    }
}
