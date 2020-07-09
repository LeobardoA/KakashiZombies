/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author avile
 */
public class ItemController implements Initializable {

    private String titulo, imagen;
    private Timeline animation;
    private KeyFrame todo;
    private int nFrames, i = 1, delay, id;
    @FXML
    private AnchorPane item;
    @FXML
    private ImageView logo;
    @FXML
    private Label nombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id = SubMenuController.id;
        nFrames = SubMenuController.nAnimates;
        titulo = SubMenuController.nombre;
        imagen = SubMenuController.imagen;
        delay = SubMenuController.delay;
        animation = new Timeline();
        System.out.println(titulo + " con el id:" + id);
        todo = new KeyFrame(Duration.millis(delay), (event) -> {
            if (!imagen.equals("stand")) {
                logo.setImage(new Image(getClass().getResourceAsStream("/Assets/imagenes/" + imagen + " (" + i + ").png")));
                if (i >= nFrames) {
                    i = 1;
                } else {
                    i++;
                }
            } else {
                logo.setImage(new Image(getClass().getResourceAsStream("/Assets/imagenes/" + imagen + " (" + i + ").png")));
                if (i >= 5) {
                    i = 3;
                } else {
                    i++;
                }
            }

        });
        animation.getKeyFrames().add(todo);
        animation.setCycleCount(Timeline.INDEFINITE);
        nombre.setText(SubMenuController.nombre);
        logo.setImage(new Image(getClass().getResourceAsStream("/Assets/imagenes/" + imagen + " (1).png")));
        SubMenuController.idPropertyModos.addListener((observable, oldValue, newValue) -> {
            if (SubMenuController.idPropertyModos.getValue() != id) {
                nombre.setTextFill(Color.WHITE);
            } else {
                nombre.setTextFill(Color.GOLD);
            }
        });
    }

    @FXML
    private void pressed(MouseEvent event) {
        nombre.setTextFill(Color.GOLD);
    }

    @FXML
    private void exited(MouseEvent event) {
        animation.stop();
        logo.setImage(new Image(getClass().getResourceAsStream("/Assets/imagenes/" + imagen + " (1).png")));
    }

    @FXML
    private void entered(MouseEvent event) {
        animation.play();
    }

    @FXML
    private void released(MouseEvent event) {
        nombre.setTextFill(Color.WHITE);
    }

    @FXML
    private void clicked(MouseEvent event) {
        SubMenuController.idPropertyModos.setValue(id);
    }

}
