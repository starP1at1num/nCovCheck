package com.example.ncovcheck.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ncovcheck.Constant;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class AreaHelper {
    private AreaView areaView;
    private AreaTask areaTask;

    public void setView(AreaView areaView) {
        this.areaView = areaView;
    }

    public void getArea(){
        areaTask = new AreaTask();
        areaTask.execute();
    }

    private String areaRequest() {
        OkHttpClient okHttpClient = new OkHttpClient();
        String result = "result";
        String url = Constant.API_AREA + "?key=" + Constant.API_KEY;
        try {
            Request request = new Request.Builder().url(url).build();
            ResponseBody responseBody = okHttpClient.newCall(request).execute().body();
            if(null != responseBody) {
                result = responseBody.string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public class AreaTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String s = areaRequest();
            Log.d(s, "doInBackground: ");
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            if (areaView != null) {
                areaView.onAreaResult(s);
            }
        }
    }
}
