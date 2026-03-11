package crm.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;
    private Role role;

    @BeforeEach
    public void setUp() {
        user = new User();
        role = new Role();
        role.setId(1);
        role.setName("ROLE_USER");
    }

    @Test
    public void testUserCreation() {
        assertNotNull(user);
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void testSetAndGetUsername() {
        String username = "testuser";
        user.setUsername(username);
        assertEquals(username, user.getUsername());
    }

    @Test
    public void testSetAndGetEmail() {
        String email = "test@example.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testSetAndGetFirstName() {
        String firstName = "John";
        user.setFirstName(firstName);
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String lastName = "Doe";
        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName());
    }

    @Test
    public void testSetAndGetPassword() {
        String password = "password123";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testSetAndGetEnabled() {
        int enabled = 1;
        user.setEnabled(enabled);
        assertEquals(enabled, user.getEnabled());
    }

    @Test
    public void testSetAndGetRole() {
        user.setRole(role);
        assertEquals(role, user.getRole());
    }

    @Test
    public void testGetColumnCount() {
        int columnCount = user.getColumnCount();
        assertTrue(columnCount > 0);
    }

    @Test
    public void testGetRoleId() {
        user.setRole(role);
        assertEquals(1, user.getRole_id());
    }

    @Test
    public void testGetRoleName() {
        user.setRole(role);
        assertEquals("ROLE_USER", user.getRole_name());
    }

    @Test
    public void testGetName() {
        user.setFirstName("John");
        user.setLastName("Doe");
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testGetNameWithNulls() {
        String name = user.getName();
        assertNotNull(name);
    }

    @Test
    public void testBuilderPattern() {
        User builtUser = User.builder()
                .id(1L)
                .username("builderuser")
                .email("builder@example.com")
                .firstName("Jane")
                .lastName("Smith")
                .password("pass123")
                .enabled(1)
                .role(role)
                .build();

        assertNotNull(builtUser);
        assertEquals("builderuser", builtUser.getUsername());
        assertEquals("builder@example.com", builtUser.getEmail());
    }

    @Test
    public void testAllArgsConstructor() {
        User newUser = new User(1L, "testuser", "test@test.com",
            "First", "Last", "password", 1, role);

        assertNotNull(newUser);
        assertEquals(1L, newUser.getId());
        assertEquals("testuser", newUser.getUsername());
    }

    @Test
    public void testNoArgsConstructor() {
        User newUser = new User();
        assertNotNull(newUser);
    }

    @Test
    public void testEqualsAndHashCode() {
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");
        user1.setEmail("user1@test.com");

        User user2 = new User();
        user2.setId(1L);
        user2.setUsername("user1");
        user2.setEmail("user1@test.com");

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testToString() {
        user.setUsername("testuser");
        String toString = user.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("testuser"));
    }
}
