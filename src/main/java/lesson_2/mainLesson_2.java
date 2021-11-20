package lesson_2;

public class mainLesson_2 {
    public static void main(String[] args) {
        System.out.println("==================MyOneLinkedList=========================");
        MyOneLinkedList<String> names=new MyOneLinkedList<>();
        System.out.println("isEmpty?: "+names.isEmpty());
        names.insertFirst("Infinity");
        names.insertFirst("Suzuki");
        names.insertFirst("Ferrari");
        System.out.println(names);
        System.out.println("isEmpty?: "+names.isEmpty());
        System.out.println("remove: Infinity");
        names.remove("Infinity");
        System.out.println(names);
        System.out.println("=================MyArrayList==========================");
        MyArrayList<String> names2=new MyArrayList<>();
        names2.add("Камаз");
        names2.add("Ваз");
        names2.add("Газ");
        System.out.println(names2);
        names2.remove(1);
        System.out.println("remove(index): 1");
        System.out.println(names2);
    }

}
