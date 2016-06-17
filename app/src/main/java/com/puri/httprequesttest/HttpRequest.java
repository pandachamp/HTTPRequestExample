package com.puri.httprequesttest;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by puri on 6/17/2016 AD.
 */
public class HttpRequest extends AsyncTask<String,Void,String> {

    private final String TESTHTTP = "1";

    public String testHTTP(String send) throws IOException {
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormEncodingBuilder().add("key", send).build();
        Request request = new Request.Builder().url("http://202.44.12.172/httptest.php").post(body).build();
        Response response = ok.newCall(request).execute();
        return response.isSuccessful()?response.body().string():"error";
    }

    @Override
    protected String doInBackground(String... params) {
        String re = null;
        if(Objects.equals(TESTHTTP,params[0])){
            try {
                re = testHTTP(params[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return re;
    }
}
