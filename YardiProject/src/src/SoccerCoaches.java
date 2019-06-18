package src;

import java.util.ArrayList;

/**
 * Class to create Soccer Coaches object. it extends teamMember as it has to have all the information that a
 * team member needs, and because of his superiority he has to implement Associates to record his position in the
 * team
 *
 * @author Shahriar Rahman
 * @version 1
 */
public class SoccerCoaches extends TeamMember implements TeamAssociates {

    private static final String clearanceLevel = "Coach Level";     // All coaches have a clearance level
    private String position;                                        // Position responsible to the coach
    private ArrayList<SoccerPlayer> inDutyOff = new ArrayList<SoccerPlayer>(); // List of all the players coach coaches
    private String division;                                        // Divisin coach playes in

    /**
     * Constructor method for Soccer Coach.
     *
     * @param name          String      Coach name
     * @param nickName      String      Coach nick name
     * @param coachNumber   int         Coach number
     */
    public SoccerCoaches(String name, String nickName, int coachNumber) {
        super(name, nickName, coachNumber);
    }

    /**
     * Return the position of the coach
     *
     * @return  String  Position of the coach
     */
    public String getPosition() {
        return position;
    }

    /**
     * Set the position of the coach.
     *
     * @param position  String  The position where coach coaches
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Return the array list of the players the coach is in duty off.
     *
     * @return  array   soccer player the coach is in duty off
     */
    public ArrayList<SoccerPlayer> getInDutyOff() {
        return this.inDutyOff;
    }

    /**
     * Add Player to the duty list of the coach/
     *
     * @param inDutyOff     SoccerPlayer    players that need to be added under the coach
     */
    public void setInDutyOff(SoccerPlayer inDutyOff) {
        this.inDutyOff.add(inDutyOff);
    }

    @Override
    public String clearanceLevel() {
        return clearanceLevel;
    }

    @Override
    public void setDivision(String league) {
        this.division = league;
    }

    @Override
    public String getDivision() {
        return this.division;
    }
}
