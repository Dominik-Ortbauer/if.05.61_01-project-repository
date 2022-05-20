package at.htlleonding.controller;

import at.htlleonding.App;
import at.htlleonding.pansim.Event;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

import java.util.List;

public class PrimaryViewController {
    @FXML
    AreaChart<Integer, Integer> chart;

    @FXML
    ScrollPane scrollPane;

    @FXML
    ListView<Label> listView;

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

    public void setEventTextArea(List<Event> events) {
        listView.getItems().clear();
        for(Event v : events) {
            Label label = new Label();
            label.setText(v.toString());
            listView.getItems().add(label);
        }
    }
}
