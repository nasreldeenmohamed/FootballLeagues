package com.bip.interview.task.modules.teams.dataAccess;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bip.interview.task.data.remote.models.TeamsListResponse;
import com.bip.interview.task.data.repositories.TeamsRepository;

public class TeamsViewModel extends AndroidViewModel {
    private TeamsRepository teamsRepository;

    public TeamsViewModel(@NonNull Application application) {
        super(application);
        teamsRepository = new TeamsRepository(application.getApplicationContext());
    }

    public MutableLiveData<TeamsListResponse> getTeamsList(int LeagueID) {
        return teamsRepository.fetchTeamList(LeagueID);
    }
}
