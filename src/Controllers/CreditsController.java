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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author avile
 */
public class CreditsController implements Initializable {

    private Timeline time0, time1, time2, time3, time4;

    @FXML
    private ImageView bkg0;
    @FXML
    private ImageView bkg0Right;
    @FXML
    private ImageView bkg1;
    @FXML
    private ImageView bkg1Right;
    @FXML
    private ImageView bkg2;
    @FXML
    private ImageView bkg2Right;
    @FXML
    private ImageView bkg3;
    @FXML
    private ImageView bkg3Right;
    @FXML
    private ImageView bkg4;
    @FXML
    private ImageView bkg4Right;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        applyAnimations();
    }

    @FXML
    private void minimize(ActionEvent event) {
        Button btn = (Button) event.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void exit(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Designs/Menu.fxml"));
            RecursosGlobales.getScene().setRoot(root);
            RecursosGlobales.getStage().sizeToScene();
            RecursosGlobales.getStage().centerOnScreen();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro la url solicitada");
            ex.printStackTrace();
        }
    }

    private void applyAnimations() {
        time0 = new Timeline();
        time0.getKeyFrames().add(new KeyFrame(Duration.millis(75), (event) -> {
            if (bkg0.getLayoutX() > -800) {
                bkg0.setLayoutX(bkg0.getLayoutX() - 1);
                bkg0Right.setLayoutX(bkg0Right.getLayoutX() - 1);
                if (bkg0Right.getLayoutX() < -800) {
                    bkg0Right.setLayoutX(800);
                }
            } else {
                bkg0.setLayoutX(800);
            }
        }));
        time0.setCycleCount(Timeline.INDEFINITE);
        time0.play();
        time1 = new Timeline();
        time1.getKeyFrames().add(new KeyFrame(Duration.millis(50), (event) -> {
            if (bkg1.getLayoutX() > -800) {
                bkg1.setLayoutX(bkg1.getLayoutX() - 1);
                bkg1Right.setLayoutX(bkg1Right.getLayoutX() - 1);
                if (bkg1Right.getLayoutX() < -800) {
                    bkg1Right.setLayoutX(800);
                }
            } else {
                bkg1.setLayoutX(800);
            }
        }));
        time1.setCycleCount(Timeline.INDEFINITE);
        time1.play();
        time2 = new Timeline();
        time2.getKeyFrames().add(new KeyFrame(Duration.millis(40), (event) -> {
            if (bkg2.getLayoutX() > -800) {
                bkg2.setLayoutX(bkg2.getLayoutX() - 1);
                bkg2Right.setLayoutX(bkg2Right.getLayoutX() - 1);
                if (bkg2Right.getLayoutX() < -800) {
                    bkg2Right.setLayoutX(800);
                }
            } else {
                bkg2.setLayoutX(800);
            }
        }));
        time2.setCycleCount(Timeline.INDEFINITE);
        time2.play();
        time3 = new Timeline();
        time3.getKeyFrames().add(new KeyFrame(Duration.millis(30), (event) -> {
            if (bkg3.getLayoutX() > -800) {
                bkg3.setLayoutX(bkg3.getLayoutX() - 1);
                bkg3Right.setLayoutX(bkg3Right.getLayoutX() - 1);
                if (bkg3Right.getLayoutX() < -800) {
                    bkg3Right.setLayoutX(800);
                }
            } else {
                bkg3.setLayoutX(800);
            }
        }));
        time3.setCycleCount(Timeline.INDEFINITE);
        time3.play();
        time4 = new Timeline();
        time4.getKeyFrames().add(new KeyFrame(Duration.millis(20), (event) -> {
            if (bkg4.getLayoutX() > -800) {
                bkg4.setLayoutX(bkg4.getLayoutX() - 1);
                bkg4Right.setLayoutX(bkg4Right.getLayoutX() - 1);
                if (bkg4Right.getLayoutX() < -800) {
                    bkg4Right.setLayoutX(800);
                }
            } else {
                bkg4.setLayoutX(800);
            }
        }));
        time4.setCycleCount(Timeline.INDEFINITE);
        time4.play();
    }

}
