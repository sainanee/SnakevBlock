package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Ball extends Circle implements Serializable {
    private static final long serialVersionUID = 42L;
    private final int width = Constants.width;
    private final int height = Constants.height;
    private final int rows = Constants.rows;
    private transient Label label;
    private int strength;
    private double xc;
    private double yc;
    Ball(double x, double y, int strength)
    {
        super(x, y, 8, Color.YELLOW);
        xc = x;
        yc = y;
        this.strength = strength;
        this.label = new Label(Integer.toString(this.strength));
        this.label.setFont(new Font(10));
        this.label.setLayoutX(x-4);
        this.label.setLayoutY(y-6.5);
        this.label.setAlignment(Pos.CENTER);
    }

    public void store()
    {
        xc = getTranslateX();
        yc = getTranslateY();
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void restore() {
        setTranslateX(xc);
        setTranslateY(yc);
        setRadius(8);
        setFill(Color.YELLOW);
        label = new Label(Integer.toString(strength));
        this.label.setFont(new Font(10));
        this.label.setLayoutX(xc-4);
        this.label.setLayoutY(yc-6.5);
        this.label.setAlignment(Pos.CENTER);
    }
}
