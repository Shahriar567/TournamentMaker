package src;

import java.util.Date;

/**
 * Abstract class for creating games. General purpose class to model a game.
 *
 * @author Shahriar Rahman
 * @version 1.0
 */
public abstract class Game {

    private String venue;       // venue of the game played
    private Date date;          // Date of the game played
    private String name;        // Name of the game
    private Team hostTeam;      // Home team
    private Team opponentTeam;  // Away team
    private String refferee;    // List of refferees

    /**
     * Abstract Class for creating a Game between two teams.
     *
     * @param name         String  Name of the game Played
     * @param hostTeam     team    Home team
     * @param opponentTeam team    Away team
     */
    public Game(String name, Team hostTeam, Team opponentTeam) {
        this.name = name;
        this.hostTeam = hostTeam;
        this.opponentTeam = opponentTeam;
    }

    /**
     * Setting the venue of the game.
     *
     * @param venue     String      Location of the game played
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * Change the name of the game.
     *
     * @param name      String      New name of the game
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Change the Host team for the game.
     *
     * @param hostTeam      team        new host team
     */
    public void setHostTeam(Team hostTeam) {
        this.hostTeam = hostTeam;
    }

    /**
     * Change the Away team for the game.
     *
     * @param opponentTeam      team        new away team
     */
    public void setOpponentTeam(Team opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    /**
     * Add Refferee for the game.
     *
     * @param refferee      String      refferree name
     */
    public void setRefferee(String refferee) {
        this.refferee = refferee;
    }

    /**
     * Returns the venue where the game was played.
     *
     * @return      String       game venue
     */
    public String getVenue() {
        return this.venue;
    }

    /**
     * Return the date when the game was played.
     *
     * @return      Date        return the date of the the game
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Return the name of the game.
     *
     * @return      String      name of the game
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the home team that is playing the game.
     *
     * @return      team        return host team
     */
    public Team getHostTeam() {
        return this.hostTeam;
    }

    /**
     * Return the away team that is playing the game.
     *
     * @return      team        return away team
     */
    public Team getOpponentTeam() {
        return this.opponentTeam;
    }

    /**
     * Return the refferre auditing the game.
     *
     * @return      String      refferree of the game
     */
    public String getRefferee() {
        return this.refferee;
    }
}