package crm.viewResolver;

import crm.view.CsvView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.View;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CsvViewResolverTest {

    private CsvViewResolver csvViewResolver;

    @BeforeEach
    public void setUp() {
        csvViewResolver = new CsvViewResolver();
    }

    @Test
    public void testResolveViewName() throws Exception {
        View view = csvViewResolver.resolveViewName("test", Locale.US);
        assertNotNull(view);
        assertTrue(view instanceof CsvView);
    }

    @Test
    public void testResolveViewNameWithDifferentLocale() throws Exception {
        View view = csvViewResolver.resolveViewName("data", Locale.GERMANY);
        assertNotNull(view);
        assertTrue(view instanceof CsvView);
    }

    @Test
    public void testImplementsViewResolver() {
        assertTrue(org.springframework.web.servlet.ViewResolver.class.isAssignableFrom(CsvViewResolver.class));
    }
}
