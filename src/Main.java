import java.util.regex.Pattern;

public class Main {
    public static final Pattern PATTERN = Pattern.compile("\\w+");
    public static void main(String[] args) {
        try {
            check("login)", "pass", "pass");
            System.out.println("Логин выполнен!");
        } catch (WrongPasswordException e) {
            e.printStackTrace(System.err);
        } catch (WrongLoginException e) {
            throw new IllegalStateException("Произошла ошибка ввода", e);
        }
    }

    private static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        var mather = PATTERN.matcher(login);
        if (login.length() > 20 || !mather.matches()) {
            throw new WrongLoginException("Login must contain letters, numbers and underline");
        }
            var passwordMatcher = PATTERN.matcher(password);
            if (password.length() >= 20 || !password.equals(confirmPassword) || !passwordMatcher.matches()) {
                throw new WrongPasswordException();
            }
        }

    public static boolean conformityCheck(String str) {
        char[] arr = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h',
                'H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P','q',
                'Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z',
                'Z','0','1','2','3','4','5','6','7','8','9','_'};
        int count = 0;
        boolean result = false;
        for (int i = 0; i < str.length(); i++) {
            for (char c : arr) {
                if (str.charAt(i) == c) {
                    count++;
                }
            }
        }
        if (count == str.length()) {
            result = true;
        }
        return !result;
    }
}