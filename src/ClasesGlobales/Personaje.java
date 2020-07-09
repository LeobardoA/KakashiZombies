/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alex
 */
public abstract class Personaje extends ImageView {
    protected int frame;

    public Personaje(String url) {
        frame = 1;
        changeImage(url);
    }
    
    public abstract void movimiento();
    
    protected void changeImage(String url){
        this.setImage(new Image(getClass().getResource(url).toExternalForm()));  
    }
    
    public void resetFrame(){
        frame = 1;
    }
}
