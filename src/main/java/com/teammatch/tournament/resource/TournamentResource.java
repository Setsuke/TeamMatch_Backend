package com.teammatch.tournament.resource;

import com.teammatch.tournament.domain.model.AuditModel;
import com.teammatch.tournament.resource.Tournament.FreeTournamentResource;

import java.sql.Date;

public class TournamentResource  extends AuditModel {
    private Long id;

    private String name;

    private String description;

    private Double prize;

    private Boolean publicTournament;

    private Date dateOfTournament;

    private Integer maxTeams;

    public Long getId() {return id;}

    public TournamentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TournamentResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TournamentResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrize() {
        return prize;
    }

    public TournamentResource setPrize(Double prize) {
        this.prize = prize;
        return this;
    }

    public Boolean getPublicTournament() {
        return publicTournament;
    }

    public TournamentResource setPublicTournament(Boolean publicTournament) {
        this.publicTournament = publicTournament;
        return this;
    }

    public java.util.Date getDateOfTournament() {
        return dateOfTournament;
    }

    public TournamentResource setDateOfTournament(java.util.Date dateOfTournament) {
        this.dateOfTournament = (Date) dateOfTournament;
        return this;
    }

    public Integer getMaxTeams() {
        return maxTeams;
    }

    public TournamentResource setMaxTeams(Integer maxTeams) {
        this.maxTeams = maxTeams;
        return this;
    }
}
