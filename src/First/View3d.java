// package First;

// import java.io.File;
// import javax.imageio.ImageIO;
// import javax.swing.text.View;

// import javafx.application.Application;
// import javafx.geometry.Pos;
// import javafx.scene.*;
// import javafx.scene.control.*;
// import javafx.scene.image.WritableImage;
// import javafx.scene.input.MouseButton;
// import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.*;
// import javafx.stage.*;


// public class View3d extends Application{
//     private BorderPane root;
//     private Pane canvas;


//     public void start(Stage window) {
//         root = new BorderPane();
//         canvas = new Pane();
//         Menu menuFile = new Menu("Файл");
//         MenuItem savMenuItem = new MenuItem("Сохранить");
//         MenuItem exitMenuItem = new MenuItem("Выйти");
//         menuFile.getItems().addAll(savMenuItem, exitMenuItem);
//         MenuBar topMenuBar = new MenuBar();
//         topMenuBar.getMenus().add(menuFile);
//         savMenuItem.setOnAction(event -> {
//             FileChooser fileChooser = new FileChooser();
//             fileChooser.setTitle("Сохранить");
//             fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Png", "*.png"));
//             File file = fileChooser.showSaveDialog(root.getScene().getWindow());
//             if (file != null) {
//                 try {
//                     IOwir
//                 }
//                 catch {
//                 }
//             }
//         });
//         exitMenuItem.setOnAction(event -> {
//             System.exit(0);
//         });
//         root.setTop(topMenuBar);

//         Scene view = new Scene(root,800,600);
//         window.setTitle("3d");
//         window.setScene(view);
//         window.show();
//     }
//     public static void main(String[] args) {
//         launch(View3d.class);
//     }
// }
