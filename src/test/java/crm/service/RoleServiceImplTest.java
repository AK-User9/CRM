package crm.service;

import crm.entity.Role;
import crm.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRoleServiceImplCreation() {
        assertNotNull(roleService);
    }

    @Test
    public void testListAllRoles() {
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("ROLE_USER");

        Role role2 = new Role();
        role2.setId(2);
        role2.setName("ROLE_ADMIN");

        List<Role> roleList = Arrays.asList(role1, role2);
        when(roleRepository.findAll()).thenReturn(roleList);

        Iterable<Role> result = roleService.listAllRoles();

        assertNotNull(result);
        verify(roleRepository, times(1)).findAll();
        assertEquals(roleList, result);
    }

    @Test
    public void testListAllRolesEmpty() {
        List<Role> emptyList = Arrays.asList();
        when(roleRepository.findAll()).thenReturn(emptyList);

        Iterable<Role> result = roleService.listAllRoles();

        assertNotNull(result);
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    public void testConstructorWithRoleRepository() {
        RoleRepository mockRepo = mock(RoleRepository.class);
        RoleServiceImpl service = new RoleServiceImpl(mockRepo);
        assertNotNull(service);
    }

    @Test
    public void testRoleServiceImplementsInterface() {
        assertTrue(RoleService.class.isAssignableFrom(RoleServiceImpl.class));
    }

    @Test
    public void testServiceAnnotation() {
        assertTrue(RoleServiceImpl.class.isAnnotationPresent(org.springframework.stereotype.Service.class));
    }

    @Test
    public void testListAllRolesMultipleCalls() {
        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_TEST");

        List<Role> roleList = Arrays.asList(role);
        when(roleRepository.findAll()).thenReturn(roleList);

        roleService.listAllRoles();
        roleService.listAllRoles();

        verify(roleRepository, times(2)).findAll();
    }
}
