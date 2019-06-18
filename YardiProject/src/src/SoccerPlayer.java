package src;

import src.TeamMember;

import java.util.Date;

/**
 * Class to create soccer player.
 *
 * @author Shahriar Rahman
 * @version 1
 */
public class SoccerPlayer extends TeamMember {

    private String dominantFoot;    // Dominent foot of the player
    private String position;        // Position the player plays

    /**
     * Return the dominant foot the player plays with
     *
     * @return  String Dominent foot of the player
     */
    public String getDominentFoot() {
        return dominantFoot;
    }

    /**
     * Set the dominant foor of the player.
     *
     * @param dominantFoot      String      Dominent foot of the player
     */
    public void setDominentFoot(String dominantFoot) {
        this.dominantFoot = dominantFoot;
    }

    /**
     * Return the position the player plays at
     *
     * @return  String Positon of the player
     */
    public String getPosition() {
        return position;
    }

    /**
     * Set the position of the player.
     *
     * @param position      String      position of the player
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Constructor for making a Soccer Player.
     *
     * @param name          Name of the soccer player
     * @param nickName      Nick name of the soccer player
     * @param playerNumber  Player number
     */
    public SoccerPlayer(String name, String nickName, int playerNumber) {
        super(name, nickName, playerNumber);
    }
}
