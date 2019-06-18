package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Util.score;
import src.SoccerGames;
import src.SoccerTeam;


import static org.junit.jupiter.api.Assertions.*;

class soccerGamesTest {

    private SoccerGames game;
    private String gameName = "Barcelona vs Real Madrid";
    private SoccerTeam hostTeam;
    private SoccerTeam opponentTeam;
    private int concededGoal = 3;
    private int goalsScore = 5;
    private int gameId = 881;
    private score result = score.WIN;

    @BeforeEach
    void setUp() {
        this.hostTeam = new SoccerTeam("Barcelona", "Spain");
        this.opponentTeam = new SoccerTeam("Real Madrid", "Spain");

        this.game = new SoccerGames(this.gameName, this.gameId, this.hostTeam, this.opponentTeam, this.concededGoal, this.goalsScore, result);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLossPoints() {
        int gameLossPoints = 0;
        assertEquals(gameLossPoints, this.game.GetLossPoints());
    }

    @Test
    void getWinPoints() {
        int gameWinPoints = 3;
        assertEquals(gameWinPoints, this.game.GetWinPoints());
    }

    @Test
    void getDrawPoints() {
        int gameDrawPoints = 0;
        assertEquals(gameDrawPoints, this.game.GetDrawPoints());
    }

    @Test
    void getGameId() {
    }

    @Test
    void getVenue() {
        assertEquals(null, this.game.getVenue());
        this.game.setVenue("Jurassick Park");
        assertEquals("Jurassick Park", this.game.getVenue());
    }

    @Test
    void setVenue() {
        assertEquals(null, this.game.getVenue());
        this.game.setVenue("Jurassick Park");
        assertEquals("Jurassick Park", this.game.getVenue());
    }

    @Test
    void setName() {
    }

    @Test
    void setHostTeam() {
    }

    @Test
    void setOpponentTeam() {
    }

    @Test
    void setRefferee() {
    }

    @Test
    void getDate() {
    }

    @Test
    void getName() {
    }

    @Test
    void getHostTeam() {
    }

    @Test
    void getOpponentTeam() {
    }

    @Test
    void getRefferee() {
    }

    @Test
    void getScore() {
    }
}