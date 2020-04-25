package com.icebreaker.soot.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.icebreaker.soot.MainActivity;
import com.icebreaker.soot.NewsContentActivity;
import com.icebreaker.soot.R;
import com.icebreaker.soot.adapter.NewsAdapter;
import com.icebreaker.soot.adapter.RankAdapter;
import com.icebreaker.soot.entity.NewsPostInfo;
import com.icebreaker.soot.entity.NewsPosts;
import com.icebreaker.soot.entity.OriginalData;
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
        final NewsAdapter adapter = new NewsAdapter(new ArrayList<NewsPostInfo>());
        final List<String> NewsContent = new ArrayList<>();

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                Intent intent = new Intent(getActivity(), NewsContentActivity.class);
                intent.putExtra("htmlcontent",NewsContent.get(position));
                startActivity(intent);
            }
        });

        Kalle.get("http://api.qiuduoduo.cn/ttposts?b=&fillContent=true&lazy=true&ps=20")
                .addHeader("Accept-Encoding","gzip")
                .perform(new SimpleCallback<String>() {
                    @Override
                    public void onResponse(SimpleResponse<String, String> response) {
                        // 请求响应了。
                        if(response.isSucceed()) {
                            OriginalData originalData =gson.fromJson(response.succeed(), OriginalData.class);
                            NewsPosts newsPosts=gson.fromJson(gson.toJson(originalData.getData()),NewsPosts.class);
                            final List<NewsPostInfo> newsPostInfo=gson.fromJson(
                                    gson.toJson(newsPosts.getPosts()),
                                    new TypeToken<List<NewsPostInfo>>(){}.getType()
                            );

                            for(NewsPostInfo newsPostInfo1:newsPostInfo){
                                NewsContent.add(newsPostInfo1.getContent());
                            }

                            LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
                            RecyclerView recyclerView=(RecyclerView)getView().findViewById(R.id.newsrecycler);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);
                            adapter.setNewData(newsPostInfo);

                        } else {
                            Toast toast = Toast.makeText(getContext(), response.failed(), LENGTH_LONG);
                            toast.show();
                        }
                    }
                });

    }
}
