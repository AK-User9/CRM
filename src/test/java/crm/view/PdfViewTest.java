package crm.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import crm.entity.Role;
import crm.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PdfViewTest {

    private PdfView pdfView;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private PdfWriter writer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        pdfView = new PdfView();
    }

    @Test
    public void testPdfViewCreation() {
        assertNotNull(pdfView);
    }

    @Test
    public void testPdfViewExtendsAbstractPdfView() {
        assertTrue(AbstractPdfView.class.isAssignableFrom(PdfView.class));
    }

    @Test
    public void testBuildPdfDocumentSetsContentDisposition() throws Exception {
        Document document = new Document();

        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_USER");

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setUsername("johndoe");
        user1.setEmail("john@example.com");
        user1.setPassword("password123");
        user1.setEnabled(1);
        user1.setRole(role);

        List<User> users = Arrays.asList(user1);
        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        document.open();
        pdfView.buildPdfDocument(model, document, writer, request, response);
        document.close();

        verify(response, times(1)).setHeader("Content-Disposition", "attachment; filename=\"my-pdf-file.pdf\"");
    }

    @Test
    public void testBuildPdfDocumentWithMultipleUsers() throws Exception {
        Document document = new Document();

        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_USER");

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setUsername("johndoe");
        user1.setEmail("john@example.com");
        user1.setPassword("password123");
        user1.setEnabled(1);
        user1.setRole(role);

        User user2 = new User();
        user2.setFirstName("Jane");
        user2.setLastName("Smith");
        user2.setUsername("janesmith");
        user2.setEmail("jane@example.com");
        user2.setPassword("password456");
        user2.setEnabled(1);
        user2.setRole(role);

        List<User> users = Arrays.asList(user1, user2);
        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        document.open();
        assertDoesNotThrow(() -> {
            pdfView.buildPdfDocument(model, document, writer, request, response);
        });
        document.close();
    }

    @Test
    public void testBuildPdfDocumentAddsContent() throws Exception {
        Document document = new Document();

        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_ADMIN");

        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("User");
        user.setUsername("admin");
        user.setEmail("admin@example.com");
        user.setPassword("admin123");
        user.setEnabled(1);
        user.setRole(role);

        List<User> users = Arrays.asList(user);
        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        document.open();
        pdfView.buildPdfDocument(model, document, writer, request, response);
        document.close();

        verify(response, atLeastOnce()).setHeader(anyString(), anyString());
    }

    @Test
    public void testPdfViewContentType() {
        assertEquals("application/pdf", pdfView.getContentType());
    }

    @Test
    public void testBuildPdfDocumentWithDisabledUser() throws Exception {
        Document document = new Document();

        Role role = new Role();
        role.setId(2);
        role.setName("ROLE_USER");

        User user = new User();
        user.setFirstName("Disabled");
        user.setLastName("User");
        user.setUsername("disabled");
        user.setEmail("disabled@example.com");
        user.setPassword("pass123");
        user.setEnabled(0);
        user.setRole(role);

        List<User> users = Arrays.asList(user);
        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        document.open();
        assertDoesNotThrow(() -> {
            pdfView.buildPdfDocument(model, document, writer, request, response);
        });
        document.close();
    }

    @Test
    public void testBuildPdfDocumentVerifyHeaderSet() throws Exception {
        Document document = new Document();

        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_USER");

        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("testpass");
        user.setEnabled(1);
        user.setRole(role);

        List<User> users = Arrays.asList(user);
        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        document.open();
        pdfView.buildPdfDocument(model, document, writer, request, response);
        document.close();

        verify(response).setHeader(eq("Content-Disposition"), contains("my-pdf-file.pdf"));
    }
}
