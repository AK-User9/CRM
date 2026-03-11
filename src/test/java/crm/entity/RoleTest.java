package crm.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoleTest {

    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role();
    }

    @Test
    public void testRoleCreation() {
        assertNotNull(role);
    }

    @Test
    public void testSetAndGetId() {
        int id = 1;
        role.setId(id);
        assertEquals(id, role.getId());
    }

    @Test
    public void testSetAndGetName() {
        String name = "ROLE_USER";
        role.setName(name);
        assertEquals(name, role.getName());
    }

    @Test
    public void testSetAndGetNameAdmin() {
        String name = "ROLE_ADMIN";
        role.setName(name);
        assertEquals(name, role.getName());
    }

    @Test
    public void testRoleWithZeroId() {
        role.setId(0);
        assertEquals(0, role.getId());
    }

    @Test
    public void testRoleWithNegativeId() {
        role.setId(-1);
        assertEquals(-1, role.getId());
    }

    @Test
    public void testRoleWithNullName() {
        role.setName(null);
        assertNull(role.getName());
    }

    @Test
    public void testRoleWithEmptyName() {
        role.setName("");
        assertEquals("", role.getName());
    }

    @Test
    public void testEqualsAndHashCode() {
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("ROLE_USER");

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("ROLE_USER");

        assertEquals(role1, role2);
        assertEquals(role1.hashCode(), role2.hashCode());
    }

    @Test
    public void testNotEquals() {
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("ROLE_USER");

        Role role2 = new Role();
        role2.setId(2);
        role2.setName("ROLE_ADMIN");

        assertNotEquals(role1, role2);
    }

    @Test
    public void testToString() {
        role.setId(1);
        role.setName("ROLE_USER");
        String toString = role.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("ROLE_USER"));
    }
}
