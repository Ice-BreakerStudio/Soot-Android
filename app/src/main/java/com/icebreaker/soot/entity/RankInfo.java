package com.icebreaker.soot.entity;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;


public class RankInfo {
    @SerializedName("排行")
    private List rank;

    public List getRank() {
        return rank;
    }

    public void setRank(List rank) {
        this.rank = rank;
    }
}
