package crm.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    private Category category;

    @BeforeEach
    public void setUp() {
        category = new Category();
    }

    @Test
    public void testCategoryCreation() {
        assertNotNull(category);
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    public void testSetAndGetName() {
        String name = "VIP";
        category.setName(name);
        assertEquals(name, category.getName());
    }

    @Test
    public void testSetAndGetNameRegular() {
        String name = "Regular";
        category.setName(name);
        assertEquals(name, category.getName());
    }

    @Test
    public void testCategoryWithNullId() {
        category.setId(null);
        assertNull(category.getId());
    }

    @Test
    public void testCategoryWithNullName() {
        category.setName(null);
        assertNull(category.getName());
    }

    @Test
    public void testCategoryWithEmptyName() {
        category.setName("");
        assertEquals("", category.getName());
    }

    @Test
    public void testCategoryWithLongName() {
        String longName = "Very Long Category Name That Exceeds Normal Length";
        category.setName(longName);
        assertEquals(longName, category.getName());
    }

    @Test
    public void testEqualsAndHashCode() {
        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("VIP");

        Category category2 = new Category();
        category2.setId(1L);
        category2.setName("VIP");

        assertEquals(category1, category2);
        assertEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    public void testNotEquals() {
        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("VIP");

        Category category2 = new Category();
        category2.setId(2L);
        category2.setName("Regular");

        assertNotEquals(category1, category2);
    }

    @Test
    public void testToString() {
        category.setId(1L);
        category.setName("VIP");
        String toString = category.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("VIP"));
    }
}
