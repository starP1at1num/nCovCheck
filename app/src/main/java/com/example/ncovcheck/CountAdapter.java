package com.example.ncovcheck;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CountAdapter extends RecyclerView.Adapter<CountAdapter.ViewHolder> {

    private static final String TAG = "CountAdapter";

    private Context mContext;

    private List<MainActivity.CountVO> mCountList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView compareWithYesterdayTv;
        TextView totallyTv;
        TextView typeTv;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            compareWithYesterdayTv = view.findViewById(R.id.compare_with_yesterday_tv);
            totallyTv = view.findViewById(R.id.totally_tv);
            typeTv = view.findViewById(R.id.type_tv);
        }
    }

    public CountAdapter(List<MainActivity.CountVO> mCountList) {
        this.mCountList = mCountList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.count_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MainActivity.CountVO countVO = mCountList.get(position);
        holder.compareWithYesterdayTv.setText("较昨日+" + countVO.getCompareWithYesterday());
        holder.totallyTv.setText(countVO.getTotally());
        holder.typeTv.setText(countVO.getType());
        holder.totallyTv.setTextColor(countVO.getTextColor());
    }

    @Override
    public int getItemCount() {
        return mCountList.size();
    }

    public void setDataList(List<MainActivity.CountVO> mCountList) {
        this.mCountList = mCountList;
    }

}
