package tumblr;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * This class handles all communications with Tumblr's API
 * @author mhh91
 */
public class Tumblr {

    private final static String TUMBLR_URL = "http://tumblr.com/api/write";
    private final static String UNICODE = "UTF-8";
    private static Types type = Types.REGULAR;

    public String post(Map<String, String> data) throws IOException {
        URLConnection conn = getConnection(TUMBLR_URL);
        sendData(conn, constructData(data));
        return getResponse(conn);
    }

    private static URLConnection getConnection(String URL) throws IOException {
        URL url = new URL(URL);
        return url.openConnection();
    }

    private void sendData(URLConnection conn, String data) throws IOException {
        conn.setDoOutput(true);
        PrintWriter pw = new PrintWriter(conn.getOutputStream());
        pw.print(data);
        pw.flush();
        pw.close();
    }

    public String getResponse(URLConnection conn) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            return br.readLine();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return "An error occurred";
    }

    private String constructData(Map<String, String> input) throws UnsupportedEncodingException {
        StringBuilder encodedString = new StringBuilder();
        for (String key : input.keySet()) {
            encodedString.append(URLEncoder.encode(key, UNICODE));
            encodedString.append("=");
            encodedString.append(URLEncoder.encode(input.get(key), UNICODE));
            encodedString.append("&");
        }
        encodedString.deleteCharAt(encodedString.length() - 1);
        return encodedString.toString();
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        Tumblr.type = type;
    }
}