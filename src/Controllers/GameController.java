/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ClasesGlobales.Kakashi;
import ClasesGlobales.RecursosGlobales;
import ClasesGlobales.Sprite;
import ClasesGlobales.Zombie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Alex
 */
public class GameController implements Initializable {
    private Sprite sprite;
    private Timeline time;
    private Kakashi kakashi;
    private int width, height, cicle;
    private String movKakashi;
    private boolean moveBg;
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
    @FXML
    private ImageView barraVida;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarElementos();
        eventos();
        cicloJuego();
        double tamanio = 800;
        Rectangle2D view = new Rectangle2D(0, 0, tamanio, 192);
        barraVida.setFitWidth((tamanio/1072)*300);
        barraVida.setViewport(view);
    }

    public void eventos() {
        //keyboard listener Pressed
        RecursosGlobales.getScene().setOnKeyPressed((event) -> {
            switch (event.getCode().toString()) {
                case "W":
                    movKakashi = "UP";
                    break;
                case "S":
                    movKakashi = "DOWN";
                    break;
                case "SPACE":

                    break;
                case "ESCAPE":
                    if (moveBg) {
                        moveBg = false;
                        movKakashi = "STAND";
                    } else {
                        moveBg = true;
                        movKakashi = "N";
                    }
                    break;
            }
        });
        //keyboard listener Realeased
        RecursosGlobales.getScene().setOnKeyReleased((event) -> {
            switch (event.getCode().toString()) {
                case "W":
                    movKakashi = "N";
                    break;
                case "S":
                    movKakashi = "N";
                    break;
            }
        });
    }

    public void inicializarElementos() {
        width = 1200;
        height = 720;
        cicle = 0;
        movKakashi = "N";
        moveBg = true;

        kakashi = new Kakashi();
        padre.getChildren().add(kakashi);
        Zombie zombie = new Zombie();
        padre.getChildren().add(zombie);
    }

    //tiempo juego
    public void cicloJuego() {
        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                moverFondo();
                movimientoKakashi();
                //kakashi
                if (cicle % 4 == 0 && !movKakashi.equals("STAND")) {
                    kakashi.movimiento();
                } else if (cicle % 4 == 0) {
                    kakashi.attack();
                }

                //Enemy
                if (cicle % 10 == 0) {

                }
//                kakashi.getBoundsInLocal().intersects(zombie.imageView.getBoundsInLocal());
                cicle++;
            }
        }));
        time.play();
    }

    public void movimientoKakashi() {

        switch (movKakashi) {
            case "UP":
                kakashi.up();
                break;
            case "DOWN":
                kakashi.down();
                break;
        }
    }

    public void moverFondo() {
        //bg 3 in sky
        if (moveBg) {
            bg3_1.setLayoutX(bg3_1.getLayoutX() - 1);
            bg3_2.setLayoutX(bg3_2.getLayoutX() - 1);
            if (bg3_1.getLayoutX() <= -width) {
                bg3_1.setLayoutX(width);
            }
            if (bg3_2.getLayoutX() <= -width) {
                bg3_2.setLayoutX(width);
            }

            //bg 2 in middle
            bg2_1.setLayoutX(bg2_1.getLayoutX() - 1.5);
            bg2_2.setLayoutX(bg2_2.getLayoutX() - 1.5);
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

}
