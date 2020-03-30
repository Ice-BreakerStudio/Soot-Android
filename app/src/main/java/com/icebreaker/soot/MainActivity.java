package com.icebreaker.soot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.icebreaker.soot.adapter.HomeAdapter;
import com.icebreaker.soot.entity.MatchInfo;
import com.icebreaker.soot.entity.TeamRank;



import com.yanzhenjie.kalle.*;
import com.yanzhenjie.kalle.simple.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.*;
import java.util.*;
import java.lang.reflect.*;


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
		Gson gson=new Gson();
		
		//Get请求
		Kalle.get("https://api.qiuduoduo.cn/data/team/rank/yc/score")
        .perform(new SimpleCallback<JSONObject>() {
        @Override
        public void onResponse(SimpleResponse<JSONObject, String> response) {
            // 请求响应了。
            if(response.isSucceed()) {
                //解析json
                JSONObject json = response.succeed();
                JSONObject data= json.getJSONObject("data");
                JSONObject score = data.getJSONObject("score");
                JSONArray rank = score.getJSONArray("排名");
                List<TeamRank> retList = gson.fromJson(rank.toString(),new TypeToken<List<TeamRank>>(){}.getType());
                //List<TeamRank> list = JSONObject.parseArray(rank.toString(), TeamRank.class);
            } else {
                //Toast.show(response.failed());
            }
        }
    });

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
        HomeAdapter adapter = new HomeAdapter(new ArrayList<MatchInfo>());
        recyclerView.setAdapter(adapter);
        adapter.setNewData(arrayList);
    }
}
