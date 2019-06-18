package src.exception;

public class TeamNotFoundException extends Exception {
    public TeamNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
