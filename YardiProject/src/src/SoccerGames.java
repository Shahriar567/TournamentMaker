package src;
import src.Game;
import src.Main;
import src.SoccerTeam;
import src.Util.score;

/**
 * Class to create Soccer a soccer game. It extends from Games and gives us options to set a game according to our need
 * and liking. This class gives us details about a game in a tournament.
 *
 * @author Shahriar Rahman
 * @version 1.0
 */
public class SoccerGames extends Game {

    public int concededGoal;       // Total goals conceded in the game by the host
    public int goalsScored;        // Total goals scored in the game by the host
    private int gameId;            // Unique game id for the game.
    private score result;          // Enum for storing result;

    /**
     * Constructor for creating the Soccer Game class.
     *
     * @param name      String      Name of the soccer game
     * @param gameId    int         Unique game id for the game
     * @param hostTeam  team        Home soccer team playing the game
     * @param opponentTeam  team    Away soccer team playing the game
     * @param concededGoal  int     Total goals conceded by the home team
     * @param goalsScored   int     Total goals given by the home team
     * @param result        score   Final result of the game WIN/LOSE/DRAW
     */
    public SoccerGames(String name, int gameId, SoccerTeam hostTeam, SoccerTeam opponentTeam, int concededGoal, int goalsScored, score result) {
        super(name, hostTeam, opponentTeam);
        this.concededGoal = concededGoal;
        this.goalsScored = goalsScored;
        this.gameId = gameId;
        this.result = result;
    }

    /**
     * Get draw Points for the game.
     * If the Game is a Draw then the match point for both teams are 1.
     *
     * @return      int     1 if the match is a Draw, 0 otherwise.
     */
    public int GetDrawPoints() {
        if (this.goalsScored == concededGoal && this.result == score.DRAW) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Get loss Points for the game.
     * If the Game is a loss then the match point for the losing team is -3.
     *
     * @return      int     3 if the match is a loss, 0 otherwise.
     */
    public int GetLossPoints() {
        if (this.goalsScored < concededGoal && this.result == score.LOSS) {
            return 3;
        } else {
            return 0;
        }
    }

    /**
     * Get winning Points for the game.
     * If the Game is a victory then the match point for the winning team is 3.
     *
     * @return      int     3 if the match is a won, 0 otherwise.
     */
    public int GetWinPoints() {
        if (this.goalsScored > concededGoal) {
            return 3;
        } else {
            return 0;
        }
    }

    /**
     * Return the game id for the game.
     *
     * @return      int     return the game id for the game
     */
    public int getGameId() {
        return this.gameId;
    }

    /**
     * Turning the host game to away game.
     */
    public void turnOpponent() {
        int sav = this.goalsScored;
        this.goalsScored = this.concededGoal;
        this.concededGoal = sav;
    }

    @Override
    public String toString() {
        return "SoccerGames{" +
                "concededGoal=" + concededGoal +
                ", gameId=" + gameId +
                ", goalsScored=" + goalsScored +
                ", score=" + this.result +
                '}';
    }
}
