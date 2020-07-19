package ClasesGlobales;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Zombie extends Personaje {

    protected int frame = 1;
    protected final HBox hBox;
    protected final VBox vBox;
    private AnchorPane anchorPane;

    public Zombie() {
        super("/Assets/Enemigo/walk1.png");
        cargarImagenes();
        hBox = new HBox();
        vBox = new VBox();
        anchorPane = new AnchorPane();
        
        x = 1000;
        y = 550;
        largo = 95;
        alto = 110;

        anchorPane.setId("AnchorPane");
        anchorPane.setLayoutX(x);
        anchorPane.setLayoutY(y);

        AnchorPane.setBottomAnchor(hBox, 0.0);
        AnchorPane.setLeftAnchor(hBox, 0.0);
        AnchorPane.setRightAnchor(hBox, 0.0);
        AnchorPane.setTopAnchor(hBox, 0.0);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setLayoutX(-65.0);
        hBox.setLayoutY(-7.0);

        HBox.setHgrow(vBox, javafx.scene.layout.Priority.ALWAYS);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setMaxHeight(Double.MAX_VALUE);
        vBox.setMaxWidth(Double.MAX_VALUE);

        imageView.setFitHeight(alto);
        imageView.setFitWidth(largo);
        imageView.setPickOnBounds(true);
        imageView.setImage(animaciones.get("WALK1"));

        vBox.getChildren().add(imageView);
        hBox.getChildren().add(vBox);
        anchorPane.getChildren().add(hBox);
    }

    public void movimiento() {
        if (frame > 16) {
            frame = 1;
        }
        imageView.setImage(animaciones.get("WALK" + frame));
        frame++;
    }
    
    public void walking(){
        x -= 2;
        anchorPane.setLayoutX(x);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
    
    
        private void cargarImagenes() {
        for (int i = 1; i <= 16; i++) {
            animaciones.put("WALK" + i, getImagen("/Assets/Enemigo/walk" + i + ".png"));
        }
    }
}
