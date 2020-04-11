package com.icebreaker.soot.adapter;


import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.icebreaker.soot.R;
import com.icebreaker.soot.entity.NewsPostInfo;
import com.icebreaker.soot.entity.TeamRank;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NewsAdapter extends BaseQuickAdapter<NewsPostInfo, BaseViewHolder> {


    public NewsAdapter(List<NewsPostInfo> list) {
        super(R.layout.layout_news, list);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder helper, @Nullable NewsPostInfo item) {
        helper.setText(R.id.newstitle,item.getTitle());
        helper.setText(R.id.newssummry,item.getSummary());
        Glide.with(getContext()).load(item.getShareImageUrl()).into((ImageView) helper.getView(R.id.newsimage));
    }
}

