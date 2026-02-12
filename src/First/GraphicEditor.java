package First;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.*;

public class GraphicEditor extends Application{
    private BorderPane root;
    private Pane canvas;
    private Shape selectedShape;
    private ToggleGroup toggleGroup;
    @Override
    public void start(Stage window) {
        root = new BorderPane();
        canvas = new Pane();
        toggleGroup = new ToggleGroup();
        root.setCenter(canvas);

        VBox leftPanel = new VBox(10);
        leftPanel.setPrefWidth(120);
        leftPanel.setStyle("-fx-padding: 10; -fx-background-color: white;");
        leftPanel.setAlignment(Pos.TOP_CENTER);

        Label strokeColorLabel = new Label("Цвет Контура");
        Label fillColorLabel = new Label("Цвет Заливки");
        Label strokeThiknesLabel = new Label("Толщина");
        Label lineTypeLabel = new Label("Тип");
        Label imageSizeWidthLabel = new Label("Ширина");
        Label imageSizeHeightLable = new Label("Высота");
        Line lineIcon = new Line(0,0,15,15);
        Circle circleIcon = new Circle(8);
        Ellipse ellipseIcon = new Ellipse(10,6);
        Rectangle rectangleIcon = new Rectangle(15,12);
        ToggleButton LineBut = creaIconButton(toggleGroup, lineIcon);
        ToggleButton CircleBut = creaIconButton(toggleGroup, circleIcon);
        ToggleButton EllipseBut = creaIconButton(toggleGroup, ellipseIcon);
        ToggleButton RectangleBut = creaIconButton(toggleGroup, rectangleIcon);
        leftPanel.getChildren().addAll(LineBut, CircleBut, EllipseBut, RectangleBut);

        TitledPane palletePane = new TitledPane("Палитра", leftPanel);
        palletePane.setCollapsible(false);

        ComboBox<String> strokeColor = new ComboBox<>();
        strokeColor.getItems().addAll("Black","Red","Green","Blue");
        strokeColor.setValue("Black");

        ComboBox<String> fillColor = new ComboBox<>();
        fillColor.getItems().addAll("White","Transparent", "Red", "Green", "Blue");
        fillColor.setValue("White");

        GridPane colorsGrid = new GridPane();
        colorsGrid.setHgap(8);
        colorsGrid.setVgap(8);
        colorsGrid.addRow(0, strokeColorLabel, strokeColor);
        colorsGrid.addRow(1, fillColorLabel, fillColor);

        TitledPane colorsPane = new TitledPane("Цвета", colorsGrid);
        colorsPane.setCollapsible(false);
        colorsPane.setMaxWidth(Double.MAX_VALUE);

        TextField thinesField = new TextField("1.0");
        thinesField.setPrefColumnCount(5);

        ComboBox<String> lineType = new ComboBox<>();
        lineType.getItems().addAll("Solid", "Dash", "Dot");
        lineType.setValue("Solid");

        GridPane strokeGrid = new GridPane();
        strokeGrid.setHgap(8);
        strokeGrid.setVgap(8);
        strokeGrid.addRow(0, strokeThiknesLabel, thinesField);
        strokeGrid.addRow(1, lineTypeLabel, lineType);

        TitledPane strokePane = new TitledPane("Контур", strokeGrid);
        strokePane.setCollapsible(false);
        strokePane.setMaxWidth(Double.MAX_VALUE);

        TextField imageSizeWidth = new TextField();
        imageSizeWidth.setPrefColumnCount(5);

        TextField imageSizeHeight = new TextField();
        imageSizeHeight.setPrefColumnCount(5);

        GridPane imageSize = new GridPane();
        imageSize.setHgap(8);
        imageSize.setVgap(8);
        imageSize.addRow(0, imageSizeHeightLable, imageSizeHeight);
        imageSize.addRow(1, imageSizeWidthLabel, imageSizeWidth);

        TitledPane imageSizePane = new TitledPane("Размер", imageSize);
        imageSizePane.setCollapsible(false);
        imageSizePane.setMaxWidth(Double.MAX_VALUE);

        VBox leftCol = new VBox(); 
        leftCol.getChildren().addAll(palletePane);

        VBox rightCol = new VBox();
        rightCol.getChildren().addAll(colorsPane, strokePane, imageSizePane);
        rightCol.setFillWidth(true);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(leftCol,rightCol);
        hBox.setAlignment(Pos.TOP_CENTER);
        
        VBox sidebar = new VBox(hBox);
        sidebar.setStyle("-fx-padding: 10; -fx-background-color: #f5f5f5;");
        root.setRight(sidebar);

        canvas.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                Toggle selected = toggleGroup.getSelectedToggle();
                Shape newShape = createShape(event.getX(), event.getY());

                if (selected != null) {
                    canvas.getChildren().add(newShape);
                }
                if (selected == null) {
                    return;
                }
            }
        });

        Scene view = new Scene(root, 800, 400);
        window.setTitle("Graphic Editor");
        window.setScene(view);
        window.show();
    }

    private ToggleButton creaIconButton(ToggleGroup group, Shape shape) {
        ToggleButton toggleButton = new ToggleButton();
        toggleButton.setToggleGroup(group);
        shape.setFill(Color.TRANSPARENT);
        shape.setStroke(Color.BLACK);
        shape.setStrokeWidth(2);
        toggleButton.setGraphic(shape);
        toggleButton.setPrefHeight(50);
        toggleButton.setAlignment(Pos.CENTER_LEFT);
        toggleButton.setGraphicTextGap(10);
        return toggleButton;
    }
    private Shape createShape(double x, double y) {
        Toggle selected = toggleGroup.getSelectedToggle();
        Shape shape = null;
        if (selected == null) {
            return null;
        }
        if(selected == LineBut) {
            Line line = new Line(x,y,x+50,y+50);
            shape = line;
        }
        if (selected == CircleBut) {
            Circle circle = new Circle(x,y,30);
            shape = circle;
        }
        if (selected == EllipseBut) {
            Ellipse ellipse = new Ellipse(x,y,40,25);
            shape = ellipse;
        }
        if (selected == RectangleBut) {
            Rectangle rectangle = new Rectangle(x,y,80,50);
            shape = rectangle;
        }
        if (shape != null) {
            shape.setStroke(Color.BLACK);
            shape.setStrokeWidth(1.0);
            if (!(shape instanceof Line)) {
                shape.setFill(Color.WHITE);
            }
            shape.getStrokeDashArray().clear();
        }
    }

    public static void main(String[] args) {
        launch(GraphicEditor.class);
    }
}
