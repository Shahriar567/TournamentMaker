package src;

import java.util.Scanner;

import static java.lang.System.exit;

/***
 * Menu class. This is the CLI display of the software. Interactive application with ease of use.
 * This class makes use of query class.
 *
 * @author Shahriar Rahman
 * @version 1.0
 */
public class Menu {

    private modelQuery cust_query = new modelQuery();

    /***
     * Display initial menu. This is the menu where we make tournaments. Input games, teams, Players for a team,
     * Coaches for a team and can display relevant information.
     */
    public void displayFirstMenu(){

        System.out.println("Welcome to the Soccer Tournament Software: ");
        int optionn;
        do {
            optionn = showMenu();
            switch (optionn) {
                case 1:
                    System.out.println(this.cust_query.action_create_tournament());
                    break;
                case 2:
                    System.out.println(this.cust_query.action_create_team());
                    break;
                case 3:
                    System.out.println(this.cust_query.action_add_game_in_tournament());
                    break;
                case 4:
                    System.out.println(this.cust_query.action_create_player());
                    break;
                case 5:
                    System.out.println(this.cust_query.action_create_coach());
                    break;
                case 6:
                    System.out.println("Display stats for all teams in tournament: " + this.cust_query.action_get_tournament_name());
                    System.out.println(this.cust_query.action_show_team_stats());
                    System.out.println(this.cust_query.action_show_game_stats());
                    break;
                case 7:
                    System.out.println("Additional menu to edit tournament details");
                    showAdditionalMenu();
                    break;
                case 8:
                    exit(0);
                default:
                    System.out.println("Sorry, please enter valid Option");
            }

        } while (optionn != 8);

        System.out.println("Thank you. Good Bye.");
    }

    /**
     * Helper function to show menu and get options interactive.
     *
     * @return      Integer     Options selected from the menu
     */
    private static int showMenu(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\n Main Menu:");
        System.out.println("--------------");
        System.out.println("1.Create a tournament");
        System.out.println("2.Create team");
        System.out.println("3.Report a game");
        System.out.println("4.Create player");
        System.out.println("5.Create coach");
        System.out.println("6.Display tournament stats");
        System.out.println("7.Additional menu to edit tournament details");
        System.out.println("8.Exit");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
        int optionn = keyboard.nextInt();

        return optionn;
    }

    /***
     * Additional menu for:
     * - Editing team
     * - Edit team
     * - Edit player for team
     * - Edit coach for a team
     * - Edit game from current record
     */
    private void showAdditionalMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\n Additional Menu:");
        System.out.println("--------------");
        System.out.println("1.Edit Tournament");
        System.out.println("2.Edit Team");
        System.out.println("3.Edit Player");
        System.out.println("4.Edit Coach");
        System.out.println("5.Edit game recorded");
        System.out.println("6.Exit");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
        int optionn = keyboard.nextInt();

        switch (optionn) {
            case 1:
                this.editTournament();
                break;
            case 2:
                this.editTeamDetails();
                break;
            case 3:
                this.editPlayer();
                break;
            case 4:
                this.editCoach();
                break;
            case 5:
//                System.out.println(this.editGame());
                break;
            case 6:
                break;
            default:
                System.out.println("Sorry, please enter valid Option");
            }
    }

    /***
     * Edit team details. Query from created tournament, select from current team to edit details.
     *
     */
    private void editTeamDetails() {
        Scanner keyboard = new Scanner(System.in);
        String all_teams = this.cust_query.action_display_all_teams();
        System.out.println(all_teams);
        String teamSelected = keyboard.nextLine();

        System.out.println("\n Edit Team: " + teamSelected);
        System.out.println("--------------");
        System.out.println("1.Add players to the team");
        System.out.println("2.Add coaches to the team");
        System.out.println("3.Change name of the team");
        System.out.println("4.Change location of the team");
        System.out.println("5.Add banner of the team");
        System.out.println("6.Set default league of the team");
        System.out.println("7.Set stadium of the team");
        System.out.println("8.Exit");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
        int optionn = keyboard.nextInt();


        switch (optionn) {
            case 1:
                System.out.println(this.cust_query.action_create_player());
                break;
            case 2:
                System.out.println(this.cust_query.action_create_coach());
                break;
            case 3:
                System.out.println(this.cust_query.action_change_team_name(teamSelected));
                break;
            case 4:
                System.out.println(this.cust_query.action_change_team_location(teamSelected));
                break;
            case 5:
                System.out.println(this.cust_query.action_add_banner_of_the_team(teamSelected));
                break;
            case 6:
                System.out.println(this.cust_query.action_add_default_league_of_the_team(teamSelected));
                break;
            case 7:
                System.out.println(this.cust_query.action_set_stadium_of_the_team(teamSelected));
                break;
            case 8:
                break;
            default:
                System.out.println("Sorry, please enter valid Option");
        }
    }

    /***
     * Edit player details. Query from created tournament. Select team and player name. If found enter details about
     * player.
     *
     */
    private void editPlayer() {
        Scanner keyboard = new Scanner(System.in);
        String all_teams = this.cust_query.action_display_all_teams();
        System.out.println(all_teams);
        String teamSelected = keyboard.nextLine();

        this.cust_query.action_display_all_players_in_team(teamSelected);
        String player = keyboard.nextLine();

        System.out.println("\n Edit player: " + player);
        System.out.println("--------------");
        System.out.println("1.Set dominant foot");
        System.out.println("2.Set position of the player");
        System.out.println("3.Change name of the player");
        System.out.println("4.Change nick name of the player");
        System.out.println("5.Set rating for the player");
        System.out.println("6.Set height of the player");
        System.out.println("7.Set sex of the player");
        System.out.println("8.Back");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
        int optionn = keyboard.nextInt();

        switch (optionn) {
            case 1:
                System.out.println(this.cust_query.action_change_player_dominant_foot(player, teamSelected));
                break;
            case 2:
                System.out.println(this.cust_query.action_change_position_of_player(player, teamSelected));
                break;
            case 3:
                System.out.println(this.cust_query.action_change_player_name(player, teamSelected));
                break;
            case 4:
                System.out.println(this.cust_query.action_change_player_nick_name(player, teamSelected));
                break;
            case 5:
                System.out.println(this.cust_query.action_player_rating(player, teamSelected));
                break;
            case 6:
                System.out.println(this.cust_query.action_add_player_height(player, teamSelected));
                break;
            case 7:
                System.out.println(this.cust_query.action_add_player_sex(player, teamSelected));
                break;
            case 8:
                break;
            default:
                System.out.println("Sorry, please enter valid Option");
        }
    }

    /***
     * Edit coach details. Query from created tournament. Select team and coach name. If found enter details about
     * coach.
     *
     */
    private void editCoach() {
        Scanner keyboard = new Scanner(System.in);
        String all_teams = this.cust_query.action_display_all_teams();
        System.out.println(all_teams);
        String teamSelected = keyboard.nextLine();

        this.cust_query.action_display_all_coaches_in_team(teamSelected);
        String coachName = keyboard.nextLine();

        System.out.println("\n Edit player: " + coachName);
        System.out.println("--------------");
        System.out.println("1.Set position of the coach");
        System.out.println("2.Change name of the coach");
        System.out.println("3.Change nick name of the coach");
        System.out.println("4.Change age for the coach");
        System.out.println("5.Set rating for the coach");
        System.out.println("6.Set height of the coach");
        System.out.println("7.Back");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
        int optionn = keyboard.nextInt();

        switch (optionn) {
            case 1:
                System.out.println(this.cust_query.action_change_position_of_coach(coachName, teamSelected));
                break;
            case 2:
                System.out.println(this.cust_query.action_change_coach_name(coachName, teamSelected));
                break;
            case 3:
                System.out.println(this.cust_query.action_change_coach_nick_name(coachName, teamSelected));
                break;
            case 4:
                System.out.println(this.cust_query.action_coach_rating(coachName, teamSelected));
                break;
            case 5:
                System.out.println(this.cust_query.action_add_coach_height(coachName, teamSelected));
                break;
            case 6:
                System.out.println(this.cust_query.action_add_coach_sex(coachName, teamSelected));
                break;
            case 7:
                break;
            default:
                System.out.println("Sorry, please enter valid Option");
        }
    }

    /***
     * Edit tournament details.
     */
    private void editTournament() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\n Edit tournament: " + this.cust_query.action_get_tournament_name());
        System.out.println("--------------");
        System.out.println("1.Set venue of the tournament");
        System.out.println("2.Reset Tournament");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
        int optionn = keyboard.nextInt();

        switch (optionn) {
            case 1:
                System.out.println(this.cust_query.action_set_venue_of_tournament());
                break;
            case 2:
                System.out.println(this.cust_query.action_reset_tournament());
                break;
            default:
                System.out.println("Sorry, please enter valid Option");
        }
    }
}
