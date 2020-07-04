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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Alex
 */
public class GameController implements Initializable {

    @FXML
    private ImageView bg2_1;
    @FXML
    private ImageView bg2_2;
    @FXML
    private ImageView bg1_1;
    @FXML
    private ImageView bg1_2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bg1_2.setLayoutX(960);
        bg2_2.setLayoutX(960);

        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(
                new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        movBg();
                    }
                }));
        time.play();
    }

    public void movBg() {
        //bg 2 in middle
        bg2_1.setLayoutX(bg2_1.getLayoutX() - 2);
        bg2_2.setLayoutX(bg2_2.getLayoutX() - 2);
        if (bg2_1.getLayoutX() <= -960) {
            bg2_1.setLayoutX(960);
        }
        if (bg2_2.getLayoutX() <= -960) {
            bg2_2.setLayoutX(960);
        }

        //bg 1 in front
        bg1_1.setLayoutX(bg1_1.getLayoutX() - 5);
        bg1_2.setLayoutX(bg1_2.getLayoutX() - 5);
        if (bg1_1.getLayoutX() <= -960) {
            bg1_1.setLayoutX(960);
        }
        if (bg1_2.getLayoutX() <= -960) {
            bg1_2.setLayoutX(960);
        }

    }

}
