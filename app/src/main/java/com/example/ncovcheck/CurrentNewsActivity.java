package com.example.ncovcheck;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ncovcheck.vo.NewsResultVO;
import com.example.ncovcheck.vo.RumorResultVO;

import java.util.ArrayList;
import java.util.List;

public class CurrentNewsActivity extends AppCompatActivity {
    private List<NewsResultVO.WeiJianWeiListVO> weiJianWeiList = new ArrayList<>();
    private CurrentNewsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_news);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        if(null != getIntent()) {
            weiJianWeiList = (ArrayList<NewsResultVO.WeiJianWeiListVO>)getIntent().getSerializableExtra("newsList");
        }
        if(null != weiJianWeiList) {
            init();
        }
    }

    private void init(){
        RecyclerView recyclerView = findViewById(R.id.news_recycle_view);
        adapter = new CurrentNewsAdapter(weiJianWeiList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
