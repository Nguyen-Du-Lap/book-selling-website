package vn.edu.hcmuaf.fit.db;

import java.io.IOException;
import java.util.Properties;

public class MessageProperties {
    private static Properties prop = new Properties();

    static {
        try {
            prop.load(MessageProperties.class.getClassLoader().getResourceAsStream("message.properties"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static String getUsername_password_invalid() {
        return prop.get("username_password_invalid").toString();
    }
    public static String getNot_login() {
        return prop.get("not_login").toString();
    }
    public static String getNot_permission() {
        return prop.get("not_permission").toString();
    }
}
