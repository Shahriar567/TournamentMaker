package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import src.SoccerTeam;
import src.SoccerCoaches;
import src.SoccerPlayer;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SoccerCoachesTest {
    private SoccerCoaches coach;
    private SoccerTeam currentTeam;
    private SoccerTeam previousTeam;
    private String name = "Shahriar";
    private String nickName = "Nova";
    private int coachAge = 19;
    private int height = 16;
    private String sex = "male";
    private int rating = 89;
    private int coachNumber = 7;
    private int socialScore = 98;
    private String position = "Main coach";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.currentTeam = new SoccerTeam("Barcelona", "Spain");
        this.previousTeam = new SoccerTeam("Barcelona", "Spain");
        this.coach = new SoccerCoaches(name, nickName, coachNumber);
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals(this.name, this.coach.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        this.coach.setName("NewName");
        assertNotEquals(this.name, this.coach.getName());
        assertEquals("NewName", this.coach.getName());
    }

    @org.junit.jupiter.api.Test
    void getNickName() {
        assertEquals(this.nickName, this.coach.getNickName());
    }

    @org.junit.jupiter.api.Test
    void setNickName() {
        this.coach.setNickName("NewName");
        assertNotEquals(this.name, this.coach.getNickName());
        assertEquals("NewName", this.coach.getNickName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals(0, this.coach.getAge());
        this.coach.setAge(this.coachAge);
        assertEquals(this.coachAge, this.coach.getAge());
    }

    @org.junit.jupiter.api.Test
    void setAge() {
        this.coach.setAge(this.coachAge);
        assertEquals(this.coachAge, this.coach.getAge());
    }

    @org.junit.jupiter.api.Test
    void getRating() {
        assertNotEquals(this.rating, this.coach.getRating());
        this.coach.setRating(this.rating);
        assertEquals(this.rating, this.coach.getRating());
    }

    @org.junit.jupiter.api.Test
    void setRating() {
        this.coach.setRating(this.rating);
        assertEquals(this.rating, this.coach.getRating());
    }

    @org.junit.jupiter.api.Test
    void getHeigh() {
        assertNotEquals(this.height, this.coach.getHeigh());
        this.coach.setHeigh(this.height);
        assertEquals(this.height, this.coach.getHeigh());
    }

    @org.junit.jupiter.api.Test
    void setHeigh() {
        this.coach.setHeigh(this.height);
        assertEquals(this.height, this.coach.getHeigh());
    }

    @org.junit.jupiter.api.Test
    void getSex() {
        assertNotEquals(this.sex, this.coach.getSex());
    }

    @org.junit.jupiter.api.Test
    void setSex() {
        this.coach.setSex("male");
        assertEquals(this.sex, this.coach.getSex());
    }

    @org.junit.jupiter.api.Test
    void getDOB() {
        this.coach.setDOB(new Date());
        assertEquals(new Date(), this.coach.getDOB());
    }

    @org.junit.jupiter.api.Test
    void setDOB() {
        this.coach.setDOB(new Date());
        assertEquals(new Date(), this.coach.getDOB());
    }

    @org.junit.jupiter.api.Test
    void getPreviousTeam() {
        assertNotEquals(this.previousTeam, this.coach.getPreviousTeams());
    }

    @org.junit.jupiter.api.Test
    void setPreviousTeams() {
        this.coach.setPreviousTeams(this.currentTeam);
        assertEquals(this.currentTeam, this.coach.getPreviousTeams().getFirst());
        assertEquals(1, this.coach.getPreviousTeams().size());
        this.coach.setPreviousTeams(this.previousTeam);
        assertEquals(this.previousTeam, this.coach.getPreviousTeams().getFirst());
        assertEquals(this.currentTeam, this.coach.getPreviousTeams().getLast());
        assertEquals(2, this.coach.getPreviousTeams().size());
    }

    @org.junit.jupiter.api.Test
    void getCurrentTeam() {
        assertEquals(null, this.coach.getCurrentTeam());
        this.coach.setCurrentTeam(this.currentTeam);
        assertEquals(this.currentTeam, this.coach.getCurrentTeam());
    }

    @org.junit.jupiter.api.Test
    void setCurrentTeams() {
        this.coach.setCurrentTeam(this.currentTeam);
        assertEquals(this.currentTeam, this.coach.getCurrentTeam());
    }

    @org.junit.jupiter.api.Test
    void getSocialScore() {
        this.coach.setSocialScore(this.socialScore);
        assertEquals(this.socialScore, this.coach.getSocialScore());
    }

    @org.junit.jupiter.api.Test
    void setSocialScore() {
        this.coach.setSocialScore(this.socialScore);
        assertEquals(this.socialScore, this.coach.getSocialScore());
    }

    @org.junit.jupiter.api.Test
    void getMemberNumber() {
        assertEquals(this.coachNumber, this.coach.getMemberNumber());
    }

    @org.junit.jupiter.api.Test
    void setMemberNumber() {
        this.coach.setMemberNumber(10);
        assertEquals(10, this.coach.getMemberNumber());
    }

    @Test
    void getPosition() {
        this.coach.setPosition(this.position);
        assertEquals(this.position, this.coach.getPosition());
    }

    @Test
    void setPosition() {
        this.coach.setPosition(this.position);
        assertEquals(this.position, this.coach.getPosition());
    }

    @Test
    void getInDutyOff() {
        assertEquals(0, this.coach.getInDutyOff().size());
    }

    @Test
    void setInDutyOff() {
        SoccerPlayer player1 = new SoccerPlayer(name, nickName, 10);
        SoccerPlayer player2 = new SoccerPlayer(name, nickName, 11);
        SoccerPlayer playe3 = new SoccerPlayer(name, nickName, 12);

        this.coach.setInDutyOff(player1);
        assertEquals(1, this.coach.getInDutyOff().size());
        this.coach.setInDutyOff(player1);
        assertEquals(2, this.coach.getInDutyOff().size());
        this.coach.setInDutyOff(player1);
        assertEquals(3, this.coach.getInDutyOff().size());
    }

    @Test
    void clearenceLevel() {
        assertEquals("Coach Level", this.coach.clearanceLevel());
    }

    @Test
    void setDivision() {
        assertEquals(null, this.coach.getDivision());
        this.coach.setDivision("La Liga");
        assertEquals("La Liga", this.coach.getDivision());
    }

    @Test
    void getDivision() {
        assertEquals(null, this.coach.getDivision());
        this.coach.setDivision("La Liga");
        assertEquals("La Liga", this.coach.getDivision());
    }
}