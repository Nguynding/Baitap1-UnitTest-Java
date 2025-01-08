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
        // Email hợp lệ
        assertTrue(validator.isValidEmail("test@gmail.com"), "Email hợp lệ không được xác nhận đúng.");
        assertTrue(validator.isValidEmail("user.name@domain.co"), "Email hợp lệ không được xác nhận đúng.");

        // Email không hợp lệ
        assertFalse(validator.isValidEmail("testgmail.com"), "Email thiếu ký tự '@' nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidEmail("test@com"), "Email thiếu ký tự '.' nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidEmail("test@.com"), "Email không có tên miền trước '.' nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidEmail("test@domain#com"), "Email chứa ký tự đặc biệt không hợp lệ nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidEmail(""), "Email rỗng nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidEmail(null), "Email null nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidEmail("user@domain..com"), "Email chứa '..' nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidEmail("user.@domain.com"), "Email chứa '@.' nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidEmail(".user@domain.com"), "Email bắt đầu bằng '.' nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidEmail("user@@domain.com"), "Email chứa '@@' nhưng được xác nhận là hợp lệ.");

    }

    @Test
    void testIsValidPassword() {
        // Mật khẩu hợp lệ
        assertTrue(validator.isValidPassword("Password1"), "Mật khẩu hợp lệ không được xác nhận đúng.");
        assertTrue(validator.isValidPassword("Abc12345"), "Mật khẩu hợp lệ không được xác nhận đúng.");

        // Mật khẩu không hợp lệ
        assertFalse(validator.isValidPassword("password"), "Mật khẩu không có chữ hoa nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidPassword("PASSWORD"), "Mật khẩu không có chữ thường nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidPassword("Passw0"), "Mật khẩu có độ dài < 8 nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidPassword("Pass_word"), "Mật khẩu không có chữ số nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidPassword("Password@123"), "Mật khẩu chứa ký tự đặc biệt nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidPassword("Password 1"), "Mật khẩu chứa khoảng trắng nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidPassword(""), "Mật khẩu rỗng nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidPassword(null), "Mật khẩu null nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidPassword("Abc123 45"), "Mật khẩu chứa khoảng trắng nhưng được xác nhận là hợp lệ.");
        assertFalse(validator.isValidPassword("Abc@12345"), "Mật khẩu chứa ký tự '@' nhưng được xác nhận là hợp lệ.");

    }
}
