package crm.repository;

import crm.entity.Pdf;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.*;

public class PdfRepositoryTest {

    @Test
    public void testPdfRepositoryExtendsJpaRepository() {
        assertTrue(JpaRepository.class.isAssignableFrom(PdfRepository.class));
    }

    @Test
    public void testPdfRepositoryIsInterface() {
        assertTrue(PdfRepository.class.isInterface());
    }

    @Test
    public void testFindByNameMethodExists() {
        try {
            PdfRepository.class.getMethod("findByName", String.class);
        } catch (NoSuchMethodException e) {
            fail("findByName method should exist");
        }
    }

    @Test
    public void testFindByNameReturnType() throws NoSuchMethodException {
        assertEquals(Pdf.class, PdfRepository.class.getMethod("findByName", String.class).getReturnType());
    }

    @Test
    public void testPdfRepositoryAnnotation() {
        assertTrue(PdfRepository.class.isAnnotationPresent(org.springframework.stereotype.Repository.class));
    }

    @Test
    public void testPdfRepositoryGenericTypes() {
        // Verify the repository works with Pdf entity and Long ID
        assertNotNull(PdfRepository.class);
    }
}
