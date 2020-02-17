package com.example.ncovcheck.presenter;


import android.os.AsyncTask;
import android.util.Log;

import com.example.ncovcheck.Constant;
import com.example.ncovcheck.vo.RumorRequestVO;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;


public class RumorHelper {
    private RumorView rumorView;
    private RumorTask rumorTask;

    public void setView(RumorView rumorView) {
        this.rumorView = rumorView;
    }

    public void getRumor(int num){
        rumorTask = new RumorTask();
        rumorTask.execute(num);
    }

    private String rumorRequest(int page) {
        OkHttpClient okHttpClient = new OkHttpClient();
        String result = "result";
        String url = Constant.API_RUMOR + "?key=" + Constant.API_KEY;
        url = url + "&page=" + page;
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

    public class RumorTask extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... params) {
            String s = rumorRequest(params[0]);
            Log.d(s, "doInBackground: ");
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            if (rumorView != null) {
                rumorView.onRumorResult(s);
            }
        }
    }
}
