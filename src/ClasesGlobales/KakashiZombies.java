/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author avile
 */
public class KakashiZombies extends Application {

    public static ObjectProperty<EventHandler<? super KeyEvent>> listener;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/Designs/Menu.fxml"));
        Scene scene = new Scene(root);

        RecursosGlobales.setScene(scene);
        primaryStage.setScene(scene);
        RecursosGlobales.setStage(primaryStage);
        listener = scene.onKeyPressedProperty();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

}
