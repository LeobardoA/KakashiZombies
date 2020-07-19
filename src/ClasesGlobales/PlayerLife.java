/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import java.awt.Point;
import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author avile
 */
public class PlayerLife extends AnchorPane {

    private ImageView barraVacia, barrita;
    private Label vidaLabel;
    private double vida;

    public PlayerLife(Dimension2D size, Point location, Personaje player) {

        barraVacia = new ImageView(new Image(getClass().getResourceAsStream("/Assets/imagenes/barraJugador.png")));
        barrita = new ImageView(new Image(getClass().getResourceAsStream("/Assets/imagenes/barraVida.png")));
        vidaLabel = new Label("HP: 1000/1000");

        this.setPrefSize(size.getWidth(), size.getHeight());
        this.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        this.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);

        this.setLayoutX(location.getX());
        this.setLayoutY(location.getY());

        barraVacia.setFitWidth(size.getWidth());
        barraVacia.setPreserveRatio(true);
        barrita.setFitWidth(size.getWidth()*0.8955223880597015);
        barrita.setPreserveRatio(true);
        AnchorPane.setLeftAnchor(barrita, 31.0);

        vidaLabel.setPrefWidth(150);
        vidaLabel.setLayoutX((barrita.getFitWidth() / 2) - (vidaLabel.getPrefWidth() / 2));
        vidaLabel.setLayoutY(10);
        vidaLabel.setFont(Font.loadFont(getClass().getResourceAsStream("/Misc/Minecraft-Regular.otf"), 20));
        vidaLabel.setTextFill(Color.WHITE);

        player.getVidaProperty().addListener((observable, oldValue, newValue) -> {
            vidaLabel.setText("HP: "+(int)player.getVida()+"/1000");
            setVida(player.getVida());
        });

        this.getChildren().add(barraVacia);
        this.getChildren().add(barrita);
        this.getChildren().add(vidaLabel);
    }

    public void setVida(double life) {
        double vida = 960 * (life/1000);
        Rectangle2D view = new Rectangle2D(0, 0, vida, 192);
        barrita.setFitWidth((vida / 1072) * barraVacia.getFitWidth());
        barrita.setViewport(view);
        
    }

}
