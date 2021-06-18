package com.teammatch.tournament.UnitTests;

import com.teammatch.tournament.domain.model.Chat;
import com.teammatch.tournament.domain.repository.ChatRepository;
import com.teammatch.tournament.domain.service.ChatService;
import com.teammatch.tournament.exception.ResourceNotFoundException;
import com.teammatch.tournament.service.ChatServiceImpl;
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
public class ChatServiceImplIntegrationTest extends TournamentApplicationTests{
    @Autowired
    private ChatService chatService;

    @MockBean
    private ChatRepository chatRepository;

    @TestConfiguration
    static class ChatServiceImplConfiguration{
        @Bean
        public ChatService chatService(){ return new ChatServiceImpl();}
    }

    @Test
    @DisplayName("When findById But Id Does Not Exists Return player not found for Id with value 1")
    public void whenFindByIdButIdDoesNotExistsReturnChatNotFound(){
        //Arrange
        String response = "Resource %s not found for %s with value %s";
        Chat chat = new Chat();
        chat.setId(1L);

        Mockito.when(chatRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(response, "Chat","Id", chat.getId());
        //Act
        Throwable exception = catchThrowable(()-> {
            Chat result = chatService.getChatById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
