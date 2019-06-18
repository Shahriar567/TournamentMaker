package src;

/**
 * Interface for team members. All Members for a team must implement this as this is essiential information
 * to any membership form.
 *
 * @author Shahriar Rahman
 * @version 1.0
 */
public interface TeamMembers {

    /**
     * Returns the name of the team member.
     *
     * @return      String      team member name
     */
    String getName();

    /**
     * Returns the age of the team member.
     *
     * @return      String      age of the team member
     */
    int getAge();

    /**
     * Return the rating of the team member.
     *
     * @return      String      rating of the team member
     */
    int getRating();
}
