package com.bip.interview.task.data.db;

import androidx.lifecycle.MutableLiveData;

import com.bip.interview.task.data.models.Team;

import java.util.List;

public interface TeamDAO {
//    @Query("Select * from teams_table")
    MutableLiveData<List<Team>> fetchAllTeamsFromDatabase();
}
