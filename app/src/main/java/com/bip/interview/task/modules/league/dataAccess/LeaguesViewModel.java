package com.bip.interview.task.modules.league.dataAccess;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bip.interview.task.data.models.Competition;
import com.bip.interview.task.data.repositories.LeaguesRepository;

import java.util.List;

public class LeaguesViewModel extends AndroidViewModel {

    private LeaguesRepository leaguesRepository;

    public LeaguesViewModel(@NonNull Application application) {
        super(application);
        leaguesRepository = new LeaguesRepository(application.getApplicationContext());
    }

    public MutableLiveData<List<Competition>> getLeaguesList() {
        return leaguesRepository.fetchLeaguesList();
    }
}
