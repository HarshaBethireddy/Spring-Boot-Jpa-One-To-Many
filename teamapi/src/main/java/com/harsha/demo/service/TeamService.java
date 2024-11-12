package com.harsha.demo.service;

import com.harsha.demo.model.Team;
import com.harsha.demo.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepo;

    public TeamService(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    public Team createTeam(Team team) {
        return teamRepo.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    public Team getTeamById(Long teamId) {
        return teamRepo.findById(teamId).orElseThrow(() -> new EntityNotFoundException("Team with id: " + teamId + " not found"));
    }

    public Team updateTeam(Long teamId, Team team) {
        Team currentTeam = getTeamById(teamId);

        if(currentTeam.getName() != null) currentTeam.setName(team.getName());
        if(currentTeam.getCoach() != null) currentTeam.setCoach(team.getCoach());
        if(currentTeam.getCaptain() != null) currentTeam.setCaptain(team.getCaptain());
        if(currentTeam.getFoundedYear() != 0) currentTeam.setFoundedYear(team.getFoundedYear());
        if(currentTeam.getChampionshipsWon() != team.getChampionshipsWon()) currentTeam.setChampionshipsWon(team.getChampionshipsWon());

        return teamRepo.save(currentTeam);
    }

    public void deleteTeam(Long teamId) {
        if(teamRepo.existsById(teamId)) {
            teamRepo.deleteById(teamId);
            return;
        } else {
            throw new EntityNotFoundException("Team with id: " + teamId + " not found");
        }
    }
}
