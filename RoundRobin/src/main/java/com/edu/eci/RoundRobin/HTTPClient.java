package com.edu.eci.RoundRobin;

import okhttp3.*;

import java.io.IOException;

public class HTTPClient {
    private OkHttpClient httpClient;
    private String baseUrl="http://127.0.0.1";
    private String[] ports={":6001", ":6002", ":6003",};
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private int serverNumber=0;

    public HTTPClient() {
        httpClient=new OkHttpClient();
    }

    public String getMessages(String path) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .get()
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public String postMessage( String message,String path) throws IOException {
        RequestBody body = RequestBody.create(message,JSON);
        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .post(body)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public void changePort(){
        this.serverNumber= (this.serverNumber+1)% ports.length;
    }
}
