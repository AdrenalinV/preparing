package lesson_7.service;

import lesson_7.entity.Student;
import lesson_7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public Student add(Student st) {
        return studentRepository.saveAndFlush(st);
    }

    @Transactional
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

}
