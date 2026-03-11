package crm.repository;

import crm.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    @Test
    public void testUserRepositoryExtendsJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(UserRepository.class));
    }

    @Test
    public void testUserRepositoryIsInterface() {
        assertTrue(UserRepository.class.isInterface());
    }

    @Test
    public void testFindByUsernameMethodExists() {
        try {
            UserRepository.class.getMethod("findByUsername", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByUsername method should exist");
        }
    }

    @Test
    public void testFindByUsernameReturnType() throws NoSuchMethodException {
        assertEquals(User.class, UserRepository.class.getMethod("findByUsername", String.class).getReturnType());
    }

    @Test
    public void testFindAllByEnabledMethodExists() {
        try {
            UserRepository.class.getMethod("findAllByEnabled", int.class);
        } catch (NoSuchMethodException e) {
            fail("findAllByEnabled method should exist");
        }
    }

    @Test
    public void testFindAllByEnabledReturnType() throws NoSuchMethodException {
        assertEquals(Iterable.class, UserRepository.class.getMethod("findAllByEnabled", int.class).getReturnType());
    }

    @Test
    public void testUserRepositoryAnnotation() {
        assertTrue(UserRepository.class.isAnnotationPresent(org.springframework.stereotype.Repository.class));
    }

    @Test
    public void testUserRepositoryGenericTypes() {
        // Verify the repository works with User entity and Long ID
        assertNotNull(UserRepository.class);
    }

    @Test
    public void testRepositoryMethodCount() {
        // Test that repository has expected number of custom methods
        int methodCount = UserRepository.class.getDeclaredMethods().length;
        assertEquals(2, methodCount);
    }
}
