package com.teammatch.tournament.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="tournaments")
public class Tournament extends AuditModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Double prize;
    @NotNull
    private Boolean publicTournament;
    @NotNull
    private Date dateOfTournament;
    @NotNull
    private Integer maxTeams;

    //RelationShip Player
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "player_tournaments", joinColumns = {@JoinColumn(name = "player_id")},
            inverseJoinColumns = {@JoinColumn(name="tournament_id")})
    @JsonIgnore
    private List<Player> players;

    public boolean isInPlayer(Player player){       // Business methods
        return (this.getPlayers().contains(player));
    }

    public Tournament addToPlayer(Player player) {
        if(!this.isInPlayer(player)) {
            this.getPlayers().add(player);
        }
        return this;
    }

    public Tournament deleteFromPlayer(Player player) {
        if(this.isInPlayer(player)) {
            this.getPlayers().remove(player);
        }
        return this;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Tournament setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    //RelationShip Team
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tournament_teams", joinColumns = {@JoinColumn(name = "tournament_id")}, inverseJoinColumns = {@JoinColumn(name="team_id")})
    @JsonIgnore
    private List<Team> teams;

    public boolean isInTeam(Team team){       // Business methods
        return (this.getTeams().contains(team));
    }

    public Tournament addToTeam(Team team) {
        if(!this.isInTeam(team)) {
            this.getTeams().add(team);
        }
        return this;
    }

    public Tournament deleteFromTeam(Team team) {
        if(this.isInTeam(team)) {
            this.getTeams().remove(team);
        }
        return this;
    }

    public List<Team> getTeams() {
        return teams;
    }
    public Tournament setTeams(List<Player> players) {
        this.players = players;
        return this;
    }



    //RelationShip Sponsor
    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tournament_sponsor",
    joinColumns = {@JoinColumn(name = "tournament_id")},
    inverseJoinColumns = {@JoinColumn(name = "sponsor_id")})
    @JsonIgnore
    private List<Sponsor> sponsors;

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public Tournament setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
        return this;
    }




   // private Date startDate;


   // private Date endDate;


    //private Date startHour;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organizer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)


    private Organizer organizer;




    public Long getId() {
        return id;
    }

    public Tournament setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Tournament setName (String name) {
        this.name = name;
        return this;
    }


    public Organizer getOrganizer() {
        return organizer;
    }

    public Tournament setOrganizer(Organizer organizer) {
        this.organizer = organizer;
        return this;
    }





    public String getDescription() {
        return description;
    }

    public Tournament setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrize() {
        return prize;
    }

    public Tournament setPrize(Double prize) {
        this.prize = prize;
        return this;
    }

    public Boolean getPublicTournament() {
        return publicTournament;
    }

    public Tournament setPublicTournament(Boolean publicTournament) {
        this.publicTournament = publicTournament;
        return this;
    }


    public Date getDateOfTournament() {
        return dateOfTournament;
    }

    public Tournament setDateOfTournament(Date dateOfTournament) {
        this.dateOfTournament = dateOfTournament;
        return this;
    }

    public Integer getMaxTeams() {
        return maxTeams;
    }

    public Tournament setMaxTeams(Integer maxTeams) {
        this.maxTeams = maxTeams;
        return this;
    }
}