package at.htlleonding.controller;

import at.htlleonding.App;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class PrimaryViewController {
    @FXML
    AreaChart<Integer, Integer> chart;

    public XYChart.Series<Integer, Integer> suseptableChart = new XYChart.Series<>();

    @FXML
    public void initialize() {
        App.primaryViewController = this;
        chart.getData().add(suseptableChart);
    }
}
