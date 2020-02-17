package com.example.ncovcheck.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ncovcheck.Constant;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class NewsHelper {
    private NewsView newsView;
    private NewsTask newsTask;

    public void setView(NewsView newsView) {
        this.newsView = newsView;
    }

    public void getNews(){
        newsTask = new NewsTask();
        newsTask.execute();
    }

    private String newsRequest() {
        OkHttpClient okHttpClient = new OkHttpClient();
        String result = "result";
        String url = Constant.API_NEWS + "?key=" + Constant.API_KEY;
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

    public class NewsTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String s = newsRequest();
            Log.d(s, "doInBackground: ");
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            if (newsView != null) {
                newsView.onNewsResult(s);
            }
        }
    }
}
