package lesson_1;

public class Lorry extends Car implements Movable,Stopable{
    // интерфейсы не должны расширять класс(могут расширять только интерфейс)
    // в данном случае нужно использовать  implements
    // отсутствует реализация абстрактного метода open наследуемого от класса Car
    @Override
    public void move(){
        System.out.println("Car is moving");
    }
    @Override
    public void stop(){
        System.out.println("Car is stop");
    }

    @Override
    void open() {

    }
}
