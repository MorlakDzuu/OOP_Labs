package Classes;

import java.util.ArrayList;

public class PolygonContainer {
    private ArrayList<Point> points;
    private int fillColor;

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }
}
