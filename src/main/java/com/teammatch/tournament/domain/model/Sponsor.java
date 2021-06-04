package com.teammatch.tournament.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "sponsors")
public class Sponsor extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private String url;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "sponsors")
    @JsonIgnore
    private List<Tournament> tournaments;

    public boolean hasTournamentWith(Tournament  Tournament) {
        return (this.getTournaments().contains(Tournament));
    }

    public Sponsor tournamentWith(Tournament tournament) {
        if(!this.hasTournamentWith(tournament)) {
            this.getTournaments().add(tournament);
        }
        return this;
    }

    public Sponsor unTournamentWith(Tournament tournament) {
        if(this.hasTournamentWith(tournament)) {
            this.getTournaments().remove(tournament);
        }
        return this;
    }

    public Long getId() {
        return id;
    }

    public Sponsor setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sponsor setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Sponsor setUrl(String url) {
        this.url = url;
        return this;
    }




    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public Sponsor setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
        return this;
    }

}
