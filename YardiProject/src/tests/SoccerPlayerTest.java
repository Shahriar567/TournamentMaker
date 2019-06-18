package tests;
import org.junit.jupiter.api.Test;
import src.SoccerPlayer;
import src.SoccerTeam;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;


class SoccerPlayerTest {

    private SoccerPlayer player;
    private SoccerTeam currentTeam;
    private SoccerTeam previousTeam;
    private String name = "Shahriar";
    private String nickName = "Nova";
    private int playerAge = 19;
    private int height = 16;
    private String sex = "male";
    private int rating = 89;
    private int playerNumber = 07;
    private int socialScore = 98;
    private String dominentFoot = "Left";
    private String position = "Center Forward";
    private int totalGoalsScored;
    private int totalGoalsScoredRightFoot;
    private int totalGoalsScoredLeftFoot;
    private int totalRedCards;
    private int totalYellowCards;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.currentTeam = new SoccerTeam("Barcelona", "Spain");
        this.previousTeam = new SoccerTeam("Barcelona", "Spain");
        this.player = new SoccerPlayer(name, nickName, playerNumber);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals(this.name, this.player.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        this.player.setName("NewName");
        assertNotEquals(this.name, this.player.getName());
        assertEquals("NewName", this.player.getName());
    }

    @org.junit.jupiter.api.Test
    void getNickName() {
        assertEquals(this.nickName, this.player.getNickName());
    }

    @org.junit.jupiter.api.Test
    void setNickName() {
        this.player.setNickName("NewName");
        assertNotEquals(this.name, this.player.getNickName());
        assertEquals("NewName", this.player.getNickName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals(0, this.player.getAge());
        this.player.setAge(this.playerAge);
        assertEquals(this.playerAge, this.player.getAge());
    }

    @org.junit.jupiter.api.Test
    void setAge() {
        this.player.setAge(this.playerAge);
        assertEquals(this.playerAge, this.player.getAge());
    }

    @org.junit.jupiter.api.Test
    void getRating() {
        assertNotEquals(this.rating, this.player.getRating());
        this.player.setRating(this.rating);
        assertEquals(this.rating, this.player.getRating());
    }

    @org.junit.jupiter.api.Test
    void setRating() {
        this.player.setRating(this.rating);
        assertEquals(this.rating, this.player.getRating());
    }

    @org.junit.jupiter.api.Test
    void getHeigh() {
        assertNotEquals(this.height, this.player.getHeigh());
        this.player.setHeigh(this.height);
        assertEquals(this.height, this.player.getHeigh());
    }

    @org.junit.jupiter.api.Test
    void setHeigh() {
        this.player.setHeigh(this.height);
        assertEquals(this.height, this.player.getHeigh());
    }

    @org.junit.jupiter.api.Test
    void getSex() {
        assertNotEquals(this.sex, this.player.getSex());
    }

    @org.junit.jupiter.api.Test
    void setSex() {
        this.player.setSex("male");
        assertEquals(this.sex, this.player.getSex());
    }

    @org.junit.jupiter.api.Test
    void getDOB() {
        this.player.setDOB(new Date());
        assertEquals(new Date(), this.player.getDOB());
    }

    @org.junit.jupiter.api.Test
    void setDOB() {
        this.player.setDOB(new Date());
        assertEquals(new Date(), this.player.getDOB());
    }

    @org.junit.jupiter.api.Test
    void getPreviousTeam() {
        assertNotEquals(this.previousTeam, this.player.getPreviousTeams());
    }

    @org.junit.jupiter.api.Test
    void setPreviousTeams() {
        this.player.setPreviousTeams(this.currentTeam);
        assertEquals(this.currentTeam, this.player.getPreviousTeams().getFirst());
        assertEquals(1, this.player.getPreviousTeams().size());
        this.player.setPreviousTeams(this.previousTeam);
        assertEquals(this.previousTeam, this.player.getPreviousTeams().getFirst());
        assertEquals(this.currentTeam, this.player.getPreviousTeams().getLast());
        assertEquals(2, this.player.getPreviousTeams().size());
    }

    @org.junit.jupiter.api.Test
    void getCurrentTeam() {
        assertEquals(null, this.player.getCurrentTeam());
        this.player.setCurrentTeam(this.currentTeam);
        assertEquals(this.currentTeam, this.player.getCurrentTeam());
    }

    @org.junit.jupiter.api.Test
    void setCurrentTeams() {
        this.player.setCurrentTeam(this.currentTeam);
        assertEquals(this.currentTeam, this.player.getCurrentTeam());
    }

    @org.junit.jupiter.api.Test
    void getSocialScore() {
        this.player.setSocialScore(this.socialScore);
        assertEquals(this.socialScore, this.player.getSocialScore());
    }

    @org.junit.jupiter.api.Test
    void setSocialScore() {
        this.player.setSocialScore(this.socialScore);
        assertEquals(this.socialScore, this.player.getSocialScore());
    }

    @org.junit.jupiter.api.Test
    void getPlayerNumber() {
        assertEquals(this.playerNumber, this.player.getMemberNumber());
    }

    @org.junit.jupiter.api.Test
    void setPlayerNumber() {
        this.player.setMemberNumber(10);
        assertEquals(10, this.player.getMemberNumber());
    }

    @Test
    void getDominentFoot() {
    }

    @Test
    void setDominentFoot() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void setPosition() {
    }
}