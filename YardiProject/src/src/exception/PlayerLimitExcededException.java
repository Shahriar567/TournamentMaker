package src.exception;

public class PlayerLimitExcededException extends Exception {
    public PlayerLimitExcededException(String errorMessage) {
        super(errorMessage);
    }
}

