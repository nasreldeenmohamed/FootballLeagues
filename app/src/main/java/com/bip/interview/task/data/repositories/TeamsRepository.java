package com.bip.interview.task.data.repositories;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.bip.interview.task.data.models.Team;
import com.bip.interview.task.data.remote.RetrofitRepository;
import com.bip.interview.task.data.remote.models.TeamsListResponse;
import com.bip.interview.task.utils.ConnectionDetector;

public class TeamsRepository {
    private Context context;

    public TeamsRepository(Context context) {
        this.context = context;
    }

    public MutableLiveData<TeamsListResponse> fetchTeamList(int leagueID) {
        if (ConnectionDetector.checkInternetConnection(context))
            return fetchTeamListFromRemote(leagueID);
        else
            return fetchTeamListFromDatabase();
    }

    private MutableLiveData<TeamsListResponse> fetchTeamListFromRemote(int leagueID) {
        return RetrofitRepository.getInstance().fetchTeamsList(leagueID);
    }

    private MutableLiveData<TeamsListResponse> fetchTeamListFromDatabase() {
        return null;
    }


    public MutableLiveData<Team> fetchTeamInfo(int teamId) {
        if (ConnectionDetector.checkInternetConnection(context))
            return fetchTeamInfoFromRemote(teamId);
        else
            return fetchTeamListFromDatabase(teamId);
    }

    private MutableLiveData<Team> fetchTeamInfoFromRemote(int teamId) {
        return RetrofitRepository.getInstance().fetchTeamInfo(teamId);
    }

    private MutableLiveData<Team> fetchTeamListFromDatabase(int teamId) {
        return new MutableLiveData<>();
    }

}
