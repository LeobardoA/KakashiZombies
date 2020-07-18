/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alex
 */
public abstract class Personaje extends ImageView {

    protected int frame;
    protected SimpleDoubleProperty vida;
    protected double vidaMax;

    public Personaje(String url, double lifeMax, double actualLife) {
        vida = new SimpleDoubleProperty(actualLife);
        frame = 0;
        this.setImage(new Image(getClass().getResource(url).toExternalForm()));
    }

    public abstract void movimiento();

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

    public SimpleDoubleProperty getVidaProperty(){
        return vida;
    }
    
}
