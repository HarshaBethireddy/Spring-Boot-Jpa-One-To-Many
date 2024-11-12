package com.harsha.demo.service;

import com.harsha.demo.model.Player;
import com.harsha.demo.model.Team;
import com.harsha.demo.repository.PlayerRepository;
import com.harsha.demo.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepo;
    private final TeamRepository teamRepo;

    public PlayerService(PlayerRepository playerRepo, TeamRepository teamRepo) {
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
    }

    @Transactional
    public Player createPlayer(Long teamId, Player player) {
        Team team = teamRepo.findById(teamId).orElseThrow(() -> new EntityNotFoundException("Team with id: " + teamId + " not found"));

        player.setTeam(team);
        team.getPlayers().add(player);
        return playerRepo.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public Player getPlayerById(Long playerId) {
        return playerRepo.findById(playerId).orElseThrow(() -> new EntityNotFoundException("Player with id: " + playerId + " not found"));
    }

    public Player updatePlayer(Long playerId, Player player) {
        Player currentPlayer = getPlayerById(playerId);

        currentPlayer.setName(player.getName());
        currentPlayer.setRole(player.getRole());
        currentPlayer.setBattingStyle(player.getBattingStyle());
        currentPlayer.setBowlingStyle(player.getBowlingStyle());
        currentPlayer.setMatchesPlayed(player.getMatchesPlayed());
        currentPlayer.setRunsScored(player.getRunsScored());
        currentPlayer.setWicketsTaken(player.getWicketsTaken());

        return playerRepo.save(currentPlayer);
    }

    public void deletePlayer(Long playerId) {
        if(playerRepo.existsById(playerId)) {
            playerRepo.deleteById(playerId);
            return;
        }
        throw new EntityNotFoundException("Player with id: " + playerId + " not found");
    }

    public List<Player> getPlayersByTeam(String teamName) {
        return playerRepo.findAllByTeam_Name(teamName);
    }
}
