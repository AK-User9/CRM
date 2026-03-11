package crm;

import crm.service.SpringDataUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityConfigTest {

    @Test
    public void testSecurityConfigCreation() {
        SecurityConfig securityConfig = new SecurityConfig();
        assertNotNull(securityConfig);
    }

    @Test
    public void testPasswordEncoderBean() {
        SecurityConfig securityConfig = new SecurityConfig();
        BCryptPasswordEncoder encoder = securityConfig.passwordEncoder();
        assertNotNull(encoder);
        assertTrue(encoder instanceof BCryptPasswordEncoder);
    }

    @Test
    public void testCustomUserDetailsServiceBean() {
        SecurityConfig securityConfig = new SecurityConfig();
        SpringDataUserDetailsService service = securityConfig.customUserDetailsService();
        assertNotNull(service);
        assertTrue(service instanceof SpringDataUserDetailsService);
    }

    @Test
    public void testConfigurationAnnotation() {
        assertTrue(SecurityConfig.class.isAnnotationPresent(org.springframework.context.annotation.Configuration.class));
    }

    @Test
    public void testEnableWebSecurityAnnotation() {
        assertTrue(SecurityConfig.class.isAnnotationPresent(org.springframework.security.config.annotation.web.configuration.EnableWebSecurity.class));
    }

    @Test
    public void testEnableGlobalMethodSecurityAnnotation() {
        assertTrue(SecurityConfig.class.isAnnotationPresent(org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity.class));
    }

    @Test
    public void testPasswordEncoderEncryption() {
        SecurityConfig securityConfig = new SecurityConfig();
        BCryptPasswordEncoder encoder = securityConfig.passwordEncoder();

        String rawPassword = "testPassword";
        String encodedPassword = encoder.encode(rawPassword);

        assertNotNull(encodedPassword);
        assertNotEquals(rawPassword, encodedPassword);
        assertTrue(encoder.matches(rawPassword, encodedPassword));
    }
}
