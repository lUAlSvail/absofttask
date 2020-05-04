import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {

    private static HttpURLConnection connection;

    public String getLink(String link,String value) {
        BufferedReader reader;
        StringBuilder responseContent = new StringBuilder();
        try {
            URL url = new URL(link);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            String line;
            if (connection.getResponseCode() > 299)
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            else reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null)
                responseContent.append(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        JSONObject jsonObj = new JSONObject(responseContent.toString());
        return (String) jsonObj.get(value);
    }
}

