/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ClasesGlobales.RecursosGlobales;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author avile
 */
public class SubMenuController implements Initializable {

    public static int nAnimates, delay;
    public static String nombre, imagen;
    @FXML
    private VBox contenedorItems;
    @FXML
    private HBox modosJuego;
    @FXML
    private TilePane contenedorNiveles;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createCharacter(5, "Kakashi", "stand", contenedorItems, 200);
        createCharacter(8, "Survival", "run", modosJuego, 95);
        createCharacter(7, "Platforms", "die", modosJuego, 150);
        createCharacter(7, "Zombies", "attack", modosJuego, 110);
    }

    private void createCharacter(int nA, String name, String url, Pane contenedor, int del) {
        try {
            delay =del;
            nAnimates = nA;
            nombre = name;
            imagen = url;
            Parent item = FXMLLoader.load(getClass().getResource("/Designs/Item.fxml"));
            contenedor.getChildren().add(item);
        } catch (IOException ex) {
            Logger.getLogger(SubMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void play(ActionEvent event) {
        changeScene("/Designs/Game.fxml");
    }

    @FXML
    private void cancel(ActionEvent event) {
        changeScene("/Designs/Menu.fxml");
    }

    private void changeScene(String string) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(string));
            RecursosGlobales.getScene().setRoot(root);
            RecursosGlobales.getStage().sizeToScene();
            RecursosGlobales.getStage().centerOnScreen();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro la url solicitada");
        }
    }

}
