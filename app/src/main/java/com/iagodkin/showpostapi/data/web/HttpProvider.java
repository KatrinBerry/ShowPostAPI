package com.iagodkin.showpostapi.data.web;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpProvider implements Api{
    private OkHttpClient client;
    public static final String URL = "https://api.openweathermap.org/data/2.5/weather?lat=32.0879122&lon=34.7272058&appid=c40bcdb16dd10d667851c504b9af0be8";

    public HttpProvider() {
        client = new OkHttpClient();
    }

    public String show () throws IOException {
        Request request = new Request.Builder()
                .url(URL)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            Log.e("MY_TAG", "show: " + response.body().string());
            throw new RuntimeException("Server error! Call to support!");
        }
    }

}
