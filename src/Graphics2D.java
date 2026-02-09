package First;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.*;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

public class Graphics2D extends Application{
    public final double WIDTH = 800;
    public final double HEIGHT = 600;
    Random random = new Random();
    enum ShapeType {
        RECTANGLE, CIRCLE, ELLIPSE, TRIANGLE
    }

    @Override
    public void start(Stage window) {
        Group root = new Group();
        Shape randomShape = createRandomShape();
        randomShape.setLayoutX(WIDTH/2 - 100);
        randomShape.setLayoutY(HEIGHT/2 - 100);
        root.getChildren().add(randomShape);

        Scene view = new Scene(root,WIDTH,HEIGHT);
        window.setTitle("Second Task");
        window.setScene(view);
        window.show();
    }

    private Shape createRandomShape() {
        int type = random.nextInt(4);
        Shape shape;
        switch (type) {
            case 0 -> {
                Rectangle rectangle = new Rectangle(200,200);
                shape = rectangle;
            }
            case 1 -> {
                Circle circle = new Circle(100);
                shape = circle;
            }
            case 2 -> {
                Ellipse ellipse = new Ellipse(150,100);
                shape = ellipse;
            }
            
            default -> throw new IllegalStateException();
        }
        shape.setFill(Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble()));
        shape.setStroke(Color.BLACK);
        shape.setStrokeWidth(10);

        return shape;
    }
    public static void main(String[] args) {
        launch(Graphics2D.class);
    }

}
