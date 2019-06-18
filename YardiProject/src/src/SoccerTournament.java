package src;

import src.exception.PlayerNotFoundException;
import src.exception.TeamNotFoundException;
import java.util.LinkedList;

/***
 * Class to create tournament. Class is responsible in creating tournaments, associating teams with tournaments,
 * report games, and updating scores for teams.
 *
 * @author Shahriar Rahman
 * @version 1
 */
public class SoccerTournament implements Tournament {

    private static final int numOfTeams = 11;                   // Number of teams allowed per tournament
    private String tournamentName;                              // Tournament name
    private LinkedList<SoccerTeam> teams = new LinkedList<SoccerTeam>(); // All registered teams in tournament
    private LinkedList<SoccerGames> games = new LinkedList<SoccerGames>();// All games played in tournament
    private String venue;                                       // Venue of the tournament played

    /**
     * Constructor for the Soccer tournament
     *
     * @param tournamentName        String      Name of the tournament
     */
    public SoccerTournament(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    /**
     * Return the teams registered in the tournament
     *
     * @return      LinkedList      List of all the tournaments
     */
    public LinkedList<SoccerTeam> getTeams() {
        return this.teams;
    }

    /**
     * Add teams to register in the tournament.
     * Throw exception if already registered.
     *
     * @param team      SoccerTeam      team to be registered
     * @throws TeamNotFoundException    Team already registered in the tournament
     */
    public void addTeams(SoccerTeam team) throws TeamNotFoundException {
        if (teams.contains(team)){
            throw new TeamNotFoundException("Team Already added to the Tournament");
        }
        this.teams.add(team);
    }

    /**
     * Return the list of games recorded in the tournament.
     *
     * @return      linkedList      Soccer game list
     */
    public LinkedList<SoccerGames> getGames() {
        return this.games;
    }

    /**
     * Record games for the tournament. Ckeck if the games are played with registered teams calculate the score.
     *
     * @param game      SoccerGame      game to be added to the records
     * @throws TeamNotFoundException    game registered with the teams not found
     */
    public void addGames(SoccerGames game) throws TeamNotFoundException {
        if (!teams.contains(game.getHostTeam())){
            throw new TeamNotFoundException("Host team not registered in the tournament");
        } else if (!teams.contains(game.getOpponentTeam())){
            throw new TeamNotFoundException("Opponent team not registered in the tournament");
        }
        int host = teams.indexOf(game.getHostTeam());
        teams.get(host).addGame(game);
        int opponent = teams.indexOf(game.getOpponentTeam());
        game.turnOpponent();
        teams.get(opponent).addGame(game);

        this.games.addFirst(game);
    }

    /**
     * Return the team registered in the tournament.
     *
     * @param teamName      String      Team quering for
     * @return      SoccerTeam      soccer team searched if found
     * @throws TeamNotFoundException
     */
    public SoccerTeam getTeam(String teamName) throws TeamNotFoundException {

        for (int i = 0; i < this.teams.size(); i++) {
            SoccerTeam team = this.teams.get(i);

            if (team.getName().equals(teamName)){
                return team;
            }
        }
        throw new TeamNotFoundException("Team that you are searching for is not found");
    }

    @Override
    public String tournamentName() {
        return this.tournamentName;
    }

    @Override
    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String getVenue() {
        return this.venue;
    }

    @Override
    public void resetTournament() {
        teams.clear();
        games.clear();
    }

    /**
     * Return stats of all the teams in play.
     *
     * @return      String      Stats of all teams
     */
    public String getStatsOfTeams(){

        String res = "";

        if (teams.size() <= 0){
            return "No team registered in tournament";
        }

        for(int num=0; num<teams.size(); num++)
        {
            SoccerTeam team = teams.get(num);
            res += team.toString() + "\n";
        }
        return res;
    }

    /**
     * Return stats of all the games in play.
     *
     * @return      String      Stats of all games
     */
    public String getStatsOfGames(){

        String res = "";

        if (games.size() <= 0){
            return "No game registered in tournament";
        }

        for(int num=0; num<games.size(); num++)
        {
            SoccerGames game = games.get(num);
            res += "Game Id:   " + game.getGameId() + "  "+ game.getHostTeam().getName() + ": " + game.goalsScored +
                     " VS " + game.getOpponentTeam().getName() + ": " + game.concededGoal;

        }
        return res;
    }

}
