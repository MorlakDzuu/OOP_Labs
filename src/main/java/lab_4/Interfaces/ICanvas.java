package Interfaces;
import Classes.Point;
import java.util.ArrayList;

public interface ICanvas {
    void drawLine(Point from, Point to, int lineColor);
    void fillPolygon(ArrayList<Point> points, int fillColor);
    void drawCircle(Point center, double radius, int lineColor);
    void fillCircle(Point center, double radius, int fillColor);
}
