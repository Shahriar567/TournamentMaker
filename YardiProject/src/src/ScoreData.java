package src;
import src.Util.score;

public class ScoreData{

    private Team versusTeam;
    private score versusScore;
    private int goalsConceded;
    private int goalsScored;

    public Team getVersusTeam() {
        return versusTeam;
    }

    public void setVersusTeam(Team versusTeam) {
        this.versusTeam = versusTeam;
    }

    public score getVersusScore() {
        return versusScore;
    }

    public void setVersusScore(score versusScore) {
        this.versusScore = versusScore;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public ScoreData(Team versusTeam, score versusScore, int goalsConceded, int goalsScored) {
        // fill the array with ascending integer values
        this.versusTeam = versusTeam;
        this.versusScore = versusScore;
        this.goalsConceded = goalsConceded;
        this.goalsScored = goalsScored;
    }
}