package src.exception;

public class CoachLimitExcededException extends Exception {
    public CoachLimitExcededException(String errorMessage) {
        super(errorMessage);
    }
}

