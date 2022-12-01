public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UserData user = new UserData("sffe3_324","lfsf_32","lfsf_32");
       // user.checkUserDateCorrectness(user.getLogin(), user.getPassword(), user.getConfirmPassword());
        boolean result = true;

        try {
            result = user.checkUserDateCorrectness(user.getLogin(), user.getPassword(), user.getConfirmPassword());
        } catch (WrongLoginException e) {
            throw new RuntimeException(e);
        } catch (WrongPasswordException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
    }
}