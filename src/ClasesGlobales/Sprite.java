/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGlobales;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author avile
 */
public class Sprite{
    private final Rectangle2D[] cellClips;
    private int numCells;
    private final Timeline timeline;
    private final IntegerProperty frameCounter = new SimpleIntegerProperty(0);
    private ImageView container;
    public Sprite(ImageView container, int numCells, Duration frameTime) {
        this.numCells = numCells;
        this.container = container;
        Image animationImage = container.getImage();
        
        double cellWidth  = animationImage.getWidth() / numCells;
        double cellHeight = animationImage.getHeight();

        cellClips = new Rectangle2D[numCells];
        for (int i = 0; i < numCells; i++) {
            cellClips[i] = new Rectangle2D(
                    i * cellWidth, 0,
                    cellWidth, cellHeight
            );
        }

        container.setImage(animationImage);
        container.setViewport(cellClips[0]);
        System.out.println(cellClips[0]);

        timeline = new Timeline(
                new KeyFrame(frameTime, event -> {
                    frameCounter.set((frameCounter.get() + 1) % numCells);
                    container.setViewport(cellClips[frameCounter.get()]);
                })
        );
    }

    public void playOnce() {
        frameCounter.set(0);
        timeline.setCycleCount(numCells);
        timeline.stop();
        timeline.playFromStart();
    }

    public void playContinuously() {
        frameCounter.set(0);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.stop();
        timeline.playFromStart();
    }

    public void stop() {
        frameCounter.set(0);
        container.setViewport(cellClips[frameCounter.get()]);
        timeline.stop();
    }
}