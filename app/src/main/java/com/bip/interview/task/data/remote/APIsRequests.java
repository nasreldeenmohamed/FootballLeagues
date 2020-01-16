package com.bip.interview.task.data.remote;

import com.bip.interview.task.data.models.Team;
import com.bip.interview.task.data.remote.models.FetchLeagueResponse;
import com.bip.interview.task.data.remote.models.TeamsListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface APIsRequests {

    @GET("competitions")
    Call<FetchLeagueResponse> fetchLeaguesList();

    @Headers("X-Auth-Token: 4f8e20a000a046d3800cd3c29a163fb0")
    @GET("competitions/{leagueId}/teams")
    Call<TeamsListResponse> fetchLeagueTeams(@Path("leagueId") int leagueID);

    @Headers("X-Auth-Token: 4f8e20a000a046d3800cd3c29a163fb0")
    @GET("teams/{teamId}")
    Call<Team> fetchTeamInfo(@Path("teamId") int teamId);
}
