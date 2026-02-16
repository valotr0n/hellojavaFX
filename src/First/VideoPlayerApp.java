package First;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.text.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.*;
import javafx.scene.media.*;

public class VideoPlayerApp extends Application{
    private BorderPane root;
    private HBox mediaBarHbox;

    @Override
    public void start(Stage window) {
        root = new BorderPane();

        Menu menuFile = new Menu();
        MenuItem saveItem = new MenuItem("Сохранить");
        MenuItem exitItem = new MenuItem("Выйти");
        menuFile.getItems().addAll(saveItem, exitItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menuFile);

        String videoPath = "C:/videos/test.mp4";
        Media media = new Media(new File(videoPath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.play();

        mediaBarHbox = new HBox();
        mediaBarHbox.setSpacing(10);
        mediaBarHbox.setAlignment(Pos.CENTER);
        Button startButton = new Button("||");
        Slider time = new Slider();
        Slider vol = new Slider();
        vol.setMin(0);
        vol.setMax(1);
        vol.setValue(0.5);
        Label volumeLabel = new Label("Volume: ");
        mediaBarHbox.getChildren().addAll(startButton,time,volumeLabel,vol);
        startButton.setOnAction(event -> {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                startButton.setText(">");
            }
            else {
                mediaPlayer.play();
                startButton.setText("||");
            }
        });

        root.setBottom(mediaBarHbox);
        root.setCenter(mediaView);
        root.setTop(menuBar);

        Scene view = new Scene(root,800,600);
        window.setTitle("Media Player");
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
