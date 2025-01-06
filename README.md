# Bài tập 1 kiểm thử bằng java
## 1. Lớp UserValidator
```java
public class UserValidator {
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            if (Character.isLowerCase(c)) hasLowercase = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        return hasUppercase && hasLowercase && hasDigit;
    }
}
```
## 2. Kiểm thử đơn vị với JUnit 5 bằng cách tạo file UserValidatorTest.java 
```java
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
```
## 3. Kết quả chạy chương trình
![image](https://github.com/user-attachments/assets/be8ff95c-0e28-4e44-aa43-f4fb85fc2605)

## 4. Nguồn tham khảo
https://chatgpt.com/share/677bb1e0-314c-8011-a2eb-a728cdf32051
## 5. Author
Nguyễn Diệu Linh
