package com.teammatch.tournament.UnitTests;

import com.teammatch.tournament.domain.model.Game;
import com.teammatch.tournament.domain.repository.GameRepository;
import com.teammatch.tournament.domain.service.GameService;
import com.teammatch.tournament.exception.ResourceNotFoundException;
import com.teammatch.tournament.service.GameServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(SpringExtension.class)
public class GameServiceImpIntegrationTest extends TournamentApplicationTests{
    @Autowired
    private GameService gameService;

    @MockBean
    private GameRepository gameRepository;

    @TestConfiguration
    static class GameServiceImplConfiguration {
        @Bean
        public GameService gameService(){ return new GameServiceImpl();}
    }

    @Test
    @DisplayName("When findById But Id Does Not Exists Return player not found for Id with value 1")
    public void whenFindByIdButIdDoesNotExistsReturnGameNotFound(){
        //Arrange
        String response = "Resource %s not found for %s with value %s";
        Game game = new Game();
        game.setId(1L).setName("CallofDuty").setPlatform("PC");

        Mockito.when(gameRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(response, "Game","Id", game.getId());
        //Act
        Throwable exception = catchThrowable(()-> {
            Game result = gameService.getGameById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
