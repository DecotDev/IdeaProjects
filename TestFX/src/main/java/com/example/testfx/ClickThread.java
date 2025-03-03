package com.example.testfx;

import javafx.application.Platform;

public class ClickThread extends Thread {

    HelloController helloController;

    public ClickThread(HelloController helloController) {
        this.helloController = helloController;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);

                // Update produced clicks
                Platform.runLater(() -> {
                    helloController.setProducedClicks(helloController.getProducedClicks() + helloController.getClickPerSecond());
                    helloController.callUpdateLabels();
                });

                System.out.println("Thread working :D");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
