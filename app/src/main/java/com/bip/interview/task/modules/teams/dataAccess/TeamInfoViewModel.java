package com.bip.interview.task.modules.teams.dataAccess;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bip.interview.task.data.models.Team;
import com.bip.interview.task.data.repositories.TeamsRepository;

public class TeamInfoViewModel extends AndroidViewModel {
    private TeamsRepository teamsRepository;

    public TeamInfoViewModel(@NonNull Application application) {
        super(application);
        teamsRepository = new TeamsRepository(application.getApplicationContext());
    }

    public MutableLiveData<Team> getTeamInfo(int teamId) {
        return teamsRepository.fetchTeamInfo(teamId);
    }
}
