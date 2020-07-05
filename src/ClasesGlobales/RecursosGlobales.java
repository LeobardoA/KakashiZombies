/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author avile
 */
public class RecursosGlobales {

    private static Scene scene;
    private static Stage stage;
    private static String code;

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        RecursosGlobales.scene = scene;
        scene.setOnKeyPressed((event) -> {
            code = event.getCharacter();
            System.out.println(code);
        });
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        RecursosGlobales.stage = stage;
    }

    
}
