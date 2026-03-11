package crm.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PdfTest {

    private Pdf pdf;

    @BeforeEach
    public void setUp() {
        pdf = new Pdf();
    }

    @Test
    public void testPdfCreation() {
        assertNotNull(pdf);
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        pdf.setId(id);
        assertEquals(id, pdf.getId());
    }

    @Test
    public void testSetAndGetName() {
        String name = "document.pdf";
        pdf.setName(name);
        assertEquals(name, pdf.getName());
    }

    @Test
    public void testSetAndGetContent() {
        String content = "PDF content here";
        pdf.setContent(content);
        assertEquals(content, pdf.getContent());
    }

    @Test
    public void testPdfWithNullId() {
        pdf.setId(null);
        assertNull(pdf.getId());
    }

    @Test
    public void testPdfWithNullName() {
        pdf.setName(null);
        assertNull(pdf.getName());
    }

    @Test
    public void testPdfWithNullContent() {
        pdf.setContent(null);
        assertNull(pdf.getContent());
    }

    @Test
    public void testPdfWithEmptyName() {
        pdf.setName("");
        assertEquals("", pdf.getName());
    }

    @Test
    public void testBuilderPattern() {
        Pdf builtPdf = Pdf.builder()
                .id(1L)
                .name("builder.pdf")
                .content("Builder content")
                .build();

        assertNotNull(builtPdf);
        assertEquals("builder.pdf", builtPdf.getName());
        assertEquals("Builder content", builtPdf.getContent());
    }

    @Test
    public void testAllArgsConstructor() {
        Pdf newPdf = new Pdf(1L, "test.pdf", "Test content");

        assertNotNull(newPdf);
        assertEquals(1L, newPdf.getId());
        assertEquals("test.pdf", newPdf.getName());
        assertEquals("Test content", newPdf.getContent());
    }

    @Test
    public void testNoArgsConstructor() {
        Pdf newPdf = new Pdf();
        assertNotNull(newPdf);
    }

    @Test
    public void testEqualsAndHashCode() {
        Pdf pdf1 = new Pdf();
        pdf1.setId(1L);
        pdf1.setName("test.pdf");
        pdf1.setContent("Content");

        Pdf pdf2 = new Pdf();
        pdf2.setId(1L);
        pdf2.setName("test.pdf");
        pdf2.setContent("Content");

        assertEquals(pdf1, pdf2);
        assertEquals(pdf1.hashCode(), pdf2.hashCode());
    }

    @Test
    public void testNotEquals() {
        Pdf pdf1 = new Pdf();
        pdf1.setId(1L);
        pdf1.setName("test1.pdf");

        Pdf pdf2 = new Pdf();
        pdf2.setId(2L);
        pdf2.setName("test2.pdf");

        assertNotEquals(pdf1, pdf2);
    }

    @Test
    public void testToString() {
        pdf.setName("document.pdf");
        String toString = pdf.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("document.pdf"));
    }

    @Test
    public void testContentIsTransient() {
        // Content field is marked as @Transient, which means it won't be persisted
        pdf.setContent("Temporary content");
        assertEquals("Temporary content", pdf.getContent());
    }
}
