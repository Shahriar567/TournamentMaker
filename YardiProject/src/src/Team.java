package src;

import java.util.Date;

/**
 * Abstract class for any team. This is the backbone that every team in any league must follow.
 * This ensure consistency in the code base.
 *
 * @author Shahriar Rahman
 * @version 1.0
 */
abstract public class Team {

    private String name;            // Name of the team
    private String location;        // Home ground of the team
    private Date DOB;               // When was the team formed
    private String banner;          // Banner for the team
    private String defaultLeague;   // League the team plays
    private String stadiumName;     // Stadium name

    /**
     * Constructor for the abstract class team.
     *
     * @param name      String      Name of the team
     * @param location  String      Home ground of the team
     */
    public Team(String name, String location) {
        this.name = name;
        this.location = location;
    }

    /**
     * return the name of the team
     *
     * @return      String      name of the team
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the team
     *
     * @param name      String  name change of the team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Add the location of the team.
     *
     * @return      String      Location of the team
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Set the location of the team
     *
     * @param location      String      location of the team
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the date of birth of the team
     *
     * @return      Date        return the date of birth of the team
     */
    public Date getDOB() {
        return this.DOB;
    }

    /**
     * Set the date of birth of the team.
     *
     * @param DOB       Date        Set the date of birth of the team
     */
    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    /**
     * Get the banner of the team
     *
     * @return      String      return the banner of the team
     */
    public String getBanner() {
        return this.banner;
    }

    /**
     * Set the banner of the team.
     *
     * @param banner        String      add banner to the team
     */
    public void setBanner(String banner) {
        this.banner = banner;
    }

    /**
     * Return the banner for the team
     *
     * @return      String      return the banner for the team
     */
    public String getDefaultLeague() {
        return this.defaultLeague;
    }

    /**
     * Add team to a league.
     *
     * @param defaultLeague     Add league to the team.
     */
    public void setDefaultLeague(String defaultLeague) {
        this.defaultLeague = defaultLeague;
    }

    /**
     * Return the home stadium of the team.
     *
     * @return      String      Return stadium name
     */
    public String getStadiumName() {
        return stadiumName;
    }

    /**
     * Set the stadium name for the team.
     *
     * @param stadiumName       String      Set stadium name
     */
    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

}
