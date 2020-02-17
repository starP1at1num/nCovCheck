package com.example.ncovcheck;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ncovcheck.presenter.AreaHelper;
import com.example.ncovcheck.presenter.AreaView;
import com.example.ncovcheck.presenter.NewsHelper;
import com.example.ncovcheck.presenter.NewsView;
import com.example.ncovcheck.vo.AreaResultVO;
import com.example.ncovcheck.vo.NewsResultVO;
import com.example.ncovcheck.widget.ListViewForScrollView;
import com.google.gson.Gson;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsView, AreaView {
    private NewsHelper newsHelper = new NewsHelper();
    private AreaHelper areaHelper = new AreaHelper();
    private AreaResultVO areaResultVO;
    private NewsResultVO newsResultVO;
    private NewsResultVO.DescriptionVO descriptionVO;
    private Gson gson = new Gson();
    private TextView modifyTime;

    private List<CountVO> countVOList = new ArrayList<>();
    private List<String> urlList = new ArrayList<>();
    private List<NewsResultVO.WeiJianWeiListVO> weiJianWeiList = new ArrayList<>();

    private CountAdapter adapter;
    private TrendChartAdapter trendChartAdapter;
    private ProvenceAdapter provenceAdapter;

    private SwipeRefreshLayout swipeRefresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        initView();
        initHelper();
        loadData();
    }

    private void initView() {
        modifyTime = findViewById(R.id.modify_time);
        RecyclerView recyclerView = findViewById(R.id.count_of_china);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView trendChartRv = findViewById(R.id.trend_chart_recycler_view);
        adapter = new CountAdapter(countVOList);
        trendChartAdapter = new TrendChartAdapter(this, urlList);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        trendChartRv.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);
        trendChartRv.setAdapter(trendChartAdapter);
        Button toRumorDistinguishBtn = findViewById(R.id.rumor_button);
        toRumorDistinguishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRumorIntent = new Intent(MainActivity.this, RumorDistinguishActivity.class);
                startActivity(toRumorIntent);
            }
        });
        Button toCurrentNewsBtn = findViewById(R.id.news_button);
        toCurrentNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weiJianWeiList = newsResultVO.getNewslist().get(0).getNews();
                Intent toNewsIntent = new Intent(MainActivity.this, CurrentNewsActivity.class);
                toNewsIntent.putExtra("newsList",(Serializable) weiJianWeiList);
                startActivity(toNewsIntent);
            }
        });
    }

    private void initHelper() {

        newsHelper.setView(this);
        areaHelper.setView(this);
    }

    private void loadData() {
        newsHelper.getNews();
        areaHelper.getArea();
    }

    @Override
    public void onNewsResult(String result) {
        newsResultVO = gson.fromJson(result, NewsResultVO.class);
        descriptionVO = newsResultVO.getNewslist().get(0).getDesc();
        if (null != newsResultVO) {
            setModifyTime();
            setCount();
            setPicture();
        }
    }

    private void setModifyTime() {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        modifyTime.setText(sdf.format(new Date(Long.valueOf(descriptionVO.getModifyTime()))));
    }

    private void setCount() {
        swipeRefresh = findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
        countVOList.clear();
        countVOList.add(new CountVO(descriptionVO.getCurrentConfirmedIncr(), descriptionVO.getCurrentConfirmedCount(), "现存确诊", 0xFFCD3700));
        countVOList.add(new CountVO(descriptionVO.getSuspectedIncr(), descriptionVO.getSuspectedCount(), "现存疑似", 0xFFCD3700));
        countVOList.add(new CountVO(descriptionVO.getSeriousIncr(), descriptionVO.getSeriousCount(), "现存重症", 0xFFCD3700));
        countVOList.add(new CountVO(descriptionVO.getConfirmedIncr(), descriptionVO.getConfirmedCount(), "累计确诊", 0xFFB22222));
        countVOList.add(new CountVO(descriptionVO.getDeadIncr(), descriptionVO.getDeadCount(), "累计死亡", 0xFF949494));
        countVOList.add(new CountVO(descriptionVO.getCuredIncr(), descriptionVO.getCuredCount(), "累计治愈", 0xFF71C671));
        adapter.setDataList(countVOList);
        adapter.notifyDataSetChanged();
        swipeRefresh.setRefreshing(false);
    }

    private void setPicture() {
        urlList.clear();
        for(int i = 0; i < descriptionVO.getQuanguoTrendChart().size(); i++){
            urlList.add(descriptionVO.getQuanguoTrendChart().get(i).getImgUrl());
        }
        trendChartAdapter.setDataList(urlList);
        trendChartAdapter.notifyDataSetChanged();
        ImageView chinaMap = findViewById(R.id.china_map);
        if (null != descriptionVO.getImgurl()) {
            String url = descriptionVO.getImgurl().replace("\\", "");
            Glide.with(this).load(url).into(chinaMap);
        } else {
            Toast.makeText(this, "全国疫情图片加载失败", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAreaResult(String result) {
        areaResultVO = gson.fromJson(result, AreaResultVO.class);
        ListViewForScrollView provenceListView = findViewById(R.id.count_of_provence_lv);
        provenceAdapter = new ProvenceAdapter(this, R.layout.provence_item, areaResultVO.getNewslist());
        provenceListView.setAdapter(provenceAdapter);
    }

    public class CountVO {
        private String compareWithYesterday;
        private String totally;
        private String type;
        private int textColor;

        public CountVO(String compareWithYesterday, String totally, String type, int textColor) {
            this.compareWithYesterday = compareWithYesterday;
            this.totally = totally;
            this.type = type;
            this.textColor = textColor;
        }

        public String getCompareWithYesterday() {
            return compareWithYesterday;
        }

        public void setCompareWithYesterday(String compareWithYesterday) {
            this.compareWithYesterday = compareWithYesterday;
        }

        public String getTotally() {
            return totally;
        }

        public void setTotally(String totally) {
            this.totally = totally;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getTextColor() {
            return textColor;
        }

        public void setTextColor(int textColor) {
            this.textColor = textColor;
        }
    }
}
