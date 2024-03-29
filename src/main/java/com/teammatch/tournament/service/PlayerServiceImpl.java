package com.teammatch.tournament.service;

import com.teammatch.tournament.domain.model.Chat;
import com.teammatch.tournament.domain.model.Player;
import com.teammatch.tournament.domain.repository.*;
import com.teammatch.tournament.domain.service.PlayerService;
import com.teammatch.tournament.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private TournamentRepository tournamentRepository;


    @Override
    public Page<Player> getAllPlayers(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    @Override
    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Player", "Id", playerId));
    }

    /*@Override
    public Page<Player> getAllPlayersByFilterId(Long filterId, Pageable pageable) {
        return playerRepository.findByFilterId(filterId, pageable);
    }

    @Override
    public Player getPlayerByIdAndFilterId(Long filterId, Long playerId) {
        return playerRepository.findByIdAndFilterId(playerId , filterId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Player not found with Id " + playerId +
                                " and FilterId " + filterId));
    }*/

    @Override
    public Player createPlayer(Player player) { return playerRepository.save(player); }

    @Override
    public Player updatePlayer(Long playerId, Player playerRequest) {

        return playerRepository.findById(playerId).map(player -> {
            player.setLevel((playerRequest.getLevel()));
            player.setHoursPlayed(playerRequest.getHoursPlayed());
            player.setKillDeathRatio((playerRequest.getKillDeathRatio()));
            player.setUsername(playerRequest.getUsername());
            player.setPassword(playerRequest.getPassword());
            player.setFirstName(playerRequest.getFirstName());
            player.setLastName(playerRequest.getLastName());
            player.setUsername(playerRequest.getUsername());
            player.setDescription(playerRequest.getDescription());
            player.setGender(playerRequest.getGender());
            player.setEmailAddress(playerRequest.getEmailAddress());
            player.setPhoneNumber(playerRequest.getPhoneNumber());
            player.setBirthDate(playerRequest.getBirthDate());

            return playerRepository.save(player);
        }).orElseThrow(()->new ResourceNotFoundException("Player","Id",playerId));

    }

    @Override
    public ResponseEntity<?> deletePlayer(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Player", "Id", playerId));
        playerRepository.delete(player);
        return ResponseEntity.ok().build();
    }


    @Override
    public Player getPlayerByLevel(Integer level) {
        return playerRepository.findByLevel(level)
                .orElseThrow(()->new ResourceNotFoundException("Player","Level",level));
    }

    @Override
    public Player addPlayerToChat(Long playerId, Long chatId) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(()-> new ResourceNotFoundException("Chat", "Id", chatId));
        return playerRepository.findById(playerId).map(player -> {
            return playerRepository.save(player.addToChat(chat));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Player", "Id", playerId));
    }

    @Override
    public Player deletePlayerFromChat(Long playerId, Long chatId) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Chat", "Id", chatId));
        return playerRepository.findById(playerId).map(player -> {
            return playerRepository.save(player.deleteFromChat(chat));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Player", "Id", playerId));
    }

    @Override
    public Page<Player> getAllPlayersByChatId(Long chatId, Pageable pageable) {
        return chatRepository.findById(chatId).map( chat -> {
            List<Player> players = chat.getParticipants();
            return new PageImpl<>(players, pageable, players.size());
        }).orElseThrow(() -> new ResourceNotFoundException( "Chat", "Id", chatId));
    }

    @Override
    public Page<Player> getAllPlayersByTournamentId(Long tournamentId, Pageable pageable) {
        return tournamentRepository.findById(tournamentId).map( tournament -> {
            List<Player> players = tournament.getPlayers();
            return new PageImpl<>(players, pageable, players.size());
        }).orElseThrow(() -> new ResourceNotFoundException( "Tournament", "Id", tournamentId));
    }
}
