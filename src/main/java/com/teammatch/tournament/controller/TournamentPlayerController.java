package com.teammatch.tournament.controller;

import com.teammatch.tournament.domain.model.Player;
import com.teammatch.tournament.domain.model.Tournament;
import com.teammatch.tournament.domain.service.PlayerService;
import com.teammatch.tournament.domain.service.TournamentService;
import com.teammatch.tournament.resource.PlayerResource;
import com.teammatch.tournament.resource.SavePlayerResource;
import com.teammatch.tournament.resource.SaveTournamentResource;
import com.teammatch.tournament.resource.TournamentResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Tournament", description = "Tournament API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class TournamentPlayerController {
    private ModelMapper mapper;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private PlayerService playerService;
    @PostMapping("/tournaments/{tournamentId}/players/{playerId}")
    public TournamentResource assignTournamentPlayer(
            @PathVariable(name = "tournamentId") Long tournamentId,
            @PathVariable(name = "playerId") Long playerId) {
        return convertToResource(tournamentService.assignTournamentPlayer(tournamentId,playerId));
    }

    @DeleteMapping("/tournaments/{tournamentId}/players/{playerId}")
    public TournamentResource unassignTournamentPlayer(
            @PathVariable(name = "tournamentId") Long tournamentId,
            @PathVariable(name = "playerId") Long playerId) {
        return convertToResource(tournamentService.unAssignTournamentPlayer(tournamentId, playerId));
    }


    @GetMapping("/tournaments/{tournamentId}/players")
    public Page<PlayerResource> getAllPlayersByTournamentId(
            @PathVariable(name = "tournamentId") Long tournamentId,
            Pageable pageable) {
        List<PlayerResource> players = playerService.getAllPlayersByTournamentId(tournamentId,pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int playersCount = players.size();
        return new PageImpl<>(players, pageable, playersCount);
    }

    private Tournament convertToEntity(SaveTournamentResource resource) {
        return mapper.map(resource, Tournament.class);
    }

    private TournamentResource convertToResource(Tournament entity) {
        return mapper.map(entity, TournamentResource.class);
    }

    private Player convertToEntity(SavePlayerResource resource) {
        return mapper.map(resource, Player.class);
    }
    private PlayerResource convertToResource(Player entity) {
        return mapper.map(entity, PlayerResource.class);
    }

}
