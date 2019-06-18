package src.Util;

public enum score {

    WIN('W'),
    LOSS('L'),
    DRAW('D');

    char res;

    /**
     * Constructs the Enum element with the specified character.
     * @param res The character representation of the Enum element.
     */
    score(char res){
        this.res = res;
    }

    /**
     * Returns 'W' for a win, 'L' for a loss and 'D' for a draw.
     *
     * @return A character representing the result.
     */
    public char getChar(){
        return res;
    }
}
