package src;

import src.exception.*;

import java.util.HashMap;
import java.util.LinkedList;

/***
 * Class to create a Soccer team. This class is responsible to create a soccer team, add Players to the team, \
 * add Coaches to the team and record games for the team.
 * This class will have the list of all games played including match points acquired.
 *
 * @author Shahriar Rahman
 * @version 1.0
 */
public class SoccerTeam extends Team {

    public static final int maxPlayers = 11;        // Maximum player per team allowed
    public static final int maxCoaches = 4;         // Maximum coach per team allowed

    private int totalMatchesPlayed = 0;             // Total matches the team played
    private int totalMatchesWon = 0;                // Total won matches
    private int totalMatchesDraw = 0;               // Total matches Draw
    private int totalMatchesLoss = 0;               // Total matches Loss
    HashMap<Integer, SoccerGames> games = new HashMap<>();      // HashMap for all the games played
    LinkedList<SoccerPlayer> soccerPlayers = new LinkedList<>();        // list of players playing in the team
    LinkedList<SoccerCoaches> soccerCoaches = new LinkedList<>();                  // list of coaches Coaching in the team

    /**
     * Constructor for the soccer team. Initially only few components are needed to make a soccer team.
     * Rest can be added by setter functions.
     *
     * @param name      String      Soccer team name
     * @param location  String      Team home location
     */
    public SoccerTeam(String name, String location) {
        super(name, location);
    }

    /**
     * Add player to a team. Throw error if the player is already added.
     *
     * @param player        SoccerPlayer    player to be added
     * @throws PlayerLimitExcededException              If the player limit exceeds the maximum allowed
     * @throws PlayerWithSameNameAlreadyAddedException  If there is a player with the same name added.
     */
    public void addPlayers(SoccerPlayer player) throws PlayerLimitExcededException, PlayerWithSameNameAlreadyAddedException {
        if (this.soccerPlayers.size() >= maxPlayers){
            throw new PlayerLimitExcededException("Player limit for this team is reached");
        }

        try {
            this.getPlayer(player.getName());
            throw new PlayerWithSameNameAlreadyAddedException("Player with the same name already exists");
        } catch (PlayerNotFoundException e) {
            this.soccerPlayers.addLast(player);
        }
    }

    /**
     * Get all coaches for the team
     *
     * @return      LinkedList of all the players in the team
     */
    public LinkedList<SoccerPlayer> getAllPlayers() {
        return this.soccerPlayers;
    }

    /**
     * Get all player for the team
     *
     * @return      LinkedList of all the coaches in the team
     */
    public LinkedList<SoccerCoaches> getAllCoaches() {
        return this.soccerCoaches;
    }

    /**
     * Returns if a player is registered in the team or not.
     *
     * @param name      String      name of the player
     * @return      SoccerPlayer object if player found, throws error if not.
     * @throws PlayerNotFoundException  Player not found in the team error
     */
    public SoccerPlayer getPlayer(String name) throws PlayerNotFoundException {

        for (int i = 0; i < this.soccerPlayers.size(); i++) {
            SoccerPlayer player = this.soccerPlayers.get(i);

            if (player.getName().equals(name)){
                return player;
            }
        }
        throw new PlayerNotFoundException("Player that you are searching for is not found");
    }

    /**
     * Add coach to the team. Throw error if a coach with the same name tries to register.
     *
     * @param coach        SoccerCoach      Coach to be added
     * @throws CoachLimitExcededException               if the coach number exceeds the maximum allowed
     * @throws PlayerWithSameNameAlreadyAddedException  Coach with the same name is in the team
     */
    public void addCoach(SoccerCoaches coach) throws CoachLimitExcededException, PlayerWithSameNameAlreadyAddedException {
        if (soccerCoaches.size() >= maxCoaches){
            throw new CoachLimitExcededException("Coach limit for this team is reached");
        }

        try {
            this.getCoach(coach.getName());
            throw new PlayerWithSameNameAlreadyAddedException("Coach with the same name already exists");
        } catch (CoachNotFoundException e) {
            soccerCoaches.addLast(coach);
        }
    }

    /**
     * Search for coach in the team. If found return, else throw error.
     *
     * @param name      String      Name of the coach searched
     * @return      SoccerCoach/null
     * @throws CoachNotFoundException   coach with the name given is not registered in the team
     */
    public SoccerCoaches getCoach(String name) throws CoachNotFoundException {

        for (int i = 0; i < soccerCoaches.size(); i++) {
            SoccerCoaches coach = soccerCoaches.get(i);
            if (coach.getName().equals(name)){
                return coach;
            }
        }
        throw new CoachNotFoundException("Coach that you are searching for is not found ");
    }

    /**
     * Add finished game to the team
     * @param game  SoccerGame games to be added
     */
    public void addGame(SoccerGames game) {
        games.put(game.getGameId(), game);
        this.totalMatchesPlayed += 1;
        this.totalMatchesDraw += game.GetDrawPoints();
        this.totalMatchesLoss += game.GetLossPoints();
        this.totalMatchesWon += game.GetWinPoints();
    }

    /**
     * Returns a hashmap of all the games played by the team.
     *
     * @return      Hashmap     All games played by this team.
     */
    public HashMap<Integer, SoccerGames> getAllGames() {
        return this.games;
    }

    /**
     * Return a game using the gameId as parameter.
     *
     * @param gameId    int     Game id to look for a specific game
     * @return      SoccerGame  return Game if found
     */
    public SoccerGames getGame(int gameId) {
        return this.games.get(gameId);
    }

    public String toString(){
        String result = "";
        result += "Team name: " + this.getName() + "\r\n";
        result += "     matches played: " + this.totalMatchesPlayed + "\r\n";
        result += "     total points:   " + this.totalPoints() + "\r\n";

        return result;
    }

    /**
     * Total points of the team.
     * Loss = -3
     * Win = 3
     * Draw = 1
     * @return      int     Total points for the team in the tournament
     */
    private int totalPoints() {
        return (this.totalMatchesDraw + this.totalMatchesWon - this.totalMatchesLoss);
    }

    //    @Override
    //    public String toString() {
    //        return "SoccerTeam{" +
    //                "totalMatchesPlayed=" + totalMatchesPlayed +
    //                ", totalMatchesWon=" + totalMatchesWon +
    //                ", totalMatchesDraw=" + totalMatchesDraw +
    //                ", totalMatchesLoss=" + totalMatchesLoss +
    //                ", games=" + games +
    //                ", soccerPlayers=" + soccerPlayers +
    //                ", soccerCoaches=" + soccerCoaches +
    //                '}';
    //    }
}

