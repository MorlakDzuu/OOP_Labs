public interface IShape {
    double getArea();
    double getPerimeter();

    @Override
    String toString();
    int getOutlineColor();
}