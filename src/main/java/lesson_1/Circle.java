package lesson_1;

public class Circle extends Figure{
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    double calculateArea() {
        return Math.PI*Math.pow(r,2);
    }
}
