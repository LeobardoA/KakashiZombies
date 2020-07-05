/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author avile
 */
public class RecursosGlobales {

    private static Scene scene;
    private static Stage stage;

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        RecursosGlobales.scene = scene;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        RecursosGlobales.stage = stage;
    }

}
