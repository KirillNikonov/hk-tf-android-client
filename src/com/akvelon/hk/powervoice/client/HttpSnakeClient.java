package com.akvelon.hk.powervoice.client;

import java.io.IOException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpSnakeClient {

    private String id;

    //private final String URL = "http://10.0.9.167:9101";
    private final String URL = "http://10.0.9.222:9101";

    public HttpSnakeClient(String id) {
        this.id = id;
    }

    public void sendPut(String command) throws Exception {

        String url = URL + "/commands";

        String json = "";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("pwd", "password");
        jsonObject.put("cmd", command);
        json = jsonObject.toString();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .put(body) //PUT
                .addHeader("Accept", "application/json")
                .addHeader("Content-type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                int y = 0;
            }
        });
    }
}

