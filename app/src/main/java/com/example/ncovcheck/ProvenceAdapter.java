package com.example.ncovcheck;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.ncovcheck.vo.AreaResultVO.AreaListVO;
import com.example.ncovcheck.vo.AreaResultVO;
import com.example.ncovcheck.widget.ListViewForScrollView;

import java.util.List;

public class ProvenceAdapter extends BaseExpandableListAdapter {
    private int resourceId;

    private Context context;

    private ListViewForScrollView citiesListView;

    private List<AreaResultVO.CitiesListVO> citiesListVOList;

    private List<AreaResultVO.AreaListVO> dataList;

    public ProvenceAdapter(Context context, int textViewResourceId,
                           List<AreaResultVO.AreaListVO> objects) {
        resourceId = textViewResourceId;
        dataList = objects;
        this.context = context;
    }

    public void setDataList(List<AreaResultVO.AreaListVO> dataList) {
        this.dataList = dataList;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        final AreaResultVO.AreaListVO areaListVO = dataList.get(groupPosition);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.provence_item,parent,false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.areaTv = (TextView) convertView.findViewById(R.id.area_item);
            groupViewHolder.currentConfirmedTv = (TextView) convertView.findViewById(R.id.current_confirmed_count_item);
            groupViewHolder.confirmedTv = (TextView) convertView.findViewById(R.id.confirmed_count_item);
            groupViewHolder.deadTv = (TextView) convertView.findViewById(R.id.dead_count_item);
            groupViewHolder.curedTv = (TextView) convertView.findViewById(R.id.cured_count_item);
//            groupViewHolder.expendBtn = (ImageView) convertView.findViewById(R.id.expend_btn);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder)convertView.getTag();
        }
        groupViewHolder.areaTv.setText(areaListVO.getProvinceName());
        groupViewHolder.currentConfirmedTv.setText(areaListVO.getCurrentConfirmedCount());
        groupViewHolder.confirmedTv.setText(areaListVO.getConfirmedCount());
        groupViewHolder.deadTv.setText(areaListVO.getDeadCount());
        groupViewHolder.curedTv.setText(areaListVO.getCuredCount());
        //如果是展开状态，
        if (isExpanded){
//            groupViewHolder.expendBtn.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.fold));
        }else{
//            groupViewHolder.expendBtn.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.expend));
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        final AreaResultVO.CitiesListVO citiesListVO = dataList.get(groupPosition).getCities().get(childPosition);
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cities_item,parent,false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.cityTv = (TextView)convertView.findViewById(R.id.city_name_item);
            childViewHolder.cityCurrentConfirmedTv = (TextView)convertView.findViewById(R.id.city_current_confirmed_item);
            childViewHolder.cityConfirmedTv = (TextView)convertView.findViewById(R.id.city_confirmed_item);
            childViewHolder.cityDeadTv = (TextView)convertView.findViewById(R.id.city_dead_item);
            childViewHolder.cityCuredTv = (TextView)convertView.findViewById(R.id.city_cured_item);
            convertView.setTag(childViewHolder);

        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.cityTv.setText(citiesListVO.getCityName());
        childViewHolder.cityCurrentConfirmedTv.setText(citiesListVO.getCurrentConfirmedCount());
        childViewHolder.cityConfirmedTv.setText(citiesListVO.getConfirmedCount());
        childViewHolder.cityDeadTv.setText(citiesListVO.getDeadCount());
        childViewHolder.cityCuredTv.setText(citiesListVO.getCuredCount());
        return convertView;
    }

    //指定位置上的子元素是否可选中
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    static class GroupViewHolder {
//        ImageView expendBtn;
        TextView areaTv;
        TextView currentConfirmedTv;
        TextView confirmedTv;
        TextView deadTv;
        TextView curedTv;
    }

    static class ChildViewHolder {
        TextView cityTv;
        TextView cityCurrentConfirmedTv;
        TextView cityConfirmedTv;
        TextView cityDeadTv;
        TextView cityCuredTv;
    }

    @Override
    public int getGroupCount() {
        return dataList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return dataList.get(groupPosition).getCities().size();
    }

    @Override
    public List<AreaResultVO.AreaListVO> getGroup(int groupPosition) {
        return dataList;
    }

    @Override
    public AreaResultVO.CitiesListVO getChild(int groupPosition, int childPosition) {
        return dataList.get(groupPosition).getCities().get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    //分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们
    public boolean hasStableIds() {
        return true;
    }

}
