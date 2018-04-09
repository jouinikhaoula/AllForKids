/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.AllForKids.gui;

import edu.AllForKids.entities.Enfant;
import edu.AllForKids.entities.Reponse;
import edu.AllForKids.gui.LoginController;
import edu.AllForKids.services.CrudUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AcceuilFrontEndController implements Initializable {

    @FXML
    private Label UserName;
    @FXML
    private ImageView UserImage;
    @FXML
    private Button BtnAcceuil;
    @FXML
    private Button BtnStore;
    @FXML
    private Button BtnBabySitter;
    @FXML
    private Button BtnEvenent;
    @FXML
    public Button BtnEspace;
    @FXML
    private Button BtnPediatre;
    @FXML
    public  ScrollPane SrollPaneMain;

    /**
     * Initializes the controller class.
     */
    Stage primaryStage;
    AnchorPane GestionUser, GestionStore, GestionEvenement, GestionEspace, GestionBabySitter, GestionPediatre, AcceuilClient;

  /*  AcceuilFrontEndController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // GestionEvenement = FXMLLoader.load(getClass().getResource("EvenementFrontEnd.fxml"));
            GestionEspace = FXMLLoader.load(getClass().getResource("DisplayListQuiz.fxml"));
            // GestionBabySitter = FXMLLoader.load(getClass().getResource(".fxml"));
            GestionPediatre = FXMLLoader.load(getClass().getResource("ViewProgression.fxml"));
            // GestionStore = FXMLLoader.load(getClass().getResource(".fxml"));
            /* Image image = new Image("file:" + LoginController.CurrentUser.getNom_image());
            UserName.setText(LoginController.CurrentUser.getUsername());
            UserImage.setImage(image);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
            @Override
            public void run() {
            // TODO do your thing
            System.out.println(LoginController.CurrentUser.getUsername());
            UserName.setText(LoginController.CurrentUser.getUsername());
            UserImage.setImage(new Image("file:" + LoginController.CurrentUser.getNom_image()));
            
            }
            }, 0, 1000);*/
        } catch (IOException ex) {
            Logger.getLogger(AcceuilFrontEndController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ProfileEdit(MouseEvent event) {
    }

    @FXML
    private void Lougout(MouseEvent event) throws IOException {
        /*  FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Login.fxml"));
        loader.setController(new LoginController(primaryStage));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
         */
    }

    public void setNode(Node node) {

        SrollPaneMain.setContent(node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void GetAcceuil(ActionEvent event) {
        
setNode(AcceuilClient);
        BtnAcceuil.setStyle("-fx-background-color:  #086A87");
        BtnAcceuil.setTextFill(Color.web("#FBFCFC"));
        //
        BtnStore.setStyle("-fx-background-color:  #FFFFFF");
        BtnStore.setTextFill(Color.web("#2471A3"));
        BtnEspace.setStyle("-fx-background-color:  #FFFFFF");
        BtnEspace.setTextFill(Color.web("#2471A3"));
        BtnEvenent.setStyle("-fx-background-color:  #FFFFFF");
        BtnEvenent.setTextFill(Color.web("#2471A3"));
        BtnBabySitter.setStyle("-fx-background-color:  #FFFFFF");
        BtnBabySitter.setTextFill(Color.web("#2471A3"));
        BtnPediatre.setStyle("-fx-background-color:  #FFFFFF");
        BtnPediatre.setTextFill(Color.web("#2471A3"));
    }

    @FXML
    private void GetStore(ActionEvent event) {
        setNode(BtnStore);
        BtnAcceuil.setStyle("-fx-background-color:  #086A87");
        BtnAcceuil.setTextFill(Color.web("#FBFCFC"));
        //
        BtnStore.setStyle("-fx-background-color:  #FFFFFF");
        BtnStore.setTextFill(Color.web("#2471A3"));
        BtnEspace.setStyle("-fx-background-color:  #FFFFFF");
        BtnEspace.setTextFill(Color.web("#2471A3"));
        BtnEvenent.setStyle("-fx-background-color:  #FFFFFF");
        BtnEvenent.setTextFill(Color.web("#2471A3"));
        BtnBabySitter.setStyle("-fx-background-color:  #FFFFFF");
        BtnBabySitter.setTextFill(Color.web("#2471A3"));
        BtnPediatre.setStyle("-fx-background-color:  #FFFFFF");
        BtnPediatre.setTextFill(Color.web("#2471A3"));
    }

    @FXML
    private void GetBabySitter(ActionEvent event) {
        setNode(GestionBabySitter);
        BtnAcceuil.setStyle("-fx-background-color:  #086A87");
        BtnAcceuil.setTextFill(Color.web("#FBFCFC"));
        //
        BtnStore.setStyle("-fx-background-color:  #FFFFFF");
        BtnStore.setTextFill(Color.web("#2471A3"));
        BtnEspace.setStyle("-fx-background-color:  #FFFFFF");
        BtnEspace.setTextFill(Color.web("#2471A3"));
        BtnEvenent.setStyle("-fx-background-color:  #FFFFFF");
        BtnEvenent.setTextFill(Color.web("#2471A3"));
        BtnBabySitter.setStyle("-fx-background-color:  #FFFFFF");
        BtnBabySitter.setTextFill(Color.web("#2471A3"));
        BtnPediatre.setStyle("-fx-background-color:  #FFFFFF");
        BtnPediatre.setTextFill(Color.web("#2471A3"));

    }

    @FXML
    private void GetEvenement(ActionEvent event) {

       setNode(GestionEvenement);
        BtnAcceuil.setStyle("-fx-background-color:  #086A87");
        BtnAcceuil.setTextFill(Color.web("#FBFCFC"));
        //
        BtnStore.setStyle("-fx-background-color:  #FFFFFF");
        BtnStore.setTextFill(Color.web("#2471A3"));
        BtnEspace.setStyle("-fx-background-color:  #FFFFFF");
        BtnEspace.setTextFill(Color.web("#2471A3"));
        BtnEvenent.setStyle("-fx-background-color:  #FFFFFF");
        BtnEvenent.setTextFill(Color.web("#2471A3"));
        BtnBabySitter.setStyle("-fx-background-color:  #FFFFFF");
        BtnBabySitter.setTextFill(Color.web("#2471A3"));
        BtnPediatre.setStyle("-fx-background-color:  #FFFFFF");
        BtnPediatre.setTextFill(Color.web("#2471A3"));
    }

    @FXML
    private void GetEspace(ActionEvent event) throws IOException, SQLException {
       AlertChoice();
       // setNode(GestionEspace);
        BtnAcceuil.setStyle("-fx-background-color:  #086A87");
        BtnAcceuil.setTextFill(Color.web("#FBFCFC"));
        //
        BtnStore.setStyle("-fx-background-color:  #FFFFFF");
        BtnStore.setTextFill(Color.web("#2471A3"));
        BtnEspace.setStyle("-fx-background-color:  #FFFFFF");
        BtnEspace.setTextFill(Color.web("#2471A3"));
        BtnEvenent.setStyle("-fx-background-color:  #FFFFFF");
        BtnEvenent.setTextFill(Color.web("#2471A3"));
        BtnBabySitter.setStyle("-fx-background-color:  #FFFFFF");
        BtnBabySitter.setTextFill(Color.web("#2471A3"));
        BtnPediatre.setStyle("-fx-background-color:  #FFFFFF");
        BtnPediatre.setTextFill(Color.web("#2471A3"));

    }

    @FXML
    private void GetPediatre(ActionEvent event) {
        setNode(GestionPediatre);
        BtnAcceuil.setStyle("-fx-background-color:  #086A87");
        BtnAcceuil.setTextFill(Color.web("#FBFCFC"));
        //
        BtnStore.setStyle("-fx-background-color:  #FFFFFF");
        BtnStore.setTextFill(Color.web("#2471A3"));
        BtnEspace.setStyle("-fx-background-color:  #FFFFFF");
        BtnEspace.setTextFill(Color.web("#2471A3"));
        BtnEvenent.setStyle("-fx-background-color:  #FFFFFF");
        BtnEvenent.setTextFill(Color.web("#2471A3"));
        BtnBabySitter.setStyle("-fx-background-color:  #FFFFFF");
        BtnBabySitter.setTextFill(Color.web("#2471A3"));
        BtnPediatre.setStyle("-fx-background-color:  #FFFFFF");
        BtnPediatre.setTextFill(Color.web("#2471A3"));

    }

    public void setLabelUserName(String username, int Id) {
       this.UserName.setText(username);
    }
    
    
    
    public void AlertChoice() throws SQLException
    {
       List<String> choices = new ArrayList<>();
        CrudUser cu=new CrudUser();
              ArrayList<String> nom=cu.getListEnfant(1);
   
        choices.addAll(nom);


ChoiceDialog<String> dialog = new ChoiceDialog<>("",choices);
dialog.setTitle("Choice Dialog");
dialog.setHeaderText("Look, a Choice Dialog");
dialog.setContentText("Choose your letter:");

// Traditional way to get the response value.
Optional<String> result = dialog.showAndWait();
if (result.isPresent()){
    System.out.println("Your choice: " + result.get());
    setNode(GestionEspace);
}
else
{
   System.out.println("else");
   setNode(AcceuilClient);
}


    }
  private void ShowQuestionDialog() throws IOException, SQLException {
        

      // Parent root = FXMLLoader.load(getClass().getResource("DisplayListQuiz.fxml"));
        final Stage dialog = new Stage();
        dialog.setTitle("selectionner votre nom");
        // dialog.initOwner(root.get);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initStyle(StageStyle.UTILITY);
        /*  dialog.setX(50 +50);
    dialog.setY(10);*/

        // create a grid for the data entry.
        GridPane grid = new GridPane();
        
        CrudUser cu=new CrudUser();
              ArrayList<String> nom=cu.getListEnfant(1);
        ObservableList<String> listcat = FXCollections.observableArrayList(nom);
        final ComboBox<String> Libellerep = new ComboBox<>(listcat);
     grid.addRow(0, Libellerep);

        //grid.addRow(0, new Label("Reponse"), Libellerep);
   
        grid.setHgap(10);
        grid.setVgap(10);
        GridPane.setHgrow(Libellerep, Priority.ALWAYS);
     
        // create action buttons for the dialog.
        Button ok = new Button("OK");
        ok.setDefaultButton(true);
        Button cancel = new Button("Cancel");
        cancel.setCancelButton(true);

        // only enable the ok button when there has been some text entered.
        ok.disableProperty().bind(Libellerep.selectionModelProperty().isNull());
     ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                
         
// Integer.parseInt(verif.getText()), Integer.parseInt(point.getText())

                dialog.close();
            }
        });
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dialog.close();
            }
        });

        // layout the dialog.
        HBox buttons = HBoxBuilder.create().spacing(10).children(ok, cancel).alignment(Pos.CENTER_RIGHT).build();
        VBox layout = new VBox(10);
        layout.getChildren().addAll(grid, buttons);
        layout.setPadding(new Insets(5));
        dialog.setScene(new Scene(layout));
        dialog.show();
    }

}
