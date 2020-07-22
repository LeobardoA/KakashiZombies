package ClasesGlobales;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author avile
 */
public class NewClass {

    private ArrayList<ImageView> powerEntity;
    private AnchorPane pane;
    private ImageView image;
    private Timeline walkRight, attackRight, goDown, goUp, powerTimeline, advancePower;
    private Image[] imgWalkRight, imgAttackRight, imgPower;
    private byte walkRightID = 0, attackRightID = 0, powerID = 0;

    private NewClass() {
    }

    public NewClass(ImageView image, AnchorPane pane) {
        powerEntity = new ArrayList<>();
        this.image = image;
        this.pane = pane;
        walkRight = new Timeline();
        attackRight = new Timeline();
        goDown = new Timeline();
        goUp = new Timeline();

        imgAttackRight = new Image[6];
        imgWalkRight = new Image[2];
        imgPower = new Image[5];

        for (int i = 0; i < 2; i++) {
            imgWalkRight[i] = new Image(getClass().getResource("/Recursos/witch/flying/flying0" + i + ".png").toExternalForm());
        }
        for (int i = 0; i < 6; i++) {
            imgAttackRight[i] = new Image(getClass().getResource("/Recursos/witch/attack/attack0" + i + ".png").toExternalForm());
        }
        for (int i = 0; i < 5; i++) {
            imgPower[i] = new Image(getClass().getResource("/Recursos/witch/Hadooken/atk0" + i + ".png").toExternalForm());
        }
        prepareAnimations();
    }

    public void walkRightPlay() {
        stopAnimations();
        walkRight.play();
    }

    public void attackRightPlay() {
        stopAnimations();
        attackRight.play();
    }

    private void stopAnimations() {
        walkRight.pause();
        attackRight.stop();
    }

    private void prepareAnimations() {
        attackRight.getKeyFrames().add(new KeyFrame(Duration.millis(100), (event) -> {
            if (attackRightID < 6) {
                image.setFitWidth(imgAttackRight[attackRightID].getWidth());
                image.setFitHeight(imgAttackRight[attackRightID].getHeight());
                image.setImage(imgAttackRight[attackRightID]);
            } else {
                attackRightID = 0;
            }
            attackRightID++;
        }));
        attackRight.setCycleCount(6);

        walkRight.getKeyFrames().add(new KeyFrame(Duration.millis(6), (event) -> {
            if (walkRightID < 2) {
                image.setFitWidth(imgWalkRight[walkRightID].getWidth());
                image.setFitHeight(imgWalkRight[walkRightID].getHeight());
                image.setImage(imgWalkRight[walkRightID]);
                walkRightID++;
            } else {
                walkRightID = 0;
            }
        }));
        walkRight.setCycleCount(Timeline.INDEFINITE);

        goDown.getKeyFrames().add(new KeyFrame(Duration.millis(10), (event) -> {
            image.setLayoutY(image.getLayoutY() + 1);
        }));
        goDown.setCycleCount(3000);

        goUp.getKeyFrames().add(new KeyFrame(Duration.millis(10), (event) -> {
            image.setLayoutY(image.getLayoutY() - 1);
        }));
        goUp.setCycleCount(3000);
    }

    public Timeline getAttackRight() {
        return attackRight;
    }

    void goDownPlay() {
        goDown.play();
    }

    void goUpPlay() {
        goUp.play();
    }

    void goDownPause() {
        goDown.stop();
    }

    void goUpPause() {
        goUp.stop();
    }

    void powerPlay() {
        shoot();
        powerTimeline.play();
    }

    void advancePowerPlay() {
        advancePower.play();
    }

    void advancePowerPause() {
        advancePower.stop();
    }

    void shoot() {
        ImageView power = new ImageView();
        pane.getChildren().add(power);
        powerTimeline = new Timeline();
        advancePower = new Timeline();
        powerTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), (event) -> {
            if (powerID < 5) {
                power.setFitWidth(imgPower[powerID].getWidth());
                power.setFitHeight(imgPower[powerID].getHeight());
                power.setLayoutX(image.getLayoutX() + image.getFitWidth());
                power.setLayoutY(image.getLayoutY() + 5);
                power.setImage(imgPower[powerID]);
            } else {
                powerID = 0;
            }
            powerID++;
        }));
        powerTimeline.setCycleCount(5);

        advancePower.getKeyFrames().add(new KeyFrame(Duration.millis(5), (event) -> {
            power.setLayoutX(power.getLayoutX() + 1);
        }));
        advancePower.setCycleCount(3000);
        powerEntity.add(power);
        advancePower.setOnFinished((event) -> {
            powerEntity.remove(power);
        });

    }

    public ImageView getImage() {
        return image;
    }
    
    public ArrayList<ImageView> getPowerEntity() {
        return powerEntity;
    }
    
}