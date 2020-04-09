package com.icebreaker.soot.adapter;


import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.icebreaker.soot.R;
import com.icebreaker.soot.entity.TeamRank;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RankAdapter extends BaseQuickAdapter<TeamRank, BaseViewHolder> {


    public RankAdapter(List<TeamRank> list) {
        super(R.layout.layout_rank, list);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder helper, @Nullable TeamRank item) {
        helper.setText(R.id.teamname,item.getClubname());
        helper.setText(R.id.teammatchinfo,"总"+item.getMatchestotal()+" 胜"+item.getMatcheswon()+" 负"+item.getMatcheslost()+"\n进"+item.getGoalspro()+" 失"+item.getGoalsagainst());
        Glide.with(getContext()).load(item.getTeamlogo()).into((ImageView) helper.getView(R.id.teamlogo));
    }
}

