package com.example.ncovcheck;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ncovcheck.vo.NewsResultVO;
import com.example.ncovcheck.vo.RumorResultVO;

import java.util.List;

public class CurrentNewsAdapter extends RecyclerView.Adapter<CurrentNewsAdapter.ViewHolder> {

    private Context mContext;

    private List<NewsResultVO.WeiJianWeiListVO> list;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView newsDate;
        TextView newsTitle;
        TextView newsSummary;
        TextView newsUrl;
        TextView newsResource;

        public ViewHolder(View view) {
            super(view);
            newsDate = view.findViewById(R.id.news_update_time);
            newsTitle = view.findViewById(R.id.news_title);
            newsSummary = view.findViewById(R.id.news_summary);
            newsUrl = view.findViewById(R.id.news_url);
            newsResource = view.findViewById(R.id.news_info_resource);
        }
    }

    public CurrentNewsAdapter(List<NewsResultVO.WeiJianWeiListVO> list) {
        this.list = list;
    }

    @Override
    public CurrentNewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.current_news_item, parent, false);
        final CurrentNewsAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CurrentNewsAdapter.ViewHolder holder, int position) {
        final NewsResultVO.WeiJianWeiListVO listVO = list.get(position);
        holder.newsDate.setText("更新时间: " + listVO.getPubDateStr());
        holder.newsTitle.setText(listVO.getTitle());
        holder.newsResource.setText(listVO.getInfoSource());
        holder.newsUrl.setText(listVO.getSourceUrl());
        holder.newsUrl.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        holder.newsUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(listVO.getSourceUrl()));
                mContext.startActivity(intent);
            }
        });
        holder.newsSummary.setText(listVO.getSummary());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDataList(List<NewsResultVO.WeiJianWeiListVO> list) {
        this.list = list;
    }

}
