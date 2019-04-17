package Classes;

import Interfaces.ICanvas;

import java.awt.*;
import java.util.ArrayList;

public class Canvas implements ICanvas {

    private Graphics graphics;

    public Canvas(Graphics graphics) {
        this.graphics = graphics;
    }

    public Canvas() {
    }

    @Override
    public void drawLine(Point from, Point to, int lineColor) {
        graphics.setColor(new Color(lineColor));
        graphics.drawLine((int) from.getX(), (int) from.getY(), (int) to.getX(), (int) to.getY());
    }

    @Override
    public void fillPolygon(ArrayList<Point> points, int fillColor) {
        ArrayList<Integer> coordinatesX = new ArrayList<>();
        ArrayList<Integer> coordinatesY = new ArrayList<>();
        for (Point point: points) {
            coordinatesX.add((int) point.getX());
            coordinatesY.add((int) point.getY());
        }
        graphics.setColor(new Color(fillColor));
        graphics.fillPolygon(coordinatesX.stream().mapToInt(i -> i).toArray(), coordinatesY.stream().mapToInt(i -> i).toArray(), points.size());
    }

    @Override
    public void drawCircle(Point center, double radius, int lineColor) {
        graphics.setColor(new Color(lineColor));
        graphics.drawOval((int) center.getX(), (int) center.getY(), (int) radius, (int) radius);
    }

    @Override
    public void fillCircle(Point center, double radius, int fillColor) {
        graphics.setColor(new Color(fillColor));
        graphics.fillOval((int) center.getX(), (int) center.getY(), (int) radius, (int) radius);
    }
}