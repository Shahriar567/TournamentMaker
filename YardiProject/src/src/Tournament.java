package src;

/**
 * Interface for tournament registry. This is the backbone of any tournament creation. It will make sure that the
 * essintial values are set for tournament creation.
 *
 * @author Shahriar Rahman
 * @version 1.0
 */
public interface Tournament {

    /**
     * Return tournament name.
     *
     * @return      String      tournament name
     */
    String tournamentName();

    /**
     * Set venue of the tournament.
     *
     * @param venue     String      venue to be set
     */
    void setVenue(String venue);

    /**
     * Return the venue for the tournament.
     *
     * @return      String      venue of the tournament
     */
    String getVenue();

    /**
     * Reset tournament.
     */
    void resetTournament();
}
