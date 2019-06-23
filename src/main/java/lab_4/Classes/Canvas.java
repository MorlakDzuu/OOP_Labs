package Classes;

import Interfaces.ICanvas;

import java.awt.*;
import java.util.ArrayList;

public class Canvas implements ICanvas {

    private ArrayList<LineSegment> drawLine = new ArrayList();
    private ArrayList<Circle> drawCircle = new ArrayList();
    private ArrayList<Circle> fillCircle = new ArrayList();
    private ArrayList<PolygonContainer> fillPolygon = new ArrayList();

    @Override
    public void drawLine(Point from, Point to, int lineColor) {
        LineSegment lineSegment = new LineSegment(from, to, lineColor);
        drawLine.add(lineSegment);
        //graphics.setColor(new Color(lineColor));
        //graphics.drawLine((int) from.getX(), (int) from.getY(), (int) to.getX(), (int) to.getY());
    }

    @Override
    public void fillPolygon(ArrayList<Point> points, int fillColor) {
        PolygonContainer polygonContainer = new PolygonContainer();
        polygonContainer.setPoints(points);
        polygonContainer.setFillColor(fillColor);
        fillPolygon.add(polygonContainer);
    }

    @Override
    public void drawCircle(Point center, double radius, int lineColor) {
        Circle circle = new Circle(center, radius, lineColor);
        drawCircle.add(circle);
    }

    @Override
    public void fillCircle(Point center, double radius, int fillColor) {
        Circle circle = new Circle(center, radius, fillColor);
        fillCircle.add(circle);
    }

    private void drawLinesToGraph(Graphics graphics) {
        for (LineSegment line: drawLine) {
            graphics.setColor(new Color(line.getOutlineColor()));
            graphics.drawLine((int) line.getStartPoint().getX(), (int) line.getStartPoint().getY(),
                              (int) line.getEndPoint().getX(), (int) line.getEndPoint().getY());
        }
    }

    private void drawCirclesToGraph(Graphics graphics) {
        for (Circle circle: drawCircle) {
            graphics.setColor(new Color(circle.getOutlineColor()));
            graphics.drawOval((int) circle.getCenter().getX(), (int) circle.getCenter().getY(),
                        (int) circle.getRadius() * 2, (int) circle.getRadius() * 2);
        }
    }

    private void fillPolygonsToGreaph(Graphics graphics) {
        for (PolygonContainer polygonContainer: fillPolygon) {
            ArrayList<Integer> coordinatesX = new ArrayList<>();
            ArrayList<Integer> coordinatesY = new ArrayList<>();
            for (Point point: polygonContainer.getPoints()) {
                coordinatesX.add((int) point.getX());
                coordinatesY.add((int) point.getY());
            }
            graphics.setColor(new Color(polygonContainer.getFillColor()));
            graphics.fillPolygon(coordinatesX.stream().mapToInt(i -> i).toArray(), coordinatesY.stream().mapToInt(i -> i).toArray(), polygonContainer.getPoints().size());
        }
    }

    private void fillCirclesToGraph(Graphics graphics) {
        for (Circle circle: fillCircle) {
            graphics.setColor(new Color(circle.getOutlineColor()));
            graphics.fillOval((int) circle.getCenter().getX(), (int) circle.getCenter().getY(),
                       (int) circle.getRadius() * 2, (int) circle.getRadius() * 2);
        }
    }

    public void drawAll(Graphics graphics) {
        drawLinesToGraph(graphics);
        drawCirclesToGraph(graphics);
        fillPolygonsToGreaph(graphics);
        fillCirclesToGraph(graphics);
    }
}