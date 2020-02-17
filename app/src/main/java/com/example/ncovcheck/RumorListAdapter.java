package com.example.ncovcheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ncovcheck.vo.RumorResultVO;

import java.util.List;

public class RumorListAdapter extends RecyclerView.Adapter<RumorListAdapter.ViewHolder> {

    private Context mContext;

    private List<RumorResultVO.RumorListVO> list;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView rumorImg;
        TextView rumorDate;
        TextView rumorTitle;
        TextView rumorType;
        TextView rumorDescription;
        TextView rumorDescriptionFrom;

        public ViewHolder(View view) {
            super(view);
            rumorImg = view.findViewById(R.id.rumor_img);
            rumorDate = view.findViewById(R.id.rumor_update_time);
            rumorTitle = view.findViewById(R.id.rumor_title);
            rumorType = view.findViewById(R.id.rumor_type);
            rumorDescription = view.findViewById(R.id.rumor_description);
            rumorDescriptionFrom = view.findViewById(R.id.rumor_description_from);
        }
    }

    public RumorListAdapter(List<RumorResultVO.RumorListVO> list) {
        this.list = list;
    }

    @Override
    public RumorListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.rumor_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RumorListAdapter.ViewHolder holder, int position) {
        RumorResultVO.RumorListVO listVO = list.get(position);
        holder.rumorDate.setText("更新时间: " + listVO.getDate());
        holder.rumorTitle.setText(listVO.getTitle());
        Glide.with(mContext).load(listVO.getImgsrc()).into(holder.rumorImg);
        holder.rumorType.setText(listVO.getExplain());
        holder.rumorDescription.setText(listVO.getDesc());
        holder.rumorDescriptionFrom.setText("————" + listVO.getAuthor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDataList(List<RumorResultVO.RumorListVO> list) {
        this.list = list;
    }

}
