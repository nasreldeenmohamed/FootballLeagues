package com.bip.interview.task.modules.teams.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bip.interview.task.R;
import com.bip.interview.task.data.remote.models.TeamsListResponse;
import com.bip.interview.task.databinding.FragmentTeamsBinding;
import com.bip.interview.task.modules.teams.dataAccess.TeamsViewModel;

import java.util.Objects;

public class TeamsFragment extends Fragment {

    private FragmentTeamsBinding binding;
    private TeamsViewModel mViewModel;

    private TeamsAdapter adapter;
    private Observer<TeamsListResponse> listObserver;

    private int LeagueID = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_teams, container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TeamsViewModel.class);

        adapter = new TeamsAdapter();
        binding.rvTeams.setAdapter(adapter);

        assert getArguments() != null;
        LeagueID = TeamsFragmentArgs.fromBundle(getArguments()).getLeagueId();

        listObserver = teamsListResponse -> {
            if (teamsListResponse.getTeams() != null)
                adapter.setTeamList(teamsListResponse.getTeams());
            else
                binding.tvError.setVisibility(View.VISIBLE);

            if (binding.srTeams.isRefreshing())
                binding.srTeams.setRefreshing(false);
        };

        binding.srTeams.setRefreshing(true);
        mViewModel.getTeamsList(LeagueID).observe(this, listObserver);

        binding.srTeams.setOnRefreshListener(() ->
                mViewModel.getTeamsList(LeagueID).observe(Objects.requireNonNull(getActivity()), listObserver));

    }
}