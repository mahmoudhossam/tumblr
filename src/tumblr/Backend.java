package tumblr;

import java.io.IOException;
import java.util.HashMap;

/**
 * this class serves as a backend to the GUI
 * @author mhh91
 */
public class Backend {

    private Tumblr tumblr = new Tumblr();
    private static HashMap<String, String> map = new HashMap<String, String>();

    public static void login(String email, String password) {
        map.put("email", email);
        map.put("password", password);
    }

    public void setType(int typeNumber) {
        Types type = Types.getType(typeNumber);
        tumblr.setType(type);
    }

    public Types getType() {
        return tumblr.getType();
    }

    public void setParam(String param, String arg) {
        map.put(param, arg);
    }

    public void regular(String body, String title) {
        map.put("title", title);
        map.put("body", body);
    }

    public String doPost() {
        String post = "";
        try {
            post = tumblr.post(map);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return post;
    }
}
