package com.icebreaker.soot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.icebreaker.soot.adapter.HomeAdapter;
import com.icebreaker.soot.adapter.RankAdapter;
import com.icebreaker.soot.entity.MatchInfo;
import com.icebreaker.soot.entity.OriginalRankData;
import com.icebreaker.soot.entity.RankDataScore;
import com.icebreaker.soot.entity.RankInfo;
import com.icebreaker.soot.entity.TeamRank;



import com.yanzhenjie.kalle.*;
import com.yanzhenjie.kalle.simple.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.*;
import java.util.*;
import java.lang.reflect.*;

import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;//全局定义recycleview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //查找控件
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        recyclerView =(RecyclerView)findViewById(R.id.matchrecycler);
		
		//设置toolbar
        setSupportActionBar(toolbar);
        
        //实例化gson
		final Gson gson=new Gson();


        //Get请求
		Kalle.get("https://api.qiuduoduo.cn/data/team/rank/yc/score")
        .perform(new SimpleCallback<String>() {
        @Override
        public void onResponse(SimpleResponse<String, String> response) {
            // 请求响应了。
            if(response.isSucceed()) {
                OriginalRankData originalRankData=gson.fromJson(response.succeed(),OriginalRankData.class);

                RankDataScore rankDataScore=gson.fromJson(gson.toJson(originalRankData.getData()),RankDataScore.class);

                RankInfo rankInfo=gson.fromJson(gson.toJson(rankDataScore.getScore()),RankInfo.class);
                
                List<TeamRank> retList = gson.fromJson(gson.toJson(rankInfo.getRank()),new TypeToken<List<TeamRank>>(){}.getType());
                LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                RankAdapter adapter = new RankAdapter(new ArrayList<TeamRank>());
                recyclerView.setAdapter(adapter);
                adapter.setNewData(retList);
                //解析json
                //Json的解析类对象


            } else {
                Toast toast = Toast.makeText(getApplicationContext(), response.failed(), LENGTH_LONG);
                toast.show();
            }
        }
    });

		/*
        //测试UI用的数据可不管
        ArrayList<MatchInfo> arrayList = new ArrayList<>();
        for (int i = 0; i<7; i++){
            MatchInfo matchInfo=new MatchInfo();
            matchInfo.setHostname("切尔西");
            matchInfo.setHostlogo("http://mat1.gtimg.com/sports/logo/yingchao/qrx.png");
            matchInfo.setGuestname("切尔西");
            matchInfo.setGuestlogo("http://mat1.gtimg.com/sports/logo/yingchao/qrx.png");
            arrayList.add(matchInfo);
        }
        //主页的recycleview
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RankAdapter adapter = new RankAdapter(new ArrayList<TeamRank>());
        recyclerView.setAdapter(adapter);
        adapter.setNewData(arrayList);

		 */
    }
}
