package com.teammatch.tournament.domain.service;

import com.teammatch.tournament.domain.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PlayerService {
    Page<Player> getAllPlayers(Pageable pageable);
    Player getPlayerById(Long playerId);
    Player createPlayer(Player player);
    Player updatePlayer(Long playerId, Player playerRequest);
    ResponseEntity<?> deletePlayer(Long playerId);
    Player getPlayerByLevel(Integer level);
    Player addPlayerToChat(Long playerId, Long chatId);
    Player deletePlayerFromChat(Long playerId, Long chatId);
    Page<Player> getAllPlayersByChatId(Long chatId, Pageable pageable);

    Page<Player> getAllPlayersByTournamentId(Long tournamentId, Pageable pageable);
    /*Page<Player>getAllPlayersByFilterId(Long filterId, Pageable pageable);
    Player getPlayerByIdAndFilterId(Long playerId, Long filterId);*/
}
