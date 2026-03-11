package crm.service;

import crm.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testUserServiceIsInterface() {
        assertTrue(UserService.class.isInterface());
    }

    @Test
    public void testFindByUsernameMethodExists() {
        try {
            UserService.class.getMethod("findByUsername", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByUsername method should exist");
        }
    }

    @Test
    public void testListAllUsersMethodExists() {
        try {
            UserService.class.getMethod("listAllUsers");
        } catch (NoSuchMethodException e) {
            fail("listAllUsers method should exist");
        }
    }

    @Test
    public void testShowUserMethodExists() {
        try {
            UserService.class.getMethod("showUser", Long.class);
        } catch (NoSuchMethodException e) {
            fail("showUser method should exist");
        }
    }

    @Test
    public void testSaveUserMethodExists() {
        try {
            UserService.class.getMethod("saveUser", User.class);
        } catch (NoSuchMethodException e) {
            fail("saveUser method should exist");
        }
    }

    @Test
    public void testEditUserMethodExists() {
        try {
            UserService.class.getMethod("editUser", User.class);
        } catch (NoSuchMethodException e) {
            fail("editUser method should exist");
        }
    }

    @Test
    public void testDeleteUserMethodExists() {
        try {
            UserService.class.getMethod("deleteUser", User.class);
        } catch (NoSuchMethodException e) {
            fail("deleteUser method should exist");
        }
    }

    @Test
    public void testFindByUsernameReturnType() throws NoSuchMethodException {
        assertEquals(User.class, UserService.class.getMethod("findByUsername", String.class).getReturnType());
    }

    @Test
    public void testListAllUsersReturnType() throws NoSuchMethodException {
        assertEquals(Iterable.class, UserService.class.getMethod("listAllUsers").getReturnType());
    }

    @Test
    public void testShowUserReturnType() throws NoSuchMethodException {
        assertEquals(User.class, UserService.class.getMethod("showUser", Long.class).getReturnType());
    }

    @Test
    public void testSaveUserReturnType() throws NoSuchMethodException {
        assertEquals(void.class, UserService.class.getMethod("saveUser", User.class).getReturnType());
    }

    @Test
    public void testEditUserReturnType() throws NoSuchMethodException {
        assertEquals(void.class, UserService.class.getMethod("editUser", User.class).getReturnType());
    }

    @Test
    public void testDeleteUserReturnType() throws NoSuchMethodException {
        assertEquals(void.class, UserService.class.getMethod("deleteUser", User.class).getReturnType());
    }
}
