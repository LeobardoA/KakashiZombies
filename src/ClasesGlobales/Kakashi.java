/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import javafx.scene.image.Image;

/**
 *
 * @author Alex
 */
public class Kakashi extends Personaje {

    private final Image[] run = {
        new Image(getClass().getResource("/Assets/imagenes/run (1).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/run (2).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/run (3).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/run (4).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/run (5).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/run (6).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/run (7).png").toExternalForm())
    };

    private final Image[] attack = {
        new Image(getClass().getResource("/Assets/imagenes/attack (1).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/attack (2).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/attack (3).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/attack (4).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/attack (5).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/attack (6).png").toExternalForm()),
        new Image(getClass().getResource("/Assets/imagenes/attack (7).png").toExternalForm())
    };

    public Kakashi() {
        super("/Assets/imagenes/run (1).png");

        this.setFitWidth(140);
        this.setFitHeight(150);
        this.setLayoutX(50);
        this.setLayoutY(500);
        //this.setPreserveRatio(true);
    }

    @Override
    public void movimiento() {
        if (frame > 6) {
            frame = 0;
        }
        setImage(run[frame]);
        frame++;
    }

    public void stand() {
        if (frame > 5) {
            frame = 3;
        }
        changeImage("/Assets/imagenes/stand (" + frame + ").png");
        frame++;
    }

    public void down() {
        int limitDown = RecursosGlobales.getHeight();
        if (this.getLayoutY() <= limitDown - this.getFitHeight()) {
            moveY(2);
        }
    }

    public void up() {
        int limitUp = RecursosGlobales.getLimitUp();
        if (this.getLayoutY() >= limitUp) {
            moveY(-2);
        }
    }

    public void attack() {
        if (frame < 6) {
            setImage(attack[frame]);
            frame++;
        }
        else{
            frame = 0;
            this.movimiento();
        }

    }

    public void moveY(int move) {
        this.setLayoutY(this.getLayoutY() + move);
    }

}
