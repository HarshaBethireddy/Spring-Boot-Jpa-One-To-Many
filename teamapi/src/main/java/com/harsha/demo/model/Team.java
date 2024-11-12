package com.harsha.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String coach;
    private String captain;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private Set<Player> players = new HashSet<>();

    private int foundedYear;
    private int championshipsWon;

    public Team() {
    }

    public Team(Long id, String name, String coach, String captain, Set<Player> players, int foundedYear, int championshipsWon) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.captain = captain;
        this.players = players;
        this.foundedYear = foundedYear;
        this.championshipsWon = championshipsWon;
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

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public int getChampionshipsWon() {
        return championshipsWon;
    }

    public void setChampionshipsWon(int championshipsWon) {
        this.championshipsWon = championshipsWon;
    }
}
