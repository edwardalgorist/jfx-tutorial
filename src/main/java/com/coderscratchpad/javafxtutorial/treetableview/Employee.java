package com.coderscratchpad.javafxtutorial.treetableview;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-treetableview-building-hierarchical-data-displays/">coderscratchpad.com</a>
 */
public class Employee {

    private String name;
    private String position;

    private double progress;

    public Employee(String name, String position, double progress) {
        this.name = name;
        this.position = position;
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getProgress() {
        return progress;
    }

}
