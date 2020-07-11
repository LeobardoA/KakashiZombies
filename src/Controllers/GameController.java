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
    private int width, height, ciclo;
    private String key;
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
        sprite = new Sprite(barraVida, 100, Duration.millis(50));
        sprite.playContinuously();
    }

    public void eventos() {
        //keyboard listener Pressed
        RecursosGlobales.getScene().setOnKeyPressed((event) -> {
            switch (event.getCode().toString()) {
                case "W":
                    key = "UP";
                    break;
                case "S":
                    key = "DOWN";
                    break;
                case "SPACE":
                    kakashi.resetFrame();
                    kakashi.setMovimientoActual(Kakashi.ATTACK);

                    break;
                case "ESCAPE":

                    if (moveBg) {
                        moveBg = false;
                        kakashi.resetFrame();
                        kakashi.setMovimientoActual(Kakashi.STAND);
                        kakashi.setCambiarAnimacion(false);
                    } else {
                        moveBg = true;
                        kakashi.setCambiarAnimacion(true);
                        kakashi.resetFrame();
                        kakashi.setMovimientoActual(Kakashi.RUN);
                        
                    }
                    break;
            }
        });
        //keyboard listener Realeased
        RecursosGlobales.getScene().setOnKeyReleased((event) -> {
            switch (event.getCode().toString()) {
                case "W":
                    key = "N";
                    break;
                case "S":
                    key = "N";
                    break;
            }
        });
    }

    public void inicializarElementos() {
        width = 1200;
        height = 720;
        ciclo = 0;
        key = "N";
        moveBg = true;

        kakashi = new Kakashi();
        kakashi.setMovimientoActual(Kakashi.RUN);
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
//                kakashi.getBoundsInLocal().intersects(zombie.imageView.getBoundsInLocal());
                ciclo++;
            }
        }));
        time.play();
    }

    public void movimientoKakashi() {
        if (key.equals("UP")) {
            kakashi.up();
        } else if (key.equals("DOWN")) {
            kakashi.down();
        }
        if (ciclo % 5 == 0) {
            kakashi.movimiento();
        } else if (ciclo % 4 == 0) {
            
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
