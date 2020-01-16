package com.bip.interview.task.data.remote.models;

import com.bip.interview.task.data.models.Competition;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchLeagueResponse {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("filters")
    @Expose
    private Object filters;
    @SerializedName("competitions")
    @Expose
    private List<Competition> competitions = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getFilters() {
        return filters;
    }

    public void setFilters(Object filters) {
        this.filters = filters;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }
}