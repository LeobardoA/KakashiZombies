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

    public final static int STOP = 0;
    public final static int RUN = 1;
    public final static int ATTACK = 2;
    public final static int STAND = 3;

    

    private Image imagenActual;
    private int movimientoActual;
    private boolean cambiarAnimacion;

    public Kakashi(double maxLife, double actualLife) {
        super("/Assets/imagenes/run (1).png", maxLife, actualLife);
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

}
