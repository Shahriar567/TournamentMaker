package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.SoccerTeam;
import src.SoccerTournament;
import src.exception.TeamNotFoundException;
import src.Util.score;
import src.SoccerGames;

import static org.junit.jupiter.api.Assertions.*;

class SoccerTournamentTest {

    private SoccerTournament tournament;
    private String tournamentName = "La liga";

    @BeforeEach
    void setUp() {
        this.tournament = new SoccerTournament(this.tournamentName);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void tournamentName() {
        assertEquals(this.tournamentName, this.tournament.tournamentName());
    }

    @Test
    void getTeams() throws TeamNotFoundException {
        assertEquals(0, this.tournament.getTeams().size());
        SoccerTeam currentTeam = new SoccerTeam("Barcelona", "Spain");
        this.tournament.addTeams(currentTeam);
        assertEquals(1, this.tournament.getTeams().size());
        assertEquals(currentTeam, this.tournament.getTeams().getFirst());
    }

    @Test
    void addTeams() throws TeamNotFoundException {
        assertEquals(0, this.tournament.getTeams().size());
        SoccerTeam currentTeam = new SoccerTeam("Barcelona", "Spain");
        this.tournament.addTeams(currentTeam);
        assertEquals(1, this.tournament.getTeams().size());
        assertEquals(currentTeam, this.tournament.getTeams().getFirst());
    }

    @Test
    void getGames() throws TeamNotFoundException {
        assertEquals(0, this.tournament.getGames().size());
        SoccerTeam currentTeam = new SoccerTeam("Barcelona", "Spain");
        SoccerTeam opponenteam = new SoccerTeam("Real Madrid", "Spain");

        SoccerGames game1 = new SoccerGames("Barcelona vs Real", 20, currentTeam, opponenteam, 3, 3, score.DRAW);
        SoccerGames game2 = new SoccerGames("Barcelona vs Real", 20, currentTeam, opponenteam, 3, 3, score.DRAW);
        this.tournament.addTeams(currentTeam);
        this.tournament.addTeams(opponenteam);

        this.tournament.addGames(game1);
        assertEquals(1, this.tournament.getGames().size());
        this.tournament.addGames(game2);
        assertEquals(2, this.tournament.getGames().size());
    }

    @Test
    void addGames() throws TeamNotFoundException {
        assertEquals(0, this.tournament.getGames().size());
        SoccerTeam currentTeam = new SoccerTeam("Barcelona", "Spain");
        SoccerTeam opponenteam = new SoccerTeam("Real Madrid", "Spain");

        SoccerGames game1 = new SoccerGames("Barcelona vs Real", 20, currentTeam, opponenteam, 3, 3, score.DRAW);
        SoccerGames game2 = new SoccerGames("Barcelona vs Real", 20, currentTeam, opponenteam, 3, 3, score.DRAW);
        this.tournament.addTeams(currentTeam);
        this.tournament.addTeams(opponenteam);
        this.tournament.addGames(game1);
        assertEquals(1, this.tournament.getGames().size());
        this.tournament.addGames(game2);
        assertEquals(2, this.tournament.getGames().size());
    }

    @Test
    void setVenue() {
        assertEquals(null, this.tournament.getVenue());
        this.tournament.setVenue("Barcelona");
        assertEquals("Barcelona", this.tournament.getVenue());
    }

    @Test
    void getVenue() {
        assertEquals(null, this.tournament.getVenue());
        this.tournament.setVenue("Barcelona");
        assertEquals("Barcelona", this.tournament.getVenue());
    }
}