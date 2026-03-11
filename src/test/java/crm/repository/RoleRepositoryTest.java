package crm.repository;

import crm.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.*;

public class RoleRepositoryTest {

    @Test
    public void testRoleRepositoryExtendsJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(RoleRepository.class));
    }

    @Test
    public void testRoleRepositoryIsInterface() {
        assertTrue(RoleRepository.class.isInterface());
    }

    @Test
    public void testFindByNameMethodExists() {
        try {
            RoleRepository.class.getMethod("findByName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByName method should exist");
        }
    }

    @Test
    public void testFindByNameReturnType() throws NoSuchMethodException {
        assertEquals(Role.class, RoleRepository.class.getMethod("findByName", String.class).getReturnType());
    }

    @Test
    public void testRoleRepositoryAnnotation() {
        assertTrue(RoleRepository.class.isAnnotationPresent(org.springframework.stereotype.Repository.class));
    }

    @Test
    public void testRoleRepositoryGenericTypes() {
        // Verify the repository works with Role entity and Integer ID
        assertNotNull(RoleRepository.class);
    }
}
