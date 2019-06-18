package src.exception;

public class PlayerWithSameNameAlreadyAddedException extends Exception {
    public PlayerWithSameNameAlreadyAddedException(String errorMessage) {
        super(errorMessage);
    }
}