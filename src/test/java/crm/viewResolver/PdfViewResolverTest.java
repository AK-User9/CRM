package crm.viewResolver;

import crm.view.PdfView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.View;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class PdfViewResolverTest {

    private PdfViewResolver pdfViewResolver;

    @BeforeEach
    public void setUp() {
        pdfViewResolver = new PdfViewResolver();
    }

    @Test
    public void testResolveViewName() throws Exception {
        View view = pdfViewResolver.resolveViewName("test", Locale.US);
        assertNotNull(view);
        assertTrue(view instanceof PdfView);
    }

    @Test
    public void testResolveViewNameWithDifferentLocale() throws Exception {
        View view = pdfViewResolver.resolveViewName("document", Locale.FRANCE);
        assertNotNull(view);
        assertTrue(view instanceof PdfView);
    }

    @Test
    public void testImplementsViewResolver() {
        assertTrue(org.springframework.web.servlet.ViewResolver.class.isAssignableFrom(PdfViewResolver.class));
    }
}
