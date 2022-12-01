import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserData {

    private String login;
    private String password;
    private String confirmPassword;

    public UserData(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public static boolean checkUserDateCorrectness(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean result = true;
        String regex = "[A-Za-z0-9_]{1,20}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherLogin = pattern.matcher(login);
        Matcher matcherPassword = pattern.matcher(password);
        if (!matcherLogin.matches()) {
           throw new WrongLoginException("Логин введден неккоректно.\n" +
                   "Логин содержит в себе только латинские буквы, цифры и знак подчеркивания." +
                   "Длина логина от 1 до 20 символов.");
        } else if (!matcherPassword.matches()){
           throw new WrongPasswordException("Пароль введден неккоректно\n" +
                   "Пароль содержит в себе только латинские буквы, цифры и знак подчеркивания." +
                   "Длина пароля от 1 до 20 символов.");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        } else {
            return result;
        }
    }
}
