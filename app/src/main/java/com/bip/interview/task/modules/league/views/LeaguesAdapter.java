package com.bip.interview.task.modules.league.views;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bip.interview.task.R;
import com.bip.interview.task.data.models.Competition;
import com.bip.interview.task.databinding.ItemLeagueBinding;

import java.util.List;

import static androidx.navigation.Navigation.findNavController;

public class LeaguesAdapter extends RecyclerView.Adapter<LeaguesAdapter.CompetitionViewHolder> {

    private List<Competition> leagues;

    @NonNull
    @Override
    public CompetitionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemLeagueBinding itemLeagueBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_league, viewGroup, false);
        return new CompetitionViewHolder(itemLeagueBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionViewHolder competitionViewHolder, int i) {
        final Competition league = leagues.get(i);
        competitionViewHolder.itemLeagueBinding.setLeague(league);

        competitionViewHolder.itemLeagueBinding.llLeague.setOnClickListener(v -> {
            findNavController(v).navigate(LeaguesFragmentDirections.actionLeaguesFragmentToTeamsFragment(league.getId()));
        });
    }

    @Override
    public int getItemCount() {
        if (leagues != null) {
            return leagues.size();
        } else {
            return 0;
        }
    }

    void setCompetitionList(List<Competition> employees) {
        this.leagues = employees;
        notifyDataSetChanged();
    }

    class CompetitionViewHolder extends RecyclerView.ViewHolder {

        private ItemLeagueBinding itemLeagueBinding;

        CompetitionViewHolder(@NonNull ItemLeagueBinding itemLeagueBinding) {
            super(itemLeagueBinding.getRoot());
            this.itemLeagueBinding = itemLeagueBinding;
        }
    }
}