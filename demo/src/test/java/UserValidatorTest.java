import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserValidatorTest {

    UserValidator validator = new UserValidator();

    @Test
    void testIsValidEmail() {
        // Email hợp lệ
        assertTrue(validator.isValidEmail("test@gmail.com"));
        assertTrue(validator.isValidEmail("user.name@domain.co"));

        // Email không hợp lệ
        assertFalse(validator.isValidEmail("testgmail.com")); // Thiếu @
        assertFalse(validator.isValidEmail("test@com"));      // Thiếu .
        assertFalse(validator.isValidEmail(""));              // Rỗng
        assertFalse(validator.isValidEmail(null));            // null
    }

    @Test
    void testIsValidPassword() {
        // Mật khẩu hợp lệ
        assertTrue(validator.isValidPassword("Password1"));
        assertTrue(validator.isValidPassword("Abc12345"));

        // Mật khẩu không hợp lệ
        assertFalse(validator.isValidPassword("password"));   // Không có ký tự viết hoa
        assertFalse(validator.isValidPassword("PASSWORD"));   // Không có chữ thường
        assertFalse(validator.isValidPassword("Passw0"));     // Độ dài < 8
        assertFalse(validator.isValidPassword("Pass_word"));  // Không có số
        assertFalse(validator.isValidPassword(""));           // Rỗng
        assertFalse(validator.isValidPassword(null));         // null
    }
}
