package lesson_5;

import lesson_5.entity.Student;
import lesson_5.repository.StudentRepository;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory eMFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        StudentRepository sRepo = new StudentRepository(eMFactory);
        for (int i = 0; i < 1000; i++) {
            sRepo.insert(new Student(null, "Student_" + i, i));
        }
        Student st = sRepo.findById(5L).get();
        System.out.println(st);
        st.setMark(9999);
        sRepo.update(st);
        System.out.println(sRepo.findById(5L));
        sRepo.delete(st);
        List<Student> students = sRepo.findAll();
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
