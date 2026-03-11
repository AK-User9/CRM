package crm.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CurrentUserTest {

    private CurrentUser currentUser;

    @Mock
    private User mockUser;

    private Set<GrantedAuthority> authorities;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        currentUser = new CurrentUser();
        authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Test
    public void testGetAuthorities() {
        currentUser.setAuthorities(authorities);
        Collection<? extends GrantedAuthority> result = currentUser.getAuthorities();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(new SimpleGrantedAuthority("ROLE_USER")));
        assertTrue(result.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    @Test
    public void testGetAuthoritiesEmpty() {
        currentUser.setAuthorities(new HashSet<>());
        Collection<? extends GrantedAuthority> result = currentUser.getAuthorities();
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testGetPassword() {
        when(mockUser.getPassword()).thenReturn("testPassword123");
        currentUser.setUser(mockUser);

        String password = currentUser.getPassword();
        assertEquals("testPassword123", password);
        verify(mockUser, times(1)).getPassword();
    }

    @Test
    public void testGetPasswordNull() {
        when(mockUser.getPassword()).thenReturn(null);
        currentUser.setUser(mockUser);

        String password = currentUser.getPassword();
        assertNull(password);
    }

    @Test
    public void testGetUsername() {
        when(mockUser.getUsername()).thenReturn("testUser");
        currentUser.setUser(mockUser);

        String username = currentUser.getUsername();
        assertEquals("testUser", username);
        verify(mockUser, times(1)).getUsername();
    }

    @Test
    public void testGetUsernameNull() {
        when(mockUser.getUsername()).thenReturn(null);
        currentUser.setUser(mockUser);

        String username = currentUser.getUsername();
        assertNull(username);
    }

    @Test
    public void testIsAccountNonExpired() {
        assertTrue(currentUser.isAccountNonExpired());
    }

    @Test
    public void testIsAccountNonLocked() {
        assertTrue(currentUser.isAccountNonLocked());
    }

    @Test
    public void testIsCredentialsNonExpired() {
        assertTrue(currentUser.isCredentialsNonExpired());
    }

    @Test
    public void testIsEnabled() {
        assertTrue(currentUser.isEnabled());
    }

    @Test
    public void testSetAndGetUser() {
        currentUser.setUser(mockUser);
        assertNotNull(currentUser.getUser());
        assertEquals(mockUser, currentUser.getUser());
    }

    @Test
    public void testSetAndGetAuthorities() {
        currentUser.setAuthorities(authorities);
        assertNotNull(currentUser.getAuthorities());
        assertEquals(authorities, currentUser.getAuthorities());
    }

    @Test
    public void testUserDetailsInterface() {
        // Verify that CurrentUser implements UserDetails
        assertTrue(org.springframework.security.core.userdetails.UserDetails.class.isAssignableFrom(CurrentUser.class));
    }

    @Test
    public void testCurrentUserCreation() {
        CurrentUser newUser = new CurrentUser();
        assertNotNull(newUser);
    }

    @Test
    public void testEqualsAndHashCode() {
        CurrentUser user1 = new CurrentUser();
        CurrentUser user2 = new CurrentUser();

        user1.setUser(mockUser);
        user1.setAuthorities(authorities);

        user2.setUser(mockUser);
        user2.setAuthorities(authorities);

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }
}
