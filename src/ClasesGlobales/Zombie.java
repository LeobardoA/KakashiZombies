package ClasesGlobales;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Zombie extends AnchorPane {

    protected int frame = 1;
    protected final HBox hBox;
    protected final VBox vBox;
    protected final ImageView imageView;

    public Zombie() {

        hBox = new HBox();
        vBox = new VBox();
        imageView = new ImageView();

        setId("AnchorPane");
        setPrefHeight(100.0);
        setPrefWidth(100.0);

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

        imageView.setFitHeight(75.0);
        imageView.setFitWidth(75.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResourceAsStream("/Assets/Enemigo/walk1.png")));

        vBox.getChildren().add(imageView);
        hBox.getChildren().add(vBox);
        getChildren().add(hBox);
    }

    public void movimiento() {
        if (frame > 16) {
            frame = 1;
        }
        imageView.setImage(new Image(getClass().getResourceAsStream("/Assets/Enemigo/walk" + frame + ".png")));
        frame++;
    }
}
