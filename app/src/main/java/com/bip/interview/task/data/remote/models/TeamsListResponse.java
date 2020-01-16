package com.bip.interview.task.data.remote.models;

import com.bip.interview.task.data.models.Competition;
import com.bip.interview.task.data.models.Season;
import com.bip.interview.task.data.models.Team;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamsListResponse {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("filters")
    @Expose
    private Object filters;
    @SerializedName("competition")
    @Expose
    private Competition competition;
    @SerializedName("season")
    @Expose
    private Season season;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }


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

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
