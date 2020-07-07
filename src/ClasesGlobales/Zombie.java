/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

/**
 *
 * @author Alex
 */
public class Zombie extends Personaje {

    public Zombie() {
        super("/Assets/Enemigo/walk1.png");
        this.setFitWidth(100);
        //this.setFitHeight(120);
        this.setPreserveRatio(true);
        this.setLayoutX(1000);
        this.setLayoutY(500);
    }

    @Override
    public void movimiento() {
        if (frame > 16) {
            frame = 1;
        }
        changeImage("/Assets/Enemigo/walk"+ frame +".png");
        frame++;
    }

}
