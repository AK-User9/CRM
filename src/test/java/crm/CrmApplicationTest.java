package crm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.*;

public class CrmApplicationTest {

    @Test
    public void testCrmApplicationClassExists() {
        assertNotNull(CrmApplication.class);
    }

    @Test
    public void testMainMethodExists() {
        try {
            CrmApplication.class.getMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            fail("main method should exist");
        }
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isStatic(
                CrmApplication.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testMainMethodIsPublic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isPublic(
                CrmApplication.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testSpringBootApplicationAnnotation() {
        assertTrue(CrmApplication.class.isAnnotationPresent(
                org.springframework.boot.autoconfigure.SpringBootApplication.class));
    }

    @Test
    public void testCrmApplicationCreation() {
        CrmApplication application = new CrmApplication();
        assertNotNull(application);
    }
}
