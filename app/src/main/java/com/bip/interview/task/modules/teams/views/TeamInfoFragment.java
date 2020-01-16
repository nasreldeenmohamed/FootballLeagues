package com.bip.interview.task.modules.teams.views;

import android.net.Uri;
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
import com.bip.interview.task.data.models.Team;
import com.bip.interview.task.databinding.FragmentTeamInfoBinding;
import com.bip.interview.task.modules.teams.dataAccess.TeamInfoViewModel;
import com.bumptech.glide.Glide;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.util.Objects;

public class TeamInfoFragment extends Fragment {

    private TeamInfoViewModel mViewModel;
    private FragmentTeamInfoBinding binding;

    private SquadAdapter adapter;
    private Observer<Team> teamInfoResponseObserver;

    private int TeamID = 0;
    private String TeamName = "";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team_info, container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TeamInfoViewModel.class);

        adapter = new SquadAdapter();
        binding.rvSquad.setAdapter(adapter);

        assert getArguments() != null;
        TeamID = TeamInfoFragmentArgs.fromBundle(getArguments()).getTeamId();
        TeamName = TeamInfoFragmentArgs.fromBundle(getArguments()).getTeamName();

        teamInfoResponseObserver = team -> {
            if (team != null && team.getMessage() == null) {
                binding.setTeam(team);
                loadImage(team);
                if (team.getSquad() != null)
                    adapter.setPlayerList(team.getSquad());
            } else {
                binding.tvError.setVisibility(View.VISIBLE);
                binding.tvSquad.setVisibility(View.GONE);
            }
            if (binding.srTeamInfo.isRefreshing())
                binding.srTeamInfo.setRefreshing(false);
        };

        binding.srTeamInfo.setRefreshing(true);
        mViewModel.getTeamInfo(TeamID).observe(this, teamInfoResponseObserver);

        binding.srTeamInfo.setOnRefreshListener(() ->
                mViewModel.getTeamInfo(TeamID).observe(Objects.requireNonNull(getActivity()), teamInfoResponseObserver));

    }

    private void loadImage(Team team) {
        if (team.getCrestUrl() != null && team.getCrestUrl().contains("svg"))
            GlideToVectorYou.justLoadImage(getActivity(), Uri.parse(team.getCrestUrl()),
                    binding.ivTeam);
        else
            Glide.with(getActivity())
                    .load(team.getCrestUrl())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.ivTeam);
    }

}
