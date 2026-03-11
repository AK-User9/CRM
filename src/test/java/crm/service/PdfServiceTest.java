package crm.service;

import crm.entity.Pdf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PdfServiceTest {

    @Test
    public void testPdfServiceIsInterface() {
        assertTrue(PdfService.class.isInterface());
    }

    @Test
    public void testFindByNameMethodExists() {
        try {
            PdfService.class.getMethod("findByName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByName method should exist");
        }
    }

    @Test
    public void testSavePdfMethodExists() {
        try {
            PdfService.class.getMethod("savePdf", Pdf.class);
        } catch (NoSuchMethodException e) {
            fail("savePdf method should exist");
        }
    }

    @Test
    public void testFindByNameReturnType() throws NoSuchMethodException {
        assertEquals(Pdf.class, PdfService.class.getMethod("findByName", String.class).getReturnType());
    }

    @Test
    public void testSavePdfReturnType() throws NoSuchMethodException {
        assertEquals(void.class, PdfService.class.getMethod("savePdf", Pdf.class).getReturnType());
    }

    @Test
    public void testMethodCount() {
        // Test that interface has expected number of methods
        int methodCount = PdfService.class.getDeclaredMethods().length;
        assertEquals(2, methodCount);
    }
}
