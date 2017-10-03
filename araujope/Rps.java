/*
    Name: Augusto Araujo Peres Goncalez
    File:  Rps.java
    Other Files in this Project:
    Main.java
    FXMLRps.fxml
    FXMLRpsController.java
    Player.java
    main.css
    
    Main class: Main.java
 */
package araujope;

import java.util.HashMap;

/**
 * This class is an enum that contains the constants and attributes used by the
 * Player class in order to play the game and determine which move wins over
 * which.
 *
 * @author Augusto Araujo Peres Goncalez
 */
public enum Rps {
    ROCK("rock", "scissors"),
    PAPER("paper", "rock"),
    SCISSORS("scissors", "paper");

    private String name;
    private String winsOver;
    private static HashMap<String, Rps> lookupByName = null;

    /**
     * Constructs the enum and assign the respective name of the move and the
     * move that is beaten by each constant
     *
     * @param name the String name of the constant
     * @param winsOver the move that the constant is able to beat
     */
    private Rps(String name, String winsOver) {
        this.name = name; // assigns parameter to variables
        this.winsOver = winsOver;
    }

    /**
     * Retrieves this constant's String name
     *
     * @return the name of the move
     */
    public String getName() {
        return name; // The name of the move
    }

    /**
     * Retrieves the move that this constant can beat
     *
     * @return the move that is beaten by this move
     */
    public String getWinsOver() {
        return winsOver; // The move that is beaten by the constant
    }

    /**
     * Method that gets the name of the move and returns the actual enum that
     * corresponds to it.
     *
     * @param name the String name of the constant
     * @return the enum constant correspondent to the name given
     */
    public static Rps getRps(String name) {
        // checks if the HashMap was already initialized
        if (lookupByName == null) {
            // populate HashMap since it was not yet populated
            initNameLookup();
        }
        // get the Rps constant from the HashMap for the given move name
        Rps r = lookupByName.get(name);

        // in the case name was not found, throws Exception
        if (r == null) {
            throw new IllegalArgumentException("Invalid move name.");
        }

        // returns the Rps constant for the name given
        return r;
    }

    /**
     * Method that returns true in case this constant and the one passed as a
     * parameter are the same
     *
     * @param other the move being compared with this constant
     * @return true if there was a tie and false if it was not a tie
     */
    public boolean tie(Rps other) {
        // returns true if tie (both moves are the same)
        return (this == other);
    }

    /**
     * Method that compares this move with another passed as a parameter and
     * checks if this move beats the one being compared to
     *
     * @param other the move being checked to see if it is beaten by this move
     * @return true if the move parameter is beaten by this constant
     */
    public boolean win(Rps other) {
        // returns true if this constant's winOver data is equal to the name of
        // the move passed as a parameter (if this constant beats the other)
        return (this.winsOver.equals(other.getName()));
    }

    /**
     * Static class used for populating a HashMap with the name of the move as
     * the key and its respective Rps enum, in order to make it possible to do a
     * reverse lookup using the name of the move
     */
    private static void initNameLookup() {
        // creates the HashMap object that get the names and Rps
        lookupByName = new HashMap<String, Rps>();

        // loop that populates the HashMap with the name as the key and its
        // correspondent Rps
        for (Rps r : values()) {
            lookupByName.put(r.name, r);
        }
    }
}
