package crm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ViewResolver;

import static org.junit.jupiter.api.Assertions.*;

public class WebAppConfigTest {

    private WebAppConfig webAppConfig;

    @BeforeEach
    public void setUp() {
        webAppConfig = new WebAppConfig();
    }

    @Test
    public void testWebAppConfigCreation() {
        assertNotNull(webAppConfig);
    }

    @Test
    public void testTemplateResolver() {
        assertNotNull(webAppConfig.templateResolver());
    }

    @Test
    public void testTemplateEngine() {
        assertNotNull(webAppConfig.templateEngine());
    }

    @Test
    public void testViewResolver() {
        ViewResolver resolver = webAppConfig.viewResolver();
        assertNotNull(resolver);
    }

    @Test
    public void testExcelViewResolver() {
        ViewResolver resolver = webAppConfig.excelViewResolver();
        assertNotNull(resolver);
    }

    @Test
    public void testCsvViewResolver() {
        ViewResolver resolver = webAppConfig.csvViewResolver();
        assertNotNull(resolver);
    }

    @Test
    public void testPdfViewResolver() {
        ViewResolver resolver = webAppConfig.pdfViewResolver();
        assertNotNull(resolver);
    }

    @Test
    public void testConfigurationAnnotation() {
        assertTrue(WebAppConfig.class.isAnnotationPresent(org.springframework.context.annotation.Configuration.class));
    }

    @Test
    public void testImplementsWebMvcConfigurer() {
        assertTrue(org.springframework.web.servlet.config.annotation.WebMvcConfigurer.class.isAssignableFrom(WebAppConfig.class));
    }
}
