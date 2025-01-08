public class UserValidator {

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        // Regex nâng cao kiểm tra email hợp lệ
        String emailRegex = "^[a-zA-Z0-9]+([._%+-]?[a-zA-Z0-9])*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
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

            // Nếu chứa ký tự đặc biệt hoặc khoảng trắng
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        // Đảm bảo mật khẩu đủ các tiêu chí
        return hasUppercase && hasLowercase && hasDigit;
    }
}
