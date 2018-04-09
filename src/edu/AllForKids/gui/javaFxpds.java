package edu.AllForKids.gui;
import java.io.File;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
/**
 * @web http://java-buddy.blogspot.com/
 */
public class javaFxpds extends Application {
     
    @Override
    public void start(final Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Load PDF");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                  
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = 
                        new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
                fileChooser.getExtensionFilters().add(extFilter);
                  
                //Show open file dialog
                File file = fileChooser.showOpenDialog(primaryStage);
 
                HostServices hostServices = getHostServices();
                hostServices.showDocument(file.getAbsolutePath());
            }
        });
         
        StackPane root = new StackPane();
        root.getChildren().add(btn);
         
        Scene scene = new Scene(root, 300, 250);
         
        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
