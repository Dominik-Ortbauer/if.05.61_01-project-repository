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

    public XYChart.Series<Integer, Integer> infectedChart = new XYChart.Series<>();

    public XYChart.Series<Integer, Integer> recoveredChart = new XYChart.Series<>();

    @FXML
    public void initialize() {
        App.primaryViewController = this;

        suseptableChart.setName("Suseptable");
        infectedChart.setName("Infected");
        recoveredChart.setName("Recovered");

        chart.getData().add(suseptableChart);
        chart.getData().add(infectedChart);
        chart.getData().add(recoveredChart);

        chart.setTitle("People");
    }
}
