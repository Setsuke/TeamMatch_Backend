package com.teammatch.tournament.controller.Tournament;

import com.teammatch.tournament.domain.model.FreeTournament;
import com.teammatch.tournament.domain.service.FreeTournamentService;
import com.teammatch.tournament.resource.Tournament.FreeTournamentResource;
import com.teammatch.tournament.resource.Tournament.SaveFreeTournamentResource;
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
public class PlayerFreeTournamentsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private FreeTournamentService freeTournamentService;

    @GetMapping("/players/{playerId}/free-Tournaments")
    public Page<FreeTournamentResource> getAllFreeTournamentsByPlayerId(
            @PathVariable(name = "playerId") Long playerId,
            Pageable pageable) {
        Page<FreeTournament> freeTournamentPage = freeTournamentService.getAllFreeTournamentsByPlayerId(playerId, pageable);
        List<FreeTournamentResource> resources = freeTournamentPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());

    }
    private FreeTournament convertToEntity(SaveFreeTournamentResource resource) {
        return mapper.map(resource, FreeTournament.class);
    }
    private FreeTournamentResource convertToResource(FreeTournament entity) {
        return mapper.map(entity, FreeTournamentResource.class);
    }
}
