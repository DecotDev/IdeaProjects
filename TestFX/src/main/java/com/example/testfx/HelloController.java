package com.example.testfx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    private int producedClicks;
    private int clickPowerPrice = 15;
    private int clickPower = 1;
    private int storedClicks;
    private int clickPowerAdd = 1;
    private int clickPerSecond = 1;
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
        clickPowerPrice = (int) (clickPowerPrice * 1.3);
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
        if (!clickPerSecondActive) {
            clickPerSecondActive = true;
            clickThread = new ClickThread(this);
            //clickThread.start();
            Platform.runLater(() -> clickThread.start());
        }
    }
    @FXML
    public void callUpdateLabels() {
        updateClickLabelsGetters();
    }
    @FXML
    public void updateClickLabels() {
        producedClicksLabel.setText("Produced clicks: " + producedClicks);
        clickPowerLabel.setText("Click Power: " + clickPower);
        storedClicksLabel.setText("Stored clicks: " + storedClicks);
        buttonPowerClick.setText("Click Power +" + clickPowerAdd + " (" + clickPowerPrice + "c)");
    }
    @FXML
    public void updateClickLabelsGetters() {

        producedClicksLabel.setText("Produced clicks: " + 3);
        clickPowerLabel.setText("Click Power: " + 3);
        storedClicksLabel.setText("Stored clicks: " + 3);
        buttonPowerClick.setText("Click Power +");

        System.out.println("Working");
    }

    public void initialize() {
        updateClickLabels();

    }
}