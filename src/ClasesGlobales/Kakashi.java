/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author Alex
 */
public class Kakashi extends Personaje {

    public final static int STOP = 0;
    public final static int RUN = 1;
    public final static int ATTACK = 2;
    public final static int STAND = 3;

    private Timeline powerTimeline, advancePower;
    private AnchorPane padre;
    private ArrayList<ImageView> powerEntity;
    private Image imagenActual;
    private int movimientoActual;
    private boolean cambiarAnimacion;
    private int powerID = 0;

    public Kakashi(double maxLife, double actualLife) {
        super("/Assets/imagenes/run (1).png", maxLife, actualLife);
        powerEntity = new ArrayList<>();
        cargarImagenes();
        cambiarAnimacion = true;
        x = 50;
        y = 500;
        largo = 140;
        alto = 150;
        imageView.setFitWidth(largo);
        imageView.setFitHeight(alto);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setPreserveRatio(true);
    }

    @Override
    public void movimiento() {
        switch (movimientoActual) {
            case RUN:
                if (frame > 7) {
                    frame = 1;
                }
                imagenActual = animaciones.get("RUN" + frame);
                break;
            case ATTACK:
                frame++;
                imagenActual = animaciones.get("ATTACK" + frame);
                if (frame >= 7) {
                    movimientoActual = RUN;
                    resetFrame();
                }
                break;
            case STAND:
                if (frame > 5) {
                    frame = 3;
                }
                imagenActual = animaciones.get("STAND" + frame);
                break;
        }
        imageView.setImage(imagenActual);
        frame++;
    }

    public void down() {
        int limitDown = RecursosGlobales.getHeight();
        if (imageView.getLayoutY() <= limitDown - imageView.getFitHeight()) {
            moveY(2);
        }
    }

    public void up() {
        int limitUp = RecursosGlobales.getLimitUp();
        if (imageView.getLayoutY() >= limitUp) {
            moveY(-2);
        }
    }

    public void moveY(int move) {
        y += move;
        imageView.setLayoutY(y);
    }

    public int getMovimientoActual() {
        return movimientoActual;
    }

    public void setMovimientoActual(int movimientoActual) {
        if (cambiarAnimacion) {
            this.movimientoActual = movimientoActual;
        }
    }

    public boolean isCambiarAnimacion() {
        return cambiarAnimacion;
    }

    public void setCambiarAnimacion(boolean cambiarAnimacion) {
        this.cambiarAnimacion = cambiarAnimacion;
    }

    private void cargarImagenes() {
        for (int i = 1; i <= 7; i++) {
            animaciones.put("RUN" + i, getImagen("/Assets/imagenes/run (" + i + ").png"));
            animaciones.put("ATTACK" + i, getImagen("/Assets/imagenes/attack (" + i + ").png"));
        }
        for (int i = 1; i <= 5; i++) {
            animaciones.put("STAND" + i, getImagen("/Assets/imagenes/stand (" + i + ").png"));
        }
    }

    void shoot() {
        ImageView power = new ImageView();
        padre.getChildren().add(power);
        powerTimeline = new Timeline();
        advancePower = new Timeline();
        powerTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(30), (event) -> {
            if (powerID < 3) {
                power.setImage(new Image(getClass().getResourceAsStream("/Assets/imagenes/shuriken (" + (powerID + 1) + ").png")));
            } else {
                powerID = 0;
            }
            powerID++;
        }));
        powerTimeline.setCycleCount(3);

        advancePower.getKeyFrames().add(new KeyFrame(Duration.millis(5), (event) -> {
            power.setLayoutX(power.getLayoutX() + 1);
        }));
        advancePower.setCycleCount(3000);
        powerEntity.add(power);
        advancePower.setOnFinished((event) -> {
            powerEntity.remove(power);
        });

    }

}
