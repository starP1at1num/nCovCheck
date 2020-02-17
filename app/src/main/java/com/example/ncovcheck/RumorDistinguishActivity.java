package com.example.ncovcheck;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.ncovcheck.presenter.RumorHelper;
import com.example.ncovcheck.presenter.RumorView;
import com.example.ncovcheck.vo.RumorRequestVO;
import com.example.ncovcheck.vo.RumorResultVO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class RumorDistinguishActivity extends AppCompatActivity implements RumorView {
    private RumorResultVO rumorResultVO;
    private RumorHelper rumorHelper = new RumorHelper();
    private Gson gson = new Gson();
    private SwipeRefreshLayout swipeRefresh;
    private List<RumorResultVO.RumorListVO> list = new ArrayList<>();
    private RumorListAdapter adapter;
    private int page = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumor_dintinguish);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        init();
    }

    private void init(){
        swipeRefresh = findViewById(R.id.swipe_refresh_rumor);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(page >= 5){
                    page = 1;
                }else {
                    page++;
                }
                loadData();
            }
        });
        rumorHelper.setView(this);
        swipeRefresh.setRefreshing(false);
        RecyclerView recyclerView = findViewById(R.id.rumor_recycle_view);
        adapter = new RumorListAdapter(list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        rumorHelper.getRumor(page);
    }

    @Override
    public void onRumorResult(String result) {
        rumorResultVO = gson.fromJson(result, RumorResultVO.class);
        if (null != rumorResultVO) {
            list.clear();
            list = rumorResultVO.getNewslist();
            adapter.setDataList(list);
            adapter.notifyDataSetChanged();
            swipeRefresh.setRefreshing(false);
        }
    }

    private void loadData(){
        rumorHelper.getRumor(page);
    }
}
