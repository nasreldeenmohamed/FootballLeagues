package com.bip.interview.task.data.repositories;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.bip.interview.task.data.models.Competition;
import com.bip.interview.task.data.remote.RetrofitRepository;
import com.bip.interview.task.utils.ConnectionDetector;

import java.util.List;

public class LeaguesRepository {
    private Context context;

    public LeaguesRepository(Context context) {
        this.context = context;
    }

    public MutableLiveData<List<Competition>> fetchLeaguesList() {
        if (ConnectionDetector.checkInternetConnection(context))
            return fetchCompetitionsListFromRemote();
        else
            return fetchCompetitionsListFromDatabase();
    }

    private MutableLiveData<List<Competition>> fetchCompetitionsListFromRemote() {
        return RetrofitRepository.getInstance().fetchLeaguesList();
    }

    private MutableLiveData<List<Competition>> fetchCompetitionsListFromDatabase() {
        return new MutableLiveData<>();
    }

}
