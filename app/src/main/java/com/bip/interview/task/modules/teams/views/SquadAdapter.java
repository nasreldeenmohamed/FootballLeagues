package com.bip.interview.task.modules.teams.views;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bip.interview.task.R;
import com.bip.interview.task.data.models.Player;
import com.bip.interview.task.databinding.ItemPlayerBinding;

import java.util.List;

public class SquadAdapter extends RecyclerView.Adapter<SquadAdapter.PlayerViewHolder> {
    private List<Player> players;

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemPlayerBinding playerBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_player, viewGroup, false);
        return new PlayerViewHolder(playerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder competitionViewHolder, int i) {
        Player player = players.get(i);
        competitionViewHolder.itemPlayerBinding.setPlayer(player);
    }

    @Override
    public int getItemCount() {
        if (players != null) {
            return players.size();
        } else {
            return 0;
        }
    }

    void setPlayerList(List<Player> employees) {
        this.players = employees;
        notifyDataSetChanged();
    }

    class PlayerViewHolder extends RecyclerView.ViewHolder {

        private ItemPlayerBinding itemPlayerBinding;

        PlayerViewHolder(@NonNull ItemPlayerBinding itemPlayerBinding) {
            super(itemPlayerBinding.getRoot());
            this.itemPlayerBinding = itemPlayerBinding;
        }
    }
}