/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.AllForKids.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class EventMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root;
            
            //root = FXMLLoader.load(getClass().getResource("Log.fxml"));
            //root = FXMLLoader.load(getClass().getResource("GestionEvenement.fxml"));
            root = FXMLLoader.load(getClass().getResource("AcceuilFrontEnd.fxml"));
            //root = FXMLLoader.load(getClass().getResource("EvenementFrontEnd.fxml"));
            //root = FXMLLoader.load(getClass().getResource("R.fxml"));
            
            /// root = FXMLLoader.load(getClass().getResource("AC.fxml"));
            //  root = FXMLLoader.load(getClass().getResource("AccueilBackEnd.fxml"));
            
            
            // root = FXMLLoader.load(getClass().getResource("aal.fxml"));

            Scene scene = new Scene(root);
  primaryStage.setScene(scene);
            /* primaryStage.setMaximized(true);
            primaryStage.setFullScreen(true);*/
          Screen screen = Screen.getPrimary();
          Rectangle2D bounds = screen.getVisualBounds();       
primaryStage.setX(bounds.getMinX());
primaryStage.setY(bounds.getMinY());
primaryStage.setWidth(bounds.getWidth());
primaryStage.setHeight(bounds.getHeight());
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(EventMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
