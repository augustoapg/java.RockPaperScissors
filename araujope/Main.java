/*
    Name: Augusto Araujo Peres Goncalez
    Assignment: Assignment 4
    Program: Computer Systems Technology – Systems Analyst
    Date: 07/20/17

    Description:
    This application is used for a user to play the game rock paper scissors in 
    a GUI against the computer.
 */
package araujope;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class of the application
 *
 * @author Augusto Araujo Peres Goncalez
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRps.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Play Rock-Paper-Scissors");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method of the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
