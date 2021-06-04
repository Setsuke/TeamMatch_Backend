package com.teammatch.tournament.controller;

import com.teammatch.tournament.domain.model.Tournament;
import com.teammatch.tournament.domain.service.TournamentService;
import com.teammatch.tournament.resource.SaveTournamentResource;
import com.teammatch.tournament.resource.Tournament.FreeTournamentResource;
import com.teammatch.tournament.resource.Tournament.SaveFreeTournamentResource;
import com.teammatch.tournament.resource.TournamentResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PlayerTournamentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TournamentService tournamentService;


    @GetMapping("/players/{playerId}/tournaments")
    public Page<TournamentResource> getAllTournamentsByPlayerId(
            @PathVariable(name = "playerId") Long playerId,
            Pageable pageable) {
        Page<Tournament> tournamentPage = tournamentService.getAllTournamentsByPlayerId(playerId, pageable);
        List<TournamentResource> resources = tournamentPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());

    }
    private Tournament convertToEntity(SaveTournamentResource resource) {
        return mapper.map(resource, Tournament.class);
    }
    private TournamentResource convertToResource(Tournament entity) {
        return mapper.map(entity, TournamentResource.class);
    }
}
