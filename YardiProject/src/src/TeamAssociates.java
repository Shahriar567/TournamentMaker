package src;

import java.util.List;

/**
 * Public interface for Associates of a team.
 * Management, coaches, staff all have to implement this.
 *
 * @author Shahriar Rahman
 * @version 1
 */
public interface TeamAssociates {

    public String clearanceLevel();

    public void setDivision(String league);

    public String getDivision();
}
