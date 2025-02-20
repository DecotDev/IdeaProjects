package com.example.testfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    public Button buttonClicker;
    public Button buttonActivate;
    public Button buttonPowerClick;
    public Button buttonStoreClicks;
    public Label clickPowerLabel;
    public Label clickSecondLabel;
    public Label storedClicksLabel;

    private int producedClicks;
    private int clickPowerPrice = 15;
    private int clickPower = 1;
    private int storedClicks;
    private int clickPowerAdd = 1;
    private int clickPerSecond = 1;

    ClickThread clickThread = new ClickThread(this);

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


    public void onPowerClickButtonClick() {
        if (storedClicks < clickPowerPrice) return;
        clickPower = clickPower + clickPowerAdd;
        storedClicks = storedClicks - clickPowerPrice;
        clickPowerPrice = (int) (clickPowerPrice * 1.3);
        updateClickLabels();
    }

    public void onStoreClicksButtonClick() {
        storedClicks = storedClicks + producedClicks;
        producedClicks = 0;
        updateClickLabels();
    }

    public void updateClickLabels() {
        producedClicksLabel.setText("Produced clicks: " + producedClicks);
        clickPowerLabel.setText("Click Power: " + clickPower);
        storedClicksLabel.setText("Stored clicks: " + storedClicks);
        buttonPowerClick.setText("Click Power +" + clickPowerAdd + " (" + clickPowerPrice + "c)");
    }
    public void initialize() {
        updateClickLabels();
        clickThread.start();
    }
}