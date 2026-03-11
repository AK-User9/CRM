package crm.service;

import crm.entity.Pdf;
import crm.repository.PdfRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PdfServiceImplTest {

    @Mock
    private PdfRepository pdfRepository;

    @InjectMocks
    private PdfServiceImpl pdfService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPdfServiceImplCreation() {
        assertNotNull(pdfService);
    }

    @Test
    public void testFindByName() {
        String testName = "test.pdf";
        Pdf pdf = new Pdf();
        pdf.setName(testName);

        when(pdfRepository.findByName(testName)).thenReturn(pdf);

        Pdf result = pdfService.findByName(testName);

        assertNotNull(result);
        assertEquals(testName, result.getName());
        verify(pdfRepository, times(1)).findByName(testName);
    }

    @Test
    public void testFindByNameNotFound() {
        String testName = "nonexistent.pdf";
        when(pdfRepository.findByName(testName)).thenReturn(null);

        Pdf result = pdfService.findByName(testName);

        assertNull(result);
        verify(pdfRepository, times(1)).findByName(testName);
    }

    @Test
    public void testFindByNameNull() {
        when(pdfRepository.findByName(null)).thenReturn(null);

        Pdf result = pdfService.findByName(null);

        assertNull(result);
        verify(pdfRepository, times(1)).findByName(null);
    }

    @Test
    public void testSavePdf() {
        Pdf pdf = new Pdf();
        pdf.setName("document.pdf");

        when(pdfRepository.save(pdf)).thenReturn(pdf);

        pdfService.savePdf(pdf);

        verify(pdfRepository, times(1)).save(pdf);
    }

    @Test
    public void testSavePdfNull() {
        pdfService.savePdf(null);

        verify(pdfRepository, times(1)).save(null);
    }

    @Test
    public void testConstructorWithPdfRepository() {
        PdfRepository mockRepo = mock(PdfRepository.class);
        PdfServiceImpl service = new PdfServiceImpl(mockRepo);
        assertNotNull(service);
    }

    @Test
    public void testPdfServiceImplementsInterface() {
        assertTrue(PdfService.class.isAssignableFrom(PdfServiceImpl.class));
    }

    @Test
    public void testServiceAnnotation() {
        assertTrue(PdfServiceImpl.class.isAnnotationPresent(org.springframework.stereotype.Service.class));
    }

    @Test
    public void testSavePdfMultipleTimes() {
        Pdf pdf1 = new Pdf();
        pdf1.setName("doc1.pdf");

        Pdf pdf2 = new Pdf();
        pdf2.setName("doc2.pdf");

        pdfService.savePdf(pdf1);
        pdfService.savePdf(pdf2);

        verify(pdfRepository, times(1)).save(pdf1);
        verify(pdfRepository, times(1)).save(pdf2);
    }

    @Test
    public void testFindByNameEmptyString() {
        String emptyName = "";
        when(pdfRepository.findByName(emptyName)).thenReturn(null);

        Pdf result = pdfService.findByName(emptyName);

        assertNull(result);
        verify(pdfRepository, times(1)).findByName(emptyName);
    }
}
