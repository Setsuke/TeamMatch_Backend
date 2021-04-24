package com.teammatch.tournament.UnitTests;


import com.teammatch.tournament.domain.model.Sponsor;
import com.teammatch.tournament.domain.repository.SponsorRepository;
import com.teammatch.tournament.domain.service.SponsorService;
import com.teammatch.tournament.exception.ResourceNotFoundException;
import com.teammatch.tournament.service.SponsorServiceImpl;
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
public class SponsorServiceTest extends TournamentApplicationTests {
    @Autowired
    private SponsorService sponsorService;

    @MockBean
    private SponsorRepository sponsorRepository;

    @TestConfiguration
    static class SponsorServiceImpConfiguration{
        @Bean
        public SponsorService sponsorService(){ return new SponsorServiceImpl();}
    }

    @Test
    @DisplayName("When findById But Id Does Not Exists Return sponsor not found for Id with value 1")
    public void whenFindByIdButIdDoesNotExistsReturnSponsorNotFound(){
        //Arrange
        String response = "Resource %s not found for %s with value %s";
        Sponsor sponsor = new Sponsor();
        sponsor.setId(1L).setName("Logitech").setUrl("logitech.com");

        Mockito.when(sponsorRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(response, "Sponsor","Id", sponsor.getId());
        //Act
        Throwable exception = catchThrowable(()-> {
            Sponsor result = sponsorService.getSponsorById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
