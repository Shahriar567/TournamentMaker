package src.exception;

public class CoachNotFoundException extends Exception {
    public CoachNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}