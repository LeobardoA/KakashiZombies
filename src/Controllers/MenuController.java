/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author avile
 */
public class MenuController implements Initializable {

    private Timeline mountineFar, mountineNear, treeFar;
    @FXML
    private ImageView bkg1;
    @FXML
    private ImageView bkg2;
    @FXML
    private ImageView bkg3;
    @FXML
    private ImageView bkg4;
    @FXML
    private ImageView bkg22;
    @FXML
    private ImageView bkg33;
    @FXML
    private ImageView bkg44;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backgroundAnimation();
    }

    @FXML
    private void play(ActionEvent event) throws IOException {
        Button image = (Button) event.getSource();
        image.getScene().getWindow().hide();
        Stage stage = new Stage(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/Designs/Game.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void options(ActionEvent event) throws IOException {
        Button image = (Button) event.getSource();
        image.getScene().getWindow().hide();
        Stage stage = new Stage(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/Designs/SubMenu.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void credits(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    private void backgroundAnimation() {
        mountineFar = new Timeline();
        mountineNear = new Timeline();
        treeFar = new Timeline();

        mountineFar.getKeyFrames().add(new KeyFrame(Duration.millis(30), (event) -> {
            if (bkg2.getLayoutX() >= -799) {

            } else {
                bkg2.setLayoutX(800);
            }
            if (bkg22.getLayoutX() >= -799) {

            } else {
                bkg22.setLayoutX(800);
            }
            bkg2.setLayoutX(bkg2.getLayoutX() - 1);
            bkg22.setLayoutX(bkg22.getLayoutX() - 1);
        }));
        mountineFar.setCycleCount(Timeline.INDEFINITE);
        mountineFar.play();
        mountineNear.getKeyFrames().add(new KeyFrame(Duration.millis(15), (event) -> {
            if (bkg3.getLayoutX() >= -799) {

            } else {
                bkg3.setLayoutX(800);
            }
            if (bkg33.getLayoutX() >= -799) {

            } else {
                bkg33.setLayoutX(800);
            }
            bkg3.setLayoutX(bkg3.getLayoutX() - 1);
            bkg33.setLayoutX(bkg33.getLayoutX() - 1);
        }));
        mountineNear.setCycleCount(Timeline.INDEFINITE);
        mountineNear.play();
        treeFar.getKeyFrames().add(new KeyFrame(Duration.millis(7), (event) -> {
            if (bkg4.getLayoutX() >= -799) {

            } else {
                bkg4.setLayoutX(800);
            }
            if (bkg44.getLayoutX() >= -799) {

            } else {
                bkg44.setLayoutX(800);
            }
            bkg4.setLayoutX(bkg4.getLayoutX() - 1);
            bkg44.setLayoutX(bkg44.getLayoutX() - 1);
        }));
        treeFar.setCycleCount(Timeline.INDEFINITE);
        treeFar.play();
    }

    @FXML
    private void minimize(ActionEvent event) {
        Button btn = (Button) event.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.setIconified(true);
    }

}
