package crm.service;

import crm.entity.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoleServiceTest {

    @Test
    public void testRoleServiceIsInterface() {
        assertTrue(RoleService.class.isInterface());
    }

    @Test
    public void testListAllRolesMethodExists() {
        try {
            RoleService.class.getMethod("listAllRoles");
        } catch (NoSuchMethodException e) {
            fail("listAllRoles method should exist");
        }
    }

    @Test
    public void testListAllRolesReturnType() throws NoSuchMethodException {
        assertEquals(Iterable.class, RoleService.class.getMethod("listAllRoles").getReturnType());
    }

    @Test
    public void testMethodCount() {
        // Test that interface has expected number of methods
        int methodCount = RoleService.class.getDeclaredMethods().length;
        assertEquals(1, methodCount);
    }
}
