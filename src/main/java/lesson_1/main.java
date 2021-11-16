package lesson_1;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Person myPerson= new Person.Builder("Vadim","Shchegolev","9999999999")
                .addGender("M")
                .addCountry("Russia")
                .build();
        System.out.println(myPerson);

        System.out.println("----------------------------------------------------");
        // т.к. все типы фигур наследованы от класса Figure мы можем использовать любой из потомков данного класса
        // Triangle, Circle, Square
        ArrayList<Figure> figures= new ArrayList<>();
        figures.add(new Triangle(5d,10d,1d));
        figures.add(new Circle(13));
        figures.add(new Square(13));
        for (Figure f:figures) {
            System.out.println(f.calculateArea());
        }
    }
}
