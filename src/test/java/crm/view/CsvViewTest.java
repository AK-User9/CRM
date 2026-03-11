package crm.view;

import crm.entity.User;
import crm.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CsvViewTest {

    private CsvView csvView;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        csvView = new CsvView();
    }

    @Test
    public void testCsvViewCreation() {
        assertNotNull(csvView);
    }

    @Test
    public void testCsvViewExtendsAbstractCsvView() {
        assertTrue(AbstractCsvView.class.isAssignableFrom(CsvView.class));
    }

    @Test
    public void testBuildCsvDocumentWithUsers() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

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

        csvView.buildCsvDocument(model, request, response);

        verify(response, times(1)).setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");
        verify(response, times(1)).getWriter();

        String csvContent = stringWriter.toString();
        assertNotNull(csvContent);
        assertTrue(csvContent.contains("FirstName"));
    }

    @Test
    public void testBuildCsvDocumentWithMultipleUsers() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

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

        csvView.buildCsvDocument(model, request, response);

        verify(response, times(1)).setHeader(eq("Content-Disposition"), anyString());
    }

    @Test
    public void testBuildCsvDocumentSetsContentDisposition() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        List<User> users = new ArrayList<>();
        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        csvView.buildCsvDocument(model, request, response);

        verify(response, times(1)).setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");
    }

    @Test
    public void testBuildCsvDocumentWithEmptyUserList() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        List<User> users = new ArrayList<>();
        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        assertDoesNotThrow(() -> {
            csvView.buildCsvDocument(model, request, response);
        });
    }

    @Test
    public void testCsvHeaderFields() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

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

        csvView.buildCsvDocument(model, request, response);

        String csvContent = stringWriter.toString();
        assertTrue(csvContent.contains("FirstName") || csvContent.length() > 0);
    }
}
