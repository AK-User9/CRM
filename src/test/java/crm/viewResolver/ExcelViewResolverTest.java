package crm.viewResolver;

import crm.view.ExcelView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.View;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class ExcelViewResolverTest {

    private ExcelViewResolver excelViewResolver;

    @BeforeEach
    public void setUp() {
        excelViewResolver = new ExcelViewResolver();
    }

    @Test
    public void testResolveViewName() throws Exception {
        View view = excelViewResolver.resolveViewName("test", Locale.US);
        assertNotNull(view);
        assertTrue(view instanceof ExcelView);
    }

    @Test
    public void testResolveViewNameWithDifferentLocale() throws Exception {
        View view = excelViewResolver.resolveViewName("spreadsheet", Locale.JAPAN);
        assertNotNull(view);
        assertTrue(view instanceof ExcelView);
    }

    @Test
    public void testImplementsViewResolver() {
        assertTrue(org.springframework.web.servlet.ViewResolver.class.isAssignableFrom(ExcelViewResolver.class));
    }
}
