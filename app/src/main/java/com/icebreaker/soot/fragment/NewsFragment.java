package com.icebreaker.soot.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icebreaker.soot.R;
import com.icebreaker.soot.adapter.RankAdapter;
import com.icebreaker.soot.entity.OriginalRankData;
import com.icebreaker.soot.entity.RankDataScore;
import com.icebreaker.soot.entity.RankInfo;
import com.icebreaker.soot.entity.TeamRank;
import com.yanzhenjie.kalle.Kalle;
import com.yanzhenjie.kalle.simple.SimpleCallback;
import com.yanzhenjie.kalle.simple.SimpleResponse;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class NewsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_fragment, container, false);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Gson gson=new Gson();
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

                            LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
                            RecyclerView recyclerView=(RecyclerView)getView().findViewById(R.id.newsrecycler);
                            recyclerView.setLayoutManager(layoutManager);
                            RankAdapter adapter = new RankAdapter(new ArrayList<TeamRank>());
                            recyclerView.setAdapter(adapter);
                            adapter.setNewData(retList);
                        } else {
                            Toast toast = Toast.makeText(getContext(), response.failed(), LENGTH_LONG);
                            toast.show();
                        }
                    }
                });

    }
}
