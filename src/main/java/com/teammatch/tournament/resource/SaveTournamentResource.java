package com.teammatch.tournament.resource;

import com.teammatch.tournament.resource.Tournament.SaveFreeTournamentResource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class SaveTournamentResource {
    @NotNull(message = "Missing Tournament name")
    @NotBlank
    @Size(min = 3, message = "Name needs to have between 3 to 50 characters")
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String prize;
    @NotNull
    private Boolean publicTournament;
    @NotNull
    private Date dateOfTournament;
    @NotNull
    private Integer maxTeams;


    public String getName() {
        return name;
    }

    public SaveTournamentResource setName(String name) {
        this.name = name;
        return this;
    }




    public String getDescription() {
        return description;
    }

    public SaveTournamentResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPrize() {
        return prize;
    }

    public SaveTournamentResource setPrize(String prize) {
        this.prize = prize;
        return this;
    }

    public Boolean getPublicTournament() {
        return publicTournament;
    }

    public SaveTournamentResource setPublicTournament(Boolean publicTournament) {
        this.publicTournament = publicTournament;
        return this;
    }

    public Date getDateOfTournament() {
        return dateOfTournament;
    }

    public SaveTournamentResource setDateOfTournament(Date dateOfTournament) {
        this.dateOfTournament = dateOfTournament;
        return this;
    }

    public Integer getMaxTeams() {
        return maxTeams;
    }

    public SaveTournamentResource setMaxTeams(Integer maxTeams) {
        this.maxTeams = maxTeams;
        return this;
    }
}
