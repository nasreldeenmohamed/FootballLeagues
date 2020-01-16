package com.bip.interview.task.data.remote;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.bip.interview.task.data.models.Competition;
import com.bip.interview.task.data.models.Team;
import com.bip.interview.task.data.remote.models.FetchLeagueResponse;
import com.bip.interview.task.data.remote.models.TeamsListResponse;
import com.bip.interview.task.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepository {

    private APIsRequests aPIsRequest;
    private static RetrofitRepository retrofitRepository;

    private RetrofitRepository() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        aPIsRequest = retrofit.create(APIsRequests.class);
    }

    public synchronized static RetrofitRepository getInstance() {

        if (retrofitRepository == null) {
            retrofitRepository = new RetrofitRepository();
        }

        return retrofitRepository;
    }

    public MutableLiveData<List<Competition>> fetchLeaguesList() {
        final MutableLiveData<List<Competition>> data = new MutableLiveData<>();
        aPIsRequest.fetchLeaguesList().enqueue(new Callback<FetchLeagueResponse>() {
            @Override
            public void onResponse(Call<FetchLeagueResponse> call, Response<FetchLeagueResponse> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body().getCompetitions());
                } else {
                    try {
                        Log.e("fetchLeaguesList", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<FetchLeagueResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return data;
    }

    public MutableLiveData<TeamsListResponse> fetchTeamsList(int leagueID) {
        final MutableLiveData<TeamsListResponse> data = new MutableLiveData<>();
        aPIsRequest.fetchLeagueTeams(leagueID).enqueue(new Callback<TeamsListResponse>() {
            @Override
            public void onResponse(Call<TeamsListResponse> call, Response<TeamsListResponse> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    try {
                        Log.e("fetchTeamsList", response.errorBody().string());
                        TeamsListResponse response1 = new TeamsListResponse();
                        response1.setMessage(response.errorBody().string());
                        response1.setErrorCode(response.code());
                        data.setValue(response1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<TeamsListResponse> call, Throwable t) {
                t.printStackTrace();
                TeamsListResponse response1 = new TeamsListResponse();
                response1.setMessage(t.getMessage());
                response1.setErrorCode(0);
                data.setValue(response1);
            }
        });
        return data;
    }

    public MutableLiveData<Team> fetchTeamInfo(int teamId) {
        final MutableLiveData<Team> data = new MutableLiveData<>();
        aPIsRequest.fetchTeamInfo(teamId).enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    try {
                        Log.e("fetchTeamsList", response.errorBody().string());
                        Team response1 = new Team();
                        response1.setMessage(response.errorBody().string());
                        response1.setErrorCode(response.code());
                        data.setValue(response1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                t.printStackTrace();
                Team response1 = new Team();
                response1.setMessage(t.getMessage());
                response1.setErrorCode(0);
                data.setValue(response1);
            }
        });
        return data;
    }

}
