import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ShrinkCoinService {
    private String apiKey;

    public ShrinkCoinService(String apiKey) {
        this.apiKey = apiKey;
    }

    public Map<String, Object> shrinkURL(String url, boolean isInstant) throws IOException {
        String apiUrl = "https://shrinkco.in/api/shrink";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("API_KEY", apiKey);
        parameters.put("URL", url);
        parameters.put("IS_INSTANT", Boolean.toString(isInstant));

        return callAPI(apiUrl, parameters);
    }

    public Map<String, Object> deleteURL(String id) throws IOException {
        String apiUrl = "https://shrinkco.in/api/delete";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("API_KEY", apiKey);
        parameters.put("ID", id);

        return callAPI(apiUrl, parameters);
    }

    public Map<String, Object> checkURLClicks(String id) throws IOException {
        String apiUrl = "https://shrinkco.in/api/clicks";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("API_KEY", apiKey);
        parameters.put("ID", id);

        return callAPI(apiUrl, parameters);
    }

    public Map<String, Object> checkURLCampaignClicks(String id, String campaign) throws IOException {
        String apiUrl = "https://shrinkco.in/api/campaign";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("API_KEY", apiKey);
        parameters.put("ID", id);
        parameters.put("CAMPAIGN", campaign);

        return callAPI(apiUrl, parameters);
    }

    private Map<String, Object> callAPI(String url, Map<String, String> parameters) throws IOException {
        StringBuilder response = new StringBuilder();

        StringBuilder requestUrl = new StringBuilder(url);
        requestUrl.append("?");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            requestUrl.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        URL apiUrl = new URL(requestUrl.toString());
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // You may need to use a JSON parsing library to parse the response into a map.
        // Here, we assume the response is in JSON format and convert it to a map.
        // Example using Gson library: 
        // Gson gson = new Gson();
        // Type type = new TypeToken<Map<String, Object>>(){}.getType();
        // Map<String, Object> responseMap = gson.fromJson(response.toString(), type);
        
        // For simplicity, we return a null map in this example.
        return null;
    }
}
