package src;

import java.util.Date;
import java.util.LinkedList;import java.util.HashMap; // import the HashMap class

/**
 * Abstract class for team members registered to a team.
 *
 * @author Shahriar Rahman
 * @version 1.0
 */
abstract public class TeamMember implements TeamMembers{

    private String name;                // Team member name for registry
    private String nickName;            // Team member nick name
    private int age;                    // Team member age
    private int rating;                 // Team member rating
    private int heigh;                  // Team member height
    private String sex;                 // Team member sex >> MALE/FEMALE
    private Date DOB;                   // Team member date of birth
    private Team currentTeam;           // Current playing team of member
    private LinkedList<Team> previousTeams = new LinkedList<Team>();        // Previous teams of the team member
    private int socialScore;            // Team member social score
    private int TeamNumber;             // Team member team number

    /**
     * Returns the team members number. For identity.
     *
     * @return      Int     team member number
     */
    public int getMemberNumber() {
        return TeamNumber;
    }

    /**
     * Setting the team member number.
     *
     * @param playerNumber      int     team member number to set
     */
    public void setMemberNumber(int playerNumber) {
        this.TeamNumber = playerNumber;
    }

    /**
     * Get current team the team member players.
     *
     * @return      Team        Current team the member plays at
     */
    public Team getCurrentTeam() {
        return currentTeam;
    }

    /**
     * Set the team the member plays at.
     *
     * @param currentTeam       Team        Current team for member
     */
    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    /**
     * Return list of previous teams the member played at.
     *
     * @return      Linkedlist      all previous teams the player played at
     */
    public LinkedList<Team> getPreviousTeams() {
        return previousTeams;
    }

    /**
     * Add previous team the member played at.
     *
     * @param previousTeam      Team        previous team for a member
     */
    public void setPreviousTeams(Team previousTeam) {
        this.previousTeams.addFirst(previousTeam);
    }

    /**
     * Return name of the member.
     *
     * @return      String      name of the member
     */
    public String getName() {
        return name;
    }

    /**
     * set name of the member.
     *
     * @param name      String      set name of the member
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the nick name of the member.
     *
     * @return      String      nick name of the member
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Set nick name of the member.
     *
     * @param nickName      String      set the nick name of the member
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Return the age of the member.
     *
     * @return      String      Age of the member
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the age of the member.
     *
     * @param age       String      set age of member
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get rating of the member.
     *
     * @return      int      rating of the member
     */
    public int getRating() {
        return rating;
    }

    /**
     * Set the rating of the member.
     *
     * @param rating        int     rating of the member
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Return the height of the member.
     *
     * @return      int     height of the member
     */
    public int getHeigh() {
        return heigh;
    }

    /**
     * Set the height of the member.
     *
     * @param heigh     int height of the member
     */
    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    /**
     * Return the sex of the member.
     *
     * @return      String      sex of the member
     */
    public String getSex() {
        return sex;
    }

    /**
     * Set sex of the member.
     *
     * @param sex       String      MALE/FEMALE of the member
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Return Date of birth of the member.
     *
     * @return      Date       DOB of the member
     */
    public Date getDOB() {
        return DOB;
    }

    /**
     * Set the date of birth of the member.
     *
     * @param DOB       Date        Date of birth
     */
    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    /**
     * Return the social score given of the member.
     *
     * @return      int     social score
     */
    public int getSocialScore() {
        return socialScore;
    }

    /**
     * Set the social score of the member.
     *
     * @param socialScore       int         social score for the member
     */
    public void setSocialScore(int socialScore) {
        this.socialScore = socialScore;
    }

    /**
     * Constructor for the team member abstract class.
     *
     * @param name          String      Name of the member
     * @param nickName      String      Nick name of the member
     * @param TeamNumber    Integer     Team member number
     */
    public TeamMember(
            String name,
            String nickName,
            int TeamNumber){

        this.name = name;
        this.nickName = nickName;
        this.TeamNumber = TeamNumber;
    }
}
