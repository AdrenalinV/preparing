package lesson_1;

public class Square extends Figure{
    private double w;

    public Square(double w) {
        this.w = w;
    }

    @Override
    double calculateArea() {
        return Math.pow(w,2);
    }
}
