package com.example.testfx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class HelloController {

    @FXML
    private Button buttonClicker;
    @FXML
    private Button buttonPowerClick;
    @FXML
    private Button buttonStoreClicks;
    @FXML
    private Label clickPowerLabel;
    @FXML
    private Label clickSecondLabel;
    @FXML
    private Label storedClicksLabel;
    @FXML
    private Button buttonClicksPerSecond;

    private int producedClicks;
    private int clickPowerPrice = 15;
    private int clickPower = 1;
    private int storedClicks;
    private int clickPowerAdd = 1;
    private int clickPerSecond = 0;
    private int clickPerSecondPrice = 30;
    private int clickPerSecondAdd = 1;
    private boolean clickPerSecondActive = false;

    ClickThread clickThread;

    public int getClickPerSecond() {
        return clickPerSecond;
    }

    public void setClickPerSecond(int clickPerSecond) {
        this.clickPerSecond = clickPerSecond;
    }

    public int getProducedClicks() {
        return producedClicks;
    }

    public void setProducedClicks(int producedClicks) {
        this.producedClicks = producedClicks;
    }

    public HelloController() {

    }

    @FXML
    public Label producedClicksLabel;

    @FXML
    protected void onClickerButtonClick() {
        producedClicks += clickPower;
        updateClickLabels();
    }


    @FXML
    public void onPowerClickButtonClick() {
        if (storedClicks < clickPowerPrice) return;
        clickPower = clickPower + clickPowerAdd;
        storedClicks = storedClicks - clickPowerPrice;
        clickPowerPrice = (int) (clickPowerPrice * 1.25);
        updateClickLabels();
    }

    @FXML
    public void onStoreClicksButtonClick() {
        storedClicks = storedClicks + producedClicks;
        producedClicks = 0;
        updateClickLabels();
    }

    @FXML
    public void onClicksPerSecondClick() {
        if (storedClicks < clickPerSecondPrice) return;
        if (!clickPerSecondActive) {
            clickPerSecondActive = true;
            clickThread = new ClickThread(this);
            //clickThread.start();
            Platform.runLater(() -> clickThread.start());
        }
        clickPerSecond = clickPerSecond + clickPerSecondAdd;
        storedClicks = storedClicks - clickPerSecondPrice;
        clickPerSecondPrice = (int) (clickPerSecondPrice * 1.16);
        updateClickLabels();

    }

    @FXML
    public void callUpdateLabels() {
        updateClickLabels();
    }

    @FXML
    public void updateClickLabels() {

        List<Label> labels = List.of(producedClicksLabel, clickPowerLabel, storedClicksLabel);
        List<String> values = List.of("Produced clicks: " + producedClicks, "Click Power: " + clickPower, "Stored clicks: " + storedClicks);
        labels.forEach(label -> label.setText(values.get(labels.indexOf(label))));

        //producedClicksLabel.setText("Produced clicks: " + producedClicks);
        //clickPowerLabel.setText("Click Power: " + clickPower);
        //storedClicksLabel.setText("Stored clicks: " + storedClicks);
        buttonPowerClick.setText("Click Power +" + clickPowerAdd + " (" + clickPowerPrice + "c)");
        clickSecondLabel.setText("Clicks every second: " + clickPerSecond);
        buttonClicksPerSecond.setText("Click Power +" + clickPerSecondAdd + " (" + clickPerSecondPrice + "c)");
    }

    public void initialize() {
        updateClickLabels();

    }
}