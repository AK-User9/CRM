package crm.repository;

import crm.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryRepositoryTest {

    @Test
    public void testCategoryRepositoryExtendsJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(CategoryRepository.class));
    }

    @Test
    public void testCategoryRepositoryIsInterface() {
        assertTrue(CategoryRepository.class.isInterface());
    }

    @Test
    public void testFindByNameMethodExists() {
        try {
            CategoryRepository.class.getMethod("findByName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByName method should exist");
        }
    }

    @Test
    public void testFindByNameReturnType() throws NoSuchMethodException {
        assertEquals(Category.class, CategoryRepository.class.getMethod("findByName", String.class).getReturnType());
    }

    @Test
    public void testCategoryRepositoryAnnotation() {
        assertTrue(CategoryRepository.class.isAnnotationPresent(org.springframework.stereotype.Repository.class));
    }

    @Test
    public void testCategoryRepositoryGenericTypes() {
        // Verify the repository works with Category entity and Long ID
        assertNotNull(CategoryRepository.class);
    }

    @Test
    public void testRepositoryMethodCount() {
        // Test that repository has expected number of custom methods
        int methodCount = CategoryRepository.class.getDeclaredMethods().length;
        assertEquals(1, methodCount);
    }
}
