package crm.csv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CSVTestTest {

    @Test
    public void testCSVTestClassExists() {
        assertNotNull(CSVTest.class);
    }

    @Test
    public void testCSVTestHasMainMethod() {
        try {
            CSVTest.class.getMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            fail("main method should exist");
        }
    }

    @Test
    public void testCSVTestMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isStatic(
                CSVTest.class.getMethod("main", String[].class).getModifiers()));
    }
}
