/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import java.util.HashMap;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alex
 */
public abstract class Personaje {

    protected int frame;
    protected SimpleDoubleProperty vida;
    protected double vidaMax;
    protected ImageView imageView;
    protected HashMap<String, Image> animaciones;
    protected int x;
    protected int y;
    protected int largo;
    protected int alto;

    public Personaje(String url, double lifeMax, double actualLife) {
        imageView = new ImageView();
        vida = new SimpleDoubleProperty(actualLife);
        frame = 0;
        imageView.setImage(new Image(getClass().getResource(url).toExternalForm()));
        animaciones = new HashMap<>();
    }

    public Personaje(String url) {
        imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResource(url).toExternalForm()));
        animaciones = new HashMap<>();
    }

    public abstract void movimiento();

    public ImageView getImageView() {
        return imageView;
    }

    public Image getImagen(String url) {
        return new Image(getClass().getResource(url).toExternalForm());
    }

    public void resetFrame() {
        frame = 0;
    }

    public void setVida(double life) {
        this.vida.set(life);
    }

    public double getVida() {
        return vida.getValue();
    }

    public double getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(double vidaMax) {
        this.vidaMax = vidaMax;
    }

    public SimpleDoubleProperty getVidaProperty() {
        return vida;
    }

    public boolean isColition(Personaje p2) {

        int[] x1 = {this.x, this.x + this.largo};
        int[] y1 = {this.y, this.y + this.alto};

        int[] x2 = {p2.x, p2.x + p2.largo};
        int[] y2 = {p2.y, p2.y + p2.alto};

        //p1
        for (int ix = 0; ix < 2; ix++) {
            for (int iy = 0; iy < 2; iy++) {
                //validacion en x
                if (x1[ix] >= x2[0] && x1[ix] <= x2[1]) {
                    //validacion en y
                    if (y1[iy] >= y2[0] && y1[ix] <= y2[1]) {
                        return true;//hay colision
                    }
                }
            }
        }

        //p2
        for (int ix = 0; ix < 2; ix++) {
            for (int iy = 0; iy < 2; iy++) {
                //validacion en x
                if (x2[ix] >= x1[0] && x2[ix] <= x1[1]) {
                    //validacion en y
                    if (y2[iy] >= y1[0] && y2[ix] <= y1[1]) {
                        return true;//hay colision
                    }
                }
            }
        }

        return false;
    }

}
