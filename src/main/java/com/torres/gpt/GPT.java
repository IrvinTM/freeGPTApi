package com.torres.gpt;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.json.JSONArray;

public class GPT {
    private String url = "https://nexra.aryahcr.cc/api/chat/gpt";
    private String defaultModel = "gpt-4";

    public JSONObject fetchData( JSONArray jsonMessages, IChatCompletionOptions options) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        JSONObject data = new JSONObject();

        data.put("messages", jsonMessages);
        data.put("prompt", jsonMessages.getJSONObject(jsonMessages.length()-1).getString("content"));
        data.put("model", options != null && options.getModel() != null ? options.getModel() : defaultModel);
        data.put("markdown", false);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return handleResponse(response.body());
    }

    private JSONObject handleResponse(String text) throws Exception {
        text = text.substring(text.indexOf('{'));
        JSONObject obj = new JSONObject(text);
        if (!obj.has("gpt")) throw new Exception("Invalid response.");
        return obj;
    }
}