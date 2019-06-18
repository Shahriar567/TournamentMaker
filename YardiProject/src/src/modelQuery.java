package src;

import src.Util.score;
import src.exception.*;

import java.util.LinkedList;
import java.util.Scanner;

/***
 * Public class for controlling the view.
 *
 * @author Shahriar Rahman
 * @version 1.0
 */
public class modelQuery {

    private SoccerTournament tournament;            // Initiating tournament instance for viewing.
    private Scanner inst = new Scanner(System.in);          // Scanner for inputs from CLI.

    /**
     * Return tournament name
     *
     * @return      String      get tournament name
     */
    public String action_get_tournament_name(){
        return this.tournament.tournamentName();
    }

    /**
     * Create tournament.
     *
     * @return      String      Successful/Unsuccessful tournament creation
     */
    public String action_create_tournament(){
        System.out.println("Enter tournament name");
        String tournamentName = this.inst.nextLine();
        this.tournament = new SoccerTournament(tournamentName);
        return "Successful in creating Tournament: " + tournamentName;
    }

    /**
     * Create team and add it to the tournament object.
     *
     * @return      String      Successful/Unsuccessful team registry
     */
    public String action_create_team() {

        System.out.println("Enter team name : ");
        String teamName = inst.nextLine();
        System.out.println("Enter team Location : ");
        String teamlocation = inst.nextLine();
        System.out.println("Add team to tournament ? >> y/n");
        String teamAddIntournament = inst.nextLine();

        SoccerTeam team = new SoccerTeam(teamName, teamlocation);

        if (teamAddIntournament.equals("y")){
            try {
                this.tournament.addTeams(team);
            } catch (TeamNotFoundException e) {
                return "Team is not found.";
            }
        }
        return "Successful in creating team: " + teamName;
    }

    /**
     * Display all teams associated with the tournament.
     *
     * @return      String      Successful/Unsuccessful team display
     */
    public String action_display_all_teams(){
        LinkedList<SoccerTeam> teams = this.tournament.getTeams();
        StringBuilder result = new StringBuilder();

        for(int num=0; num<teams.size(); num++)
        {
            result.append(teams.get(num).getName()).append(" -  ");
        }

        return "Teams currently registered in tournament:   " + result;
    }

    /**
     * Display players associated with the team playing in the tournament.
     *
     * @param teamSelected      String      Team that is selected by user
     * @return      String      Successful/Unsuccessful display of all the players in the team
     */
    public String action_display_all_players_in_team(String teamSelected){

        LinkedList<SoccerPlayer> players;
        try {
            players = this.tournament.getTeam(teamSelected).getAllPlayers();
        } catch (TeamNotFoundException e) {
            return "Team not registered";
        }
        StringBuilder result = new StringBuilder();

        for (SoccerPlayer player : players) {
            result.append(player.getName()).append("  - ");
        }

        return "Players currently in team:   " + result;
    }

    /**
     * Display coaches associated with the team playing in the tournament.
     *
     * @param teamSelected      String      Team that is selected by user
     * @return      String      Successful/Unsuccessful display of all the coaches in the team
     */
    public String action_display_all_coaches_in_team(String teamSelected){

        LinkedList<SoccerCoaches> coaches;
        try {
            coaches = this.tournament.getTeam(teamSelected).getAllCoaches();
        } catch (TeamNotFoundException e) {
            return "Team not registered";
        }
        StringBuilder result = new StringBuilder();

        for (SoccerCoaches coach : coaches) {
            result.append(coach.getName()).append("   - ");
        }

        return "Coaches currently in team:   " + result;
    }

    /**
     * Add a record of a game in the tournament.
     *
     * @return      String      Successful/Unsuccessful addition to the record
     */
    public String action_add_game_in_tournament(){

        System.out.println("Reporting a game --------- \r\n " + "Please enter game name: ");
        String gameName = inst.nextLine();
        System.out.println("Enter game Id : ");
        int gameId = inst.nextInt();
        System.out.println("All teams registered in tournament: ");

        String all_teams = this.action_display_all_teams();
        System.out.println(all_teams);
        inst.nextLine();
        System.out.println("Enter Host team : ");
        String host = inst.nextLine();

        System.out.println("Enter Opponent team : ");
        String opponent = inst.nextLine();
        System.out.println("Enter goals conceded  : ");
        int concededGoal = inst.nextInt();
        System.out.println("Enter goals scored : ");
        int goalsScore = inst.nextInt();

        score result;
        SoccerTeam hostTeam = this.helper_get_team_from_team_name(host);
        SoccerTeam opponentTeam = this.helper_get_team_from_team_name(opponent);

        if (concededGoal > goalsScore){
            result = score.LOSS;
        } else if (concededGoal == goalsScore ){
            result = score.DRAW;
        } else{
            result = score.WIN;
        }
        SoccerGames game = new SoccerGames(gameName, gameId, hostTeam, opponentTeam, concededGoal, goalsScore, result);

        try {
            this.tournament.addGames(game);
        } catch (TeamNotFoundException e) {
            return "Game not added, teams selected are not found. ";
        }

        return "Game added in registry";
    }

    /**
     * Helper funcion to get the Soccerteam object from the teams registered in the tournament.
     *
     * @param team      String      team requested by the user
     * @return      String      Successful/Unsuccessful return of the Soccer team
     */
    public SoccerTeam helper_get_team_from_team_name(String team){

        SoccerTeam hostTeam = null;

        try {
            hostTeam = this.tournament.getTeam(team);
        } catch (TeamNotFoundException e) {
            e.printStackTrace();
        }
        return hostTeam;
    }

    /**
     * Create player for a team registered in the tournament.
     *
     * @return      String      Successful/Unsuccessful in creating player for the team in the tournament
     */
    public String action_create_player() {

        System.out.println("Create player:  \r\n" + "Please enter player name: ");
        String playerName = inst.nextLine();
        System.out.println("Player nick name");
        String playerNickName = inst.nextLine();
        System.out.println("Player jersey number");
        int playerNumber = inst.nextInt();
        System.out.println("Enter team for player");
        inst.nextLine();
        String team = inst.nextLine();

        SoccerPlayer player = new SoccerPlayer(playerName, playerNickName, playerNumber);

        try {
            this.tournament.getTeam(team).addPlayers(player);
        } catch (TeamNotFoundException e) {
            return "Team not found in the tournament";
        } catch (PlayerLimitExcededException e) {
            return "Player limit exceeded for the team";
        } catch (PlayerWithSameNameAlreadyAddedException e) {
            return "Player already registered in the team";
        }

        return "Player registered for the team " + team;
    }

    /**
     * Create coach for a team registered in the tournament.
     *
     * @return      String      Successful/Unsuccessful in creating coach for the team in the tournament
     */
    public String action_create_coach() {

        System.out.println("Create coach:  \r\n" + "Please enter Coach name: ");
        String coachName = inst.nextLine();
        System.out.println("Coach nick name");
        String coachNickName = inst.nextLine();
        System.out.println("Coach jersey number");
        int coachNumber = inst.nextInt();
        System.out.println("Enter team for Coach");
        inst.nextLine();
        String team = inst.nextLine();

        SoccerCoaches coach = new SoccerCoaches(coachName, coachNickName, coachNumber);

        try {
            this.tournament.getTeam(team).addCoach(coach);
        } catch (TeamNotFoundException e) {
            return "Team not found in the tournament";
        } catch (CoachLimitExcededException e) {
            return "Coach limit for the team exceded";
        } catch (PlayerWithSameNameAlreadyAddedException e) {
            return "Coach already registered with the team";
        }

        return "Coach registered for the team " + team;
    }

    /**
     * Show status of a team.
     *
     * @return      String      status of a team
     */
    public String action_show_team_stats(){
        return this.tournament.getStatsOfTeams();
    }

    /**
     * Show status of a game.
     *
     * @return      String      status of a game
     */
    public String action_show_game_stats(){
        return this.tournament.getStatsOfGames();
    }

    /**
     * Change team name.
     */
    public String action_change_team_name(String teamSelected) {
        System.out.println("New name for the team: ");
        String newName = inst.nextLine();

        try {
            this.tournament.getTeam(teamSelected).setName(newName);
        } catch (TeamNotFoundException e) {
            return "Team is not registered";
        }
        return "Team name changed too: " + newName;
    }

    /**
     * Change team location.
     */
    public String action_change_team_location(String teamSelected) {
        System.out.println("New location for the team ?");
        String location = inst.nextLine();

        try {
            this.tournament.getTeam(teamSelected).setLocation(location);
        } catch (TeamNotFoundException e) {
            return "Team is not registered";
        }
        return "Team location changed too: " + location;
    }

    /**
     * Change team banner.
     */
    public String action_add_banner_of_the_team(String teamSelected) {
        System.out.println("New banner of the team ?");
        String banner = inst.nextLine();

        try {
            this.tournament.getTeam(teamSelected).setBanner(banner);
        } catch (TeamNotFoundException e) {
            return "Team is not registered";
        }
        return "Team Banner changed too: " + banner;
    }

    /**
     * Add default league for a team.
     */
    public String action_add_default_league_of_the_team(String teamSelected) {
        System.out.println("New default league of the team ?");
        String banner = inst.nextLine();

        try {
            this.tournament.getTeam(teamSelected).setDefaultLeague(banner);
        } catch (TeamNotFoundException e) {
            return "Team is not registered";
        }
        return "Team banner changed too: " + banner;
    }

    /**
     * Add stadium for a team.
     */
    public String action_set_stadium_of_the_team(String teamSelected) {
        System.out.println("New stadium of the team ?");
        String stadium = inst.nextLine();

        try {
            this.tournament.getTeam(teamSelected).setStadiumName(stadium);
        } catch (TeamNotFoundException e) {
            return "Team is not registered";
        }
        return "Team stadium changed too: " + stadium;
    }

    /**
     * Ad venue for the tournament.
     */
    public String action_set_venue_of_tournament() {
        System.out.println("Set venue fot he tournament: ");
        String venue = inst.nextLine();

        this.tournament.setVenue(venue);
        return "Venue of the tournament: " + venue;
    }

    /**
     * Reset tournament.
     */
    public String action_reset_tournament() {
        System.out.println("Reset tournament ? >> yes/no");
        String stadium = inst.nextLine();

        if (stadium.equals("yes")) {
            this.tournament.resetTournament();
            return "Tournament has been reset";
        } else {
            return "Please play to win";
        }
    }

    /**
     * Change position of the coach.
     *
     * @param playerName       String      Coach name to be changed
     * @param team      String      Team the coach is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_change_position_of_coach(String playerName, String team) {

        System.out.println("Coach position: ");
        String positon = inst.nextLine();
        try {
            this.tournament.getTeam(team).getCoach(playerName).setPosition(positon);
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        } catch (CoachNotFoundException e) {
            return "Coach is not registered";
        }

        return "Coach position: " + positon;
    }

    /**
     * Change name of the coach.
     *
     * @param playerName       String      Coach name to be changed
     * @param team      String      Team the coach is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_change_coach_name(String playerName, String team) {

        System.out.println("Change coach name");
        String player = inst.nextLine();

        try {
            this.tournament.getTeam(team).getCoach(playerName).setName(player);
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        } catch (CoachNotFoundException e) {
            return "Coach is not registered";
        }

        return "Coach name changed too: " + player;
    }

    /**
     * Add nick name for the coach.
     *
     * @param playerName       String      Coach name to be changed
     * @param team      String      Team the coach is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_change_coach_nick_name(String playerName, String team) {

        System.out.println("Change coach nick name");
        String nick_name = inst.nextLine();

        try {
            this.tournament.getTeam(team).getCoach(playerName).setNickName(nick_name);
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        } catch (CoachNotFoundException e) {
            return "Coach is not registered";
        }

        return "Coach nick name changed too: " + nick_name;
    }

    /**
     * Change rating of the coach.
     *
     * @param playerName       String      Coach name to be changed
     * @param team      String      Team the coach is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_coach_rating(String playerName, String team) {

        System.out.println("Change coach rating");
        int rating = inst.nextInt();

        try {
            this.tournament.getTeam(team).getCoach(playerName).setRating(rating);
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        } catch (CoachNotFoundException e) {
            return "Coach is not registered";
        }

        return "Player coach changed too: " + rating;
    }

    /**
     * Change coach height.
     *
     * @param playerName       String      Coach name to be changed
     * @param team      String      Team the coach is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_add_coach_height(String playerName, String team) {

        System.out.println("Coach height");
        int height = inst.nextInt();

        try {
            this.tournament.getTeam(team).getCoach(playerName).setHeigh(height);
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        } catch (CoachNotFoundException e) {
            return "Coach is not registered";
        }

        return "Coach height changed too: " + height;
    }

    /**
     * Change coach sex.
     *
     * @param playerName       String      Coach name to be changed
     * @param team      String      Team the coach is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_add_coach_sex(String playerName, String team) {

        System.out.println("Coach sex");
        String sex = inst.nextLine();

        try {
            this.tournament.getTeam(team).getCoach(playerName).setSex(sex);
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        } catch (CoachNotFoundException e) {
            return "Coach is not registered";
        }

        return "Coach sex changed too: " + sex;
    }

    /**
     * Change dominant position for a player registered to a team.
     *
     * @param playerName       String      Player name to be changed
     * @param team      String      Team the player is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_change_player_dominant_foot(String playerName, String team) {

        System.out.println("Players dominant foot: LEFT/RIGHT");
        String dominant = inst.nextLine();
        try {
            this.tournament.getTeam(team).getPlayer(playerName).setDominentFoot(dominant);
        } catch (PlayerNotFoundException e) {
            return "Player is not registered";
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        }

        return "Player Dominant foot changed to: " + dominant;
    }

    /**
     * Change position for a player registered to a team.
     *
     * @param playerName       String      Player name to be changed
     * @param team      String      Team the player is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_change_position_of_player(String playerName, String team) {

        System.out.println("Players position: LEFT/RIGHT");
        String position = inst.nextLine();
        try {
            this.tournament.getTeam(team).getPlayer(playerName).setPosition(position);
        } catch (PlayerNotFoundException e) {
            return "Player is not registered";
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        }

        return "Player Dominant foot changed to: " + position;
    }

    /**
     * Change name of a  player registered to a team.
     *
     * @param playerName       String      Player name to be changed
     * @param team      String      Team the player is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_change_player_name(String playerName, String team) {

        System.out.println("Change players name");
        String player = inst.nextLine();

        try {
            this.tournament.getTeam(team).getPlayer(playerName).setName(player);
        } catch (PlayerNotFoundException e) {
            return "Player is not registered";
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        }

        return "Player name changed too: " + player;
    }

    /**
     * Change nick name for a player registered to a team.
     *
     * @param playerName       String      Player name to be changed
     * @param team      String      Team the player is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_change_player_nick_name(String playerName, String team) {

        System.out.println("Change players name");
        String nick_name = inst.nextLine();

        try {
            this.tournament.getTeam(team).getPlayer(playerName).setNickName(nick_name);
        } catch (PlayerNotFoundException e) {
            return "Player is not registered";
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        }

        return "Player nick name changed too: " + nick_name;
    }

    /**
     * Change player rating registered to a team.
     *
     * @param playerName       String      Player name to be changed
     * @param team      String      Team the player is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_player_rating(String playerName, String team) {

        System.out.println("Change player rating");
        int rating = inst.nextInt();

        try {
            this.tournament.getTeam(team).getPlayer(playerName).setRating(rating);
        } catch (PlayerNotFoundException e) {
            return "Player is not registered";
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        }

        return "Player rating changed too: " + rating;
    }

    /**
     * Change player height registered to a team.
     *
     * @param playerName       String      Player name to be changed
     * @param team      String      Team the player is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_add_player_height(String playerName, String team) {

        System.out.println("Player height");
        int height = inst.nextInt();

        try {
            this.tournament.getTeam(team).getPlayer(playerName).setHeigh(height);
        } catch (PlayerNotFoundException e) {
            return "Player is not registered";
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        }

        return "Player height changed too: " + height;
    }

    /**
     * Change player sex registered to a team.
     *
     * @param playerName       String      Player name to be changed
     * @param team      String      Team the player is registered too
     * @return      String      Successful/Unsuccessful change return
     */
    public String action_add_player_sex(String playerName, String team) {

        System.out.println("Player height");
        String sex = inst.nextLine();

        try {
            this.tournament.getTeam(team).getPlayer(playerName).setSex(sex);
        } catch (PlayerNotFoundException e) {
            return "Player is not registered";
        } catch (TeamNotFoundException e) {
            return "team is not registered";
        }

        return "Player sex changed too: " + sex;
    }
}
