package com.icebreaker.soot.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.icebreaker.soot.R;
import com.icebreaker.soot.entity.MatchInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<MatchInfo, BaseViewHolder> {


    public HomeAdapter(List<MatchInfo> list) {
        super(R.layout.layout_match, list);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder helper, @Nullable MatchInfo item) {
        helper.setText(R.id.hostname,item.getHostname());
        Glide.with(getContext()).load(item.getHostlogo()).into((ImageView) helper.getView(R.id.hostlogo));
        helper.setText(R.id.guestname,item.getGuestname());
        Glide.with(getContext()).load(item.getGuestlogo()).into((ImageView) helper.getView(R.id.guestlogo));
    }
}