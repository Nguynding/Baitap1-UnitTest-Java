import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserValidatorTest {

    private UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator();
    }

    @Test
    void testIsValidEmail() {
        // Valid emails
        assertTrue(validator.isValidEmail("test@gmail.com"), "Valid email was not recognized.");
        assertTrue(validator.isValidEmail("user.name@domain.co"), "Valid email was not recognized.");

        // Invalid emails
        assertFalse(validator.isValidEmail("testgmail.com"), "Email without '@' was recognized as valid.");
        assertFalse(validator.isValidEmail("test@com"), "Email without '.' was recognized as valid.");
        assertFalse(validator.isValidEmail("test@.com"), "Email with no domain before '.' was recognized as valid.");
        assertFalse(validator.isValidEmail("test@domain#com"), "Email with invalid special characters was recognized as valid.");
        assertFalse(validator.isValidEmail(""), "Empty email was recognized as valid.");
        assertFalse(validator.isValidEmail(null), "Null email was recognized as valid.");
    }

    @Test
    void testIsValidPassword() {
        // Valid passwords
        assertTrue(validator.isValidPassword("Password1"), "Valid password was not recognized.");
        assertTrue(validator.isValidPassword("Abc12345"), "Valid password was not recognized.");

        // Invalid passwords
        assertFalse(validator.isValidPassword("password"), "Password without uppercase was recognized as valid.");
        assertFalse(validator.isValidPassword("PASSWORD"), "Password without lowercase was recognized as valid.");
        assertFalse(validator.isValidPassword("Passw0"), "Password shorter than 8 characters was recognized as valid.");
        assertFalse(validator.isValidPassword("Pass_word"), "Password without digits was recognized as valid.");
        assertFalse(validator.isValidPassword("Password 1"), "Password with spaces was recognized as valid.");
        assertFalse(validator.isValidPassword(""), "Empty password was recognized as valid.");
        assertFalse(validator.isValidPassword(null), "Null password was recognized as valid.");
    }
}
