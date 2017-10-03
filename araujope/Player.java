/*
    Name: Augusto Araujo Peres Goncalez
    File:  Player.java
    Other Files in this Project:
    Main.java
    FXMLRps.fxml
    FXMLRpsController.java
    Rps.java
    main.css
    
    Main class: Main.java
 */
package araujope;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * This class a player in the game. It makes it possible for the user to make a
 * move and it stores this move. Also, it keeps the score of the player.
 *
 * @author Augusto Araujo Peres Goncalez
 */
public class Player {

    public Rps move;
    private IntegerProperty score
            = new SimpleIntegerProperty(this, "score", 0);

    /**
     * Constructs a default Player object
     */
    public Player() {
    }

    /**
     * Method that defines the value of the score as long as the value of the
     * score given as a parameter is greater than or equal to zero. It throws an
     * exception in the case the score parameter is invalid.
     *
     * @param score the points earned by the Player
     */
    public void setScore(int score) {
        // Checks if score is valid (greater than or equal to zero)
        if (score >= 0) {
            this.score.set(score);
        } else {
            // Throws exception if score is less than 0
            throw new IllegalArgumentException("Invalid: score must be greater "
                    + "than or equal to zero.");
        }
    }

    /**
     * Retrieves the player's score as an integer
     *
     * @return the player's score
     */
    public int getScore() {
        return score.get();
    }

    /**
     * Method that increases the Player's score by 1
     */
    public void incrementScore() {
        // gets the score and then add 1 to it
        score.set(score.get() + 1);
    }

    /**
     * Method used for retrieving the Player's score property
     *
     * @return this Player's score property
     */
    public IntegerProperty scoreProperty() {
        return score; // returns Player's score property
    }

    /**
     * Method that sets the Player's move to the move constant correspondent to
     * the move name given as a parameter
     *
     * @param move the name of the move wished to me made
     */
    public void makeMove(String move) {
        // do a reverse lookup to set the Player's move to the move name given
        this.move = Rps.getRps(move);
    }

    /**
     * It sets the move property to a random move
     */
    public void makeRandomMove() {
        // Variable that has an int random number between 0 and 2
        int rand = (int) (Math.random() * 3);

        switch (rand) {
            case 0: // if rand is 0, set move to ROCK
                move = Rps.ROCK;
                break;
            case 1: // if rand is 1, set move to PAPER
                move = Rps.PAPER;
                break;
            default: // if rand is 2, set move to SCISSORS
                move = Rps.SCISSORS;
                break;
        }
    }

    /**
     * Returns the String representation of this Player, which is the String
     * name of the Player's current move
     *
     * @return the String name of this Player's current move
     */
    @Override
    public String toString() {
        return move.getName(); // returns name of the current move
    }
}
