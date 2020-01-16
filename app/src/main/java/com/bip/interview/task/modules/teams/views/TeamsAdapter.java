package com.bip.interview.task.modules.teams.views;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bip.interview.task.R;
import com.bip.interview.task.data.models.Team;
import com.bip.interview.task.databinding.ItemTeamBinding;
import com.bumptech.glide.Glide;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.util.List;

import static androidx.navigation.Navigation.findNavController;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamViewHolder> {

    private List<Team> teams;
    private Context context;

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemTeamBinding teamBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_team, viewGroup, false);
        this.context = viewGroup.getContext();
        return new TeamViewHolder(teamBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder competitionViewHolder, int i) {
        Team team = teams.get(i);
        competitionViewHolder.itemTeamBinding.setTeam(team);

        if (team.getCrestUrl() != null && team.getCrestUrl().contains("svg"))
            GlideToVectorYou.justLoadImage((Activity) context, Uri.parse(team.getCrestUrl()),
                    competitionViewHolder.itemTeamBinding.ivTeamLogo);
        else
            Glide.with(context)
                    .load(team.getCrestUrl())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(competitionViewHolder.itemTeamBinding.ivTeamLogo);

        competitionViewHolder.itemTeamBinding.llTeam.setOnClickListener(v -> {
            findNavController(v).navigate(TeamsFragmentDirections.actionTeamsFragmentToTeamInfoFragment(team.getName())
                    .setTeamId(team.getId()).setTeamName(team.getName()));
        });
    }

    @Override
    public int getItemCount() {
        if (teams != null) {
            return teams.size();
        } else {
            return 0;
        }
    }

    void setTeamList(List<Team> employees) {
        this.teams = employees;
        notifyDataSetChanged();
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {

        private ItemTeamBinding itemTeamBinding;

        TeamViewHolder(@NonNull ItemTeamBinding itemTeamBinding) {
            super(itemTeamBinding.getRoot());
            this.itemTeamBinding = itemTeamBinding;
        }
    }
}