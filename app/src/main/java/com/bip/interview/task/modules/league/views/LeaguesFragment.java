package com.bip.interview.task.modules.league.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bip.interview.task.R;
import com.bip.interview.task.data.models.Competition;
import com.bip.interview.task.databinding.FragmentLeaguesBinding;
import com.bip.interview.task.modules.league.dataAccess.LeaguesViewModel;
import com.bip.interview.task.utils.BaseFragment;

import java.util.List;
import java.util.Objects;

public class LeaguesFragment extends BaseFragment {

    private FragmentLeaguesBinding binding;
    private LeaguesViewModel mViewModel;

    private LeaguesAdapter adapter;
    private Observer<List<Competition>> listObserver;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_leagues, container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LeaguesViewModel.class);

        adapter = new LeaguesAdapter();
        binding.rvLeagues.setAdapter(adapter);

        listObserver = competitions -> {
            if (competitions != null) {
                adapter.setCompetitionList(competitions);
            }
            if (binding.srLeague.isRefreshing())
                binding.srLeague.setRefreshing(false);
        };

        binding.srLeague.setRefreshing(true);
        mViewModel.getLeaguesList().observe(this, listObserver);

        binding.srLeague.setOnRefreshListener(() ->
                mViewModel.getLeaguesList().observe(Objects.requireNonNull(getActivity()), listObserver));

    }
}
