/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ClasesGlobales.Kakashi;
import ClasesGlobales.KakashiZombies;
import ClasesGlobales.RecursosGlobales;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Alex
 */
public class GameController implements Initializable {

    private int width, height, cicle;
    @FXML
    private ImageView bg2_1;
    @FXML
    private ImageView bg2_2;
    @FXML
    private ImageView bg1_1;
    @FXML
    private ImageView bg1_2;
    @FXML
    private ImageView bg3_1;
    @FXML
    private ImageView bg3_2;
    @FXML
    private AnchorPane padre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        width = 1200;
        height = 720;
        cicle = 0;
        
        Kakashi k = new Kakashi();
        padre.getChildren().add(k);

        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(
                new KeyFrame(Duration.millis(8), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        movBg();
                        if (cicle % 8 == 0) {
                            k.movimiento();
                        }

                        cicle++;
                    }
                }));
        time.play();

    RecursosGlobales.getScene().setOnKeyPressed((event) -> {
        System.out.println("Hi");
    });

    }

    public void movBg() {
        //bg 3 in sky
        bg3_1.setLayoutX(bg3_1.getLayoutX() - 1);
        bg3_2.setLayoutX(bg3_2.getLayoutX() - 1);
        if (bg3_1.getLayoutX() <= -width) {
            bg3_1.setLayoutX(width);
        }
        if (bg3_2.getLayoutX() <= -width) {
            bg3_2.setLayoutX(width);
        }

        //bg 2 in middle
        bg2_1.setLayoutX(bg2_1.getLayoutX() - 2);
        bg2_2.setLayoutX(bg2_2.getLayoutX() - 2);
        if (bg2_1.getLayoutX() <= -width) {
            bg2_1.setLayoutX(width);
        }
        if (bg2_2.getLayoutX() <= -width) {
            bg2_2.setLayoutX(width);
        }

        //bg 1 in front
        bg1_1.setLayoutX(bg1_1.getLayoutX() - 8);
        bg1_2.setLayoutX(bg1_2.getLayoutX() - 8);
        if (bg1_1.getLayoutX() <= -width) {
            bg1_1.setLayoutX(width);
        }
        if (bg1_2.getLayoutX() <= -width) {
            bg1_2.setLayoutX(width);
        }

    }

}
