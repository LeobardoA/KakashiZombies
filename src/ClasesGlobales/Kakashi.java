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
public class Kakashi extends Personaje{

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
        if(frame > 8){
            frame = 1;
        }
        changeImage("/Assets/imagenes/run ("+ frame +").png");
        frame++;
    }
    
    public void down(){
        int limitDown = RecursosGlobales.getHeight();
        if (this.getLayoutY() <= limitDown - this.getFitHeight()) {
            this.setLayoutY(this.getLayoutY() + 2);
        }   
    }

    public void up(){
        int limitUp = RecursosGlobales.getLimitUp();
        if (this.getLayoutY() >= limitUp) {
            this.setLayoutY(this.getLayoutY() - 2);
        }   
    }
    
}
