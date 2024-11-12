package com.harsha.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;
    private String battingStyle;
    private String bowlingStyle;
    private int matchesPlayed;
    private int runsScored;
    private int wicketsTaken;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;

    public Player() {
    }

    public Player(Long id, String name, String role, String battingStyle, String bowlingStyle, int matchesPlayed, int runsScored, int wicketsTaken, Team team) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
        this.wicketsTaken = wicketsTaken;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBattingStyle() {
        return battingStyle;
    }

    public void setBattingStyle(String battingStyle) {
        this.battingStyle = battingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
