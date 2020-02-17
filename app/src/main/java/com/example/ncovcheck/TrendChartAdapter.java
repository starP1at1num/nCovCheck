package com.example.ncovcheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TrendChartAdapter extends RecyclerView.Adapter<TrendChartAdapter.ViewHolder>{

    private List<String> urlList;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View trendChartView;
        ImageView chartIv;

        public ViewHolder(View view) {
            super(view);
            trendChartView = view;
            chartIv = view.findViewById(R.id.chart);
        }
    }

    public TrendChartAdapter(Context context, List<String> urlList) {
        this.urlList = urlList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trend_chart_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String url = urlList.get(position);
        Glide.with(context).load(url).into(holder.chartIv);
    }

    @Override
    public int getItemCount() {
        return urlList.size();
    }

    public void setDataList(List<String> urlList){
        this.urlList = urlList;
    }

}
