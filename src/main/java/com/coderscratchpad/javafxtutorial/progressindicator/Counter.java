package com.coderscratchpad.javafxtutorial.progressindicator;

import javafx.concurrent.Task;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-progressindicator-control/">coderscratchpad.com</a>
 */
public class Counter extends Task<Void> {

    @Override
    protected Void call() throws Exception {

        // Simulate a time-consuming task
        for (int i = 1; i <= 100; i++) {

            updateProgress(i, 100); // Update progress
            Thread.sleep(100);
        }

        return null;

    }

}
