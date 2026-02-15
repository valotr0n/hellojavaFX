package First.ChartsSceneBuilder;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class Controller {
    @FXML
    private TextField xMinField;

    @FXML
    private TextField xMaxField;

    @FXML
    private TextField stepField;

    @FXML
    private LineChart<Number, Number> chart;

    @FXML
    private void buildChart() {
        double xMin = Double.parseDouble(xMinField.getText());
        double xMax = Double.parseDouble(xMaxField.getText());
        double step = Double.parseDouble(stepField.getText());

        chart.getData().clear();

        XYChart.Series<Number, Number> series = new XYChart.Series<>(); 
        for (double x = xMin; x <= xMax; x += step) {
            double y = Math.sin(x);
            series.getData().add(new XYChart.Data<>(x,y));
        }
        chart.getData().add(series);
    }
}