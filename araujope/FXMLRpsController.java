/*
    Name: Augusto Araujo Peres Goncalez
    File:  FXMLRps.fxml
    Other Files in this Project:
    Main.java
    FXMLRps.fxml
    Rps.java
    Player.java
    main.css
    
    Main class: Main.java
 */
package araujope;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author augus
 */
public class FXMLRpsController implements Initializable {

    // reference to all images (user options and computer move)
    @FXML
    private ImageView imgRock, imgPaper, imgScissors, imgComputer;

    // reference to all stats that will be changed in the game
    @FXML
    private Label lblWinner, lblPlayerScore, lblCompScore;

    @FXML
    private Button btnReset, btnExit; // reference to buttons on the game

    private Player player = new Player(); // reference to the user player
    private Player computer = new Player(); // reference to the computer player

    /**
     * Method used to assign the event handler of the images when clicked by the
     * user, setting the move made
     *
     * @param event the click event object fired by the images
     */
    @FXML
    private void imgClicked(MouseEvent event) {
        /* changes the color of the border (flow pane) of the image clicked and
            set all other images back to the default and updates the move
            datafield of the player */

        // if the image clicked was rock
        if (event.getSource() == imgRock) {
            player.makeMove("rock"); // sets move to Rock
            imgPaper.getParent().setStyle("-fx-background-color: green;");
            imgScissors.getParent().setStyle("-fx-background-color: green;");
            imgRock.getParent().setStyle("-fx-background-color: red;");
        } // if the image clicked was paper
        else if (event.getSource() == imgPaper) {
            player.makeMove("paper"); // sets move to Paper
            imgRock.getParent().setStyle("-fx-background-color: green;");
            imgScissors.getParent().setStyle("-fx-background-color: green;");
            imgPaper.getParent().setStyle("-fx-background-color: red;");
        } // if the image clicked was scissors
        else {
            player.makeMove("scissors"); // sets move to Scissors
            imgRock.getParent().setStyle("-fx-background-color: green;");
            imgPaper.getParent().setStyle("-fx-background-color: green;");
            imgScissors.getParent().setStyle("-fx-background-color: red;");
        }

        // sets the move data field of the computer player as a random move
        computer.makeRandomMove();

        // set computer's image according to the random move
        imgComputer.setImage(new Image(getClass().
                getResource("res/" + computer.move.getName() + ".png").
                toExternalForm()));

        // determine the result
        // if it is a tie
        if (player.move.tie(computer.move)) {
            lblWinner.setText("It's a Tie!"); // update winner's label
        } // if player won
        else if (player.move.win(computer.move)) {
            lblWinner.setText("Player Wins!"); // update winner's label
            player.incrementScore(); // update user's score
        } // if computer won (if it is not a tie and player did not win)
        else {
            lblWinner.setText("Computer Wins!"); // update winner's label
            computer.incrementScore(); // update computer's score
        }
    }

    /**
     * Method that sets the entire screen back to the default state, that is
     * setting the scores back to zero, the borders back to green and the
     * computer image back to the question mark
     *
     * @param event the action event object fired by the reset button
     */
    @FXML
    private void reset(ActionEvent event) {
        // set scores back to zero
        player.setScore(0);
        computer.setScore(0);

        // set player image's borders back to green
        imgRock.getParent().setStyle("-fx-background-color: green;");
        imgPaper.getParent().setStyle("-fx-background-color: green");
        imgScissors.getParent().setStyle("-fx-background-color: green");

        // set computer's image back to default
        imgComputer.setImage(new Image(getClass().
                getResource("res/question.png").toExternalForm()));
    }

    /**
     * Method that ends the application and closes the window
     *
     * @param event the action event object fired by the exit button
     */
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0); // exit the application
    }

    /**
     * Method that is invoked automatically after the start() method executes.
     * It contains the binding of the label with the player's score and the
     * player object property score
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* bind the player's and the computer's Score property with the label 
        for the score */
        lblPlayerScore.textProperty().bind(player.scoreProperty().asString());
        lblCompScore.textProperty().bind(computer.scoreProperty().asString());
    }

}
