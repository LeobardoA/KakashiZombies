/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Alex
 */
public class Kakashi extends Personaje {

    public final static int STOP = 0;
    public final static int RUN = 1;
    public final static int ATTACK = 2;
    public final static int STAND = 3;

    private HashMap<String, Image> animaciones;

    private Image imagenActual;
    private int movimientoActual;
    private boolean cambiarAnimacion;

    public Kakashi() {
        super("/Assets/imagenes/run (1).png");
        animaciones = new HashMap<>();
        cargarImagenes();
        cambiarAnimacion = true;
        this.setFitWidth(140);
        this.setFitHeight(150);
        this.setLayoutX(50);
        this.setLayoutY(500);
        //this.setPreserveRatio(true);
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
        setImage(imagenActual);
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

    public void moveY(int move) {
        this.setLayoutY(this.getLayoutY() + move);
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
}
