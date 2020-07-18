/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import java.awt.Point;
import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author avile
 */
public class PlayerLife extends AnchorPane {

    private ImageView barraVacia, barrita;
    private double vida;
    
    public PlayerLife(Dimension2D size, Point location, Personaje player) {

        barraVacia = new ImageView(new Image(getClass().getResourceAsStream("/Assets/Imagenes/barraJugador.png")));
        
        this.setPrefSize(size.getWidth(), size.getHeight());
        this.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        this.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);

        this.setLayoutX(location.getX());
        this.setLayoutY(location.getY());

        
        
    }

}
