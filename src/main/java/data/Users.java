package data;
import java.util.LinkedHashMap;

public class Users {
    public static final String USERNAME_1 = "geckoowlet2@gmail.com";
    public static final String PASSWORD_1 = "Hampshire@123";

    public static final String USERNAME_2 = "johnjul2017@outlook.com";
    public static final String PASSWORD_2 = "Password@12";

    public static final String USERNAME_3 = "apple.asc002+100@gmail.com";
    public static final String PASSWORD_3 = "Hampshire@123";

    public static final String USERNAME_4 = "johnaug2017@outlook.com";
    public static final String PASSWORD_4 = "Password@12";

    public static final String USERNAME_5 = "johnjan2017@outlook.com";
    public static final String PASSWORD_5 = "Password@12";

    public static final String USERNAME_6 = "apple.asc003+100@gmail.com";
    public static final String PASSWORD_6 = "Hampshire@123";

    public LinkedHashMap<String, String> users = new LinkedHashMap<>();

    public Users() {
        users.put(USERNAME_1, PASSWORD_1);
        users.put(USERNAME_2, PASSWORD_2);
        users.put(USERNAME_3, PASSWORD_3);
        users.put(USERNAME_4, PASSWORD_4);
        users.put(USERNAME_5, PASSWORD_5);
        users.put(USERNAME_6, PASSWORD_6);
    }
}
