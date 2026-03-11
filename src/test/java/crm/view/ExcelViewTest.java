package crm.view;

import crm.entity.Role;
import crm.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExcelViewTest {

    private ExcelView excelView;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        excelView = new ExcelView();
    }

    @Test
    public void testExcelViewCreation() {
        assertNotNull(excelView);
    }

    @Test
    public void testBuildExcelDocumentWithUsers() throws Exception {
        Workbook workbook = new HSSFWorkbook();
        Map<String, Object> model = new HashMap<>();

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
        model.put("users", users);

        excelView.buildExcelDocument(model, workbook, request, response);

        verify(response, times(1)).setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");
        assertEquals(1, workbook.getNumberOfSheets());
    }

    @Test
    public void testBuildExcelDocumentWithMultipleUsers() throws Exception {
        Workbook workbook = new HSSFWorkbook();
        Map<String, Object> model = new HashMap<>();

        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_ADMIN");

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setUsername("johndoe");
        user1.setEmail("john@example.com");
        user1.setPassword("pass1");
        user1.setEnabled(1);
        user1.setRole(role);

        User user2 = new User();
        user2.setFirstName("Jane");
        user2.setLastName("Smith");
        user2.setUsername("janesmith");
        user2.setEmail("jane@example.com");
        user2.setPassword("pass2");
        user2.setEnabled(1);
        user2.setRole(role);

        List<User> users = Arrays.asList(user1, user2);
        model.put("users", users);

        excelView.buildExcelDocument(model, workbook, request, response);

        verify(response, times(1)).setHeader(eq("Content-Disposition"), anyString());
        assertEquals(1, workbook.getNumberOfSheets());
    }

    @Test
    public void testExcelViewExtendsAbstractXlsView() {
        assertTrue(org.springframework.web.servlet.view.document.AbstractXlsView.class.isAssignableFrom(ExcelView.class));
    }
}
