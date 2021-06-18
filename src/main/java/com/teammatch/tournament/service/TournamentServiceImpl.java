package com.teammatch.tournament.service;

import com.teammatch.tournament.domain.model.Player;
import com.teammatch.tournament.domain.model.Tournament;
import com.teammatch.tournament.domain.repository.OrganizerRepository;
import com.teammatch.tournament.domain.repository.PlayerRepository;
import com.teammatch.tournament.domain.repository.TournamentRepository;
import com.teammatch.tournament.domain.service.TournamentService;
import com.teammatch.tournament.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Page<Tournament> getAllTournaments(Pageable pageable) {
        return tournamentRepository.findAll(pageable);
    }

    @Override
    public Page<Tournament> getAllTournamentsByOrganizerId(Long organizerId, Pageable pageable) {
        return tournamentRepository.findByOrganizerId(organizerId,pageable);
    }

    @Override
    public Tournament getTournamentByIdAndOrganizerId(Long organizerId, Long tournamentId) {
        return tournamentRepository.findByIdAndOrganizerId(tournamentId , organizerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Tournament not found with Id " + tournamentId +
                                " and OrganizerId " + organizerId));
    }

    @Override
    public Tournament getTournamentById(Long tournamentId) {
        return tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Tournament", "Id", tournamentId));
    }

    @Override
    public Tournament createTournament(Long organizerId, Tournament tournament) {
        return organizerRepository.findById(organizerId).map(organizer->{
            tournament.setOrganizer(organizer);
            return tournamentRepository.save(tournament);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Organizer", "Id", organizerId));
    }

    @Override
    public Tournament updateTournament(Long organizerId, Long tournamentId, Tournament tournamentDetails) {
        if(!organizerRepository.existsById(organizerId))
            throw new ResourceNotFoundException("Organizer", "Id", organizerId);
        return tournamentRepository.findById(tournamentId).map(tournament -> {
            tournament.setName(tournamentDetails.getName());
            tournament.setDescription(tournamentDetails.getDescription());
            tournament.setPrize(tournamentDetails.getPrize());
            tournament.setPublicTournament(tournamentDetails.getPublicTournament());;
            tournament.setMaxTeams(tournamentDetails.getMaxTeams());

            tournament.setPlayers(tournamentDetails.getPlayers());
            tournament.setOrganizer(tournamentDetails.getOrganizer());
            return tournamentRepository.save(tournament);
        }).orElseThrow(() -> new ResourceNotFoundException("Tournament", "Id", tournamentId));
    }

    @Override
    public ResponseEntity<?> deleteTournament(Long organizerId, Long tournamentId) {
        return tournamentRepository.findByIdAndOrganizerId(tournamentId, organizerId).map(tournament -> {
            tournamentRepository.delete(tournament);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(
                "Tournament not found with Id " + tournamentId + " and OrganizerId " + organizerId));
    }

    @Override
    public Tournament assignTournamentPlayer(Long tournamentId, Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(()-> new ResourceNotFoundException("Player", "Id", playerId));
        return tournamentRepository.findById(tournamentId).map(tournamentMoreEnrollment -> {
            return tournamentRepository.save(tournamentMoreEnrollment.addToPlayer(player));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Tournament", "Id", tournamentId));
    }

    @Override
    public Tournament unAssignTournamentPlayer(Long tournamentId, Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(()-> new ResourceNotFoundException("Player", "Id", playerId));
        return tournamentRepository.findById(tournamentId).map(tournament -> {
            return tournamentRepository.save(tournament.deleteFromPlayer(player));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Tournament", "Id", tournamentId));
    }

    @Override
    public Page<Tournament> getAllTournamentsByPlayerId(Long playerId, Pageable pageable) {
        return playerRepository.findById(playerId).map(player -> {
            List<Tournament> tournament = player.getTournaments();
            return new PageImpl<>(tournament, pageable, tournament.size());
        }).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", playerId));
    }
}
