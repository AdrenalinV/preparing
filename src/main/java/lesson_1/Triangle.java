package lesson_1;

public class Triangle extends Figure{
    public Triangle(double a, double b, double l) {
        this.a = a; //сторона
        this.b = b; //сторона
        this.l = l; //угол между сторонами
    }

    private double a;
    private double b;
    private double l;

    @Override
    double calculateArea() {
        return (a*b*Math.sin(l))/2;
    }
}
