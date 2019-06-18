package tests;

import src.SoccerCoaches;
import src.SoccerGames;
import src.SoccerPlayer;
import src.SoccerTeam;
import src.Util.score;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.exception.*;

import static org.junit.jupiter.api.Assertions.*;

class SoccerTeamTest {

    private SoccerTeam testTeamHost;
    private SoccerTeam testTeamOpponent;
    private SoccerGames game1;
    private SoccerGames game2;
    private SoccerGames game3;
    private int concededGoalGame1 = 3;
    private int concededGoalGame2 = 0;
    private int concededGoalGame3 = 3;
    private int goalsScoreGame1 = 3;
    private int goalsScoreGame2 = 2;
    private int goalsScoreGame3 = 1;
    private score resultGame1 = score.DRAW;
    private score resultGame2 = score.WIN;
    private score resultGame3 = score.LOSS;

    public final Class<PlayerLimitExcededException> exception = PlayerLimitExcededException.class;


    @BeforeEach
    void setUp() {
        this.testTeamHost = new SoccerTeam("Barcelona", "Spain");
        this.testTeamOpponent = new SoccerTeam("Real Madrid", "Spain");
        this.game1 = new SoccerGames("Barcelona vs Real Madrid", 001, this.testTeamHost, this.testTeamOpponent, this.concededGoalGame1, this.goalsScoreGame1, resultGame1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addPlayers() throws PlayerLimitExcededException, PlayerWithSameNameAlreadyAddedException, PlayerNotFoundException {
        SoccerPlayer player1 = new SoccerPlayer("Messi GOAT", "Messi", 10);
        SoccerPlayer player2 = new SoccerPlayer("Ronaldo GOAT", "CR07", 07);
        SoccerPlayer player3 = new SoccerPlayer("Da dhea", "GG", 01);
        SoccerPlayer player4 = new SoccerPlayer("Mo Salah", "King of Egypt", 9);
        SoccerPlayer player5 = new SoccerPlayer("Messi GOAT in months", "Messi", 10);
        SoccerPlayer player6 = new SoccerPlayer("Ronaldo GOsdfAT", "CR07", 07);
        SoccerPlayer player7 = new SoccerPlayer("Da dheasda", "GG", 01);
        SoccerPlayer player8 = new SoccerPlayer("Mo Sagfsdlah", "King of Egypt", 9);
        SoccerPlayer player9 = new SoccerPlayer("Messi GOawseAT", "Messi", 10);
        SoccerPlayer player10 = new SoccerPlayer("Ronaldo GOATvsda", "CR07", 07);
        SoccerPlayer player11 = new SoccerPlayer("Da asedhea", "GG", 01);
        SoccerPlayer player12 = new SoccerPlayer("Mo Salavcasdh", "King of Egypt", 9);

        this.testTeamHost.addPlayers(player1);
        this.testTeamHost.addPlayers(player2);
        assertEquals(2, this.testTeamHost.getAllPlayers().size());
        this.testTeamHost.addPlayers(player3);
        this.testTeamHost.addPlayers(player4);
        assertEquals(4, this.testTeamHost.getAllPlayers().size());
        this.testTeamHost.addPlayers(player5);
        this.testTeamHost.addPlayers(player6);
        this.testTeamHost.addPlayers(player7);
        this.testTeamHost.addPlayers(player8);
        this.testTeamHost.addPlayers(player9);
        this.testTeamHost.addPlayers(player10);
        assertEquals(10, this.testTeamHost.getAllPlayers().size());
        this.testTeamHost.addPlayers(player11);
        assertEquals(11, this.testTeamHost.getAllPlayers().size());
    }

    @Test
    void playerExceededTest() throws PlayerLimitExcededException, PlayerWithSameNameAlreadyAddedException, PlayerNotFoundException {
        SoccerPlayer player1 = new SoccerPlayer("Messi GOAT", "Messi", 10);
        SoccerPlayer player2 = new SoccerPlayer("Ronaldo GOAT", "CR07", 07);
        SoccerPlayer player3 = new SoccerPlayer("Da dhea", "GG", 01);
        SoccerPlayer player4 = new SoccerPlayer("Mo Salah", "King of Egypt", 9);
        SoccerPlayer player5 = new SoccerPlayer("Messi GOATsdf ", "Messi", 10);
        SoccerPlayer player6 = new SoccerPlayer("Ronaldo GOATasdf ", "CR07", 07);
        SoccerPlayer player7 = new SoccerPlayer("Da dheaasf ", "GG", 01);
        SoccerPlayer player8 = new SoccerPlayer("Mo Salasfdgh", "King of Egypt", 9);
        SoccerPlayer player9 = new SoccerPlayer("Messi GOasdg AT", "Messi", 10);
        SoccerPlayer player10 = new SoccerPlayer("Ronaldo GOsdg AT", "CR07", 07);
        SoccerPlayer player11 = new SoccerPlayer("Da dheasadf ", "GG", 01);
        SoccerPlayer player12 = new SoccerPlayer("Mo Salaasdfgh", "King of Egypt", 9);

        this.testTeamHost.addPlayers(player1);
        this.testTeamHost.addPlayers(player2);
        this.testTeamHost.addPlayers(player3);
        this.testTeamHost.addPlayers(player4);
        this.testTeamHost.addPlayers(player5);
        this.testTeamHost.addPlayers(player6);
        this.testTeamHost.addPlayers(player7);
        this.testTeamHost.addPlayers(player8);
        this.testTeamHost.addPlayers(player9);
        this.testTeamHost.addPlayers(player10);
        this.testTeamHost.addPlayers(player11);

        assertEquals(11, this.testTeamHost.getAllPlayers().size());
        assertThrows(PlayerLimitExcededException.class, () -> {this.testTeamHost.addPlayers(player12);});
    }

    @Test
    void getPlayer() throws PlayerLimitExcededException, PlayerNotFoundException, PlayerWithSameNameAlreadyAddedException {
        SoccerPlayer player1 = new SoccerPlayer("Messi GOAT", "Messi", 10);
        SoccerPlayer player2 = new SoccerPlayer("Ronaldo GOAT", "CR07", 07);

        this.testTeamHost.addPlayers(player1);
        this.testTeamHost.addPlayers(player2);

        assertEquals(player1, this.testTeamHost.getPlayer("Messi GOAT"));
        assertEquals(player2, this.testTeamHost.getPlayer("Ronaldo GOAT"));
        assertThrows(PlayerNotFoundException.class, () -> {this.testTeamHost.getPlayer(" GOAT");});
    }

    @Test
    void addCoach() throws CoachLimitExcededException, PlayerWithSameNameAlreadyAddedException {
        SoccerCoaches coach1 = new SoccerCoaches("Jose Mursino", "Daye", 120);
        SoccerCoaches coach2 = new SoccerCoaches("Jose defd", "Hut", 120);
        SoccerCoaches coach3 = new SoccerCoaches("de Murinoas", "youkon", 120);
        SoccerCoaches coach4 = new SoccerCoaches("de Murinoasdfs", "youkon", 120);

        this.testTeamHost.addCoach(coach1);
        this.testTeamHost.addCoach(coach2);
        this.testTeamHost.addCoach(coach3);

        assertEquals(3, this.testTeamHost.getAllCoaches().size());

        this.testTeamHost.addCoach(coach4);
        assertThrows(CoachLimitExcededException.class, () -> {this.testTeamHost.addCoach(coach3);});
    }

    @Test
    void getCoach() throws CoachLimitExcededException, CoachNotFoundException, PlayerWithSameNameAlreadyAddedException {
        SoccerCoaches coach1 = new SoccerCoaches("Jose Murino", "Daye", 120);
        SoccerCoaches coach2 = new SoccerCoaches("Jose de", "Hut", 120);
        SoccerCoaches coach3 = new SoccerCoaches("de Murino", "youkon", 120);

        this.testTeamHost.addCoach(coach1);
        this.testTeamHost.addCoach(coach2);
        this.testTeamHost.addCoach(coach3);

        assertEquals(coach1, this.testTeamHost.getCoach("Jose Murino"));
        assertThrows(CoachNotFoundException.class, () -> {this.testTeamHost.getCoach("Shahriar");});
    }

    @Test
    void addGame() {
        SoccerGames game = new SoccerGames("Barcelona vs Real", 20, this.testTeamHost, this.testTeamOpponent, 3, 3, score.DRAW);
        this.testTeamHost.addGame(game);
        assertEquals(1, this.testTeamHost.getAllGames().size());
    }

    @Test
    void getAllGames() {
        SoccerGames game = new SoccerGames("Barcelona vs Real", 20, this.testTeamHost, this.testTeamOpponent, 3, 3, score.DRAW);
        this.testTeamHost.addGame(game);
        assertEquals(1, this.testTeamHost.getAllGames().size());
    }

    @Test
    void getGame() {
        SoccerGames game = new SoccerGames("Barcelona vs Real", 20, this.testTeamHost, this.testTeamOpponent, 3, 3, score.DRAW);
        this.testTeamHost.addGame(game);
        assertEquals(game, this.testTeamHost.getGame(20));
    }
}