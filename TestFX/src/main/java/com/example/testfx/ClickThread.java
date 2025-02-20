package com.example.testfx;

public class ClickThread extends Thread{

    HelloController helloController;

    public ClickThread(HelloController helloController) {
        this.helloController = helloController;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
            helloController.setProducedClicks(helloController.getProducedClicks() + helloController.getClickPerSecond());
            helloController.updateClickLabels();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//platform.run.later
