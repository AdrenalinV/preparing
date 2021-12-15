package lesson_7.controller;

import javassist.NotFoundException;
import lesson_7.entity.Student;
import lesson_7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") long id) throws NotFoundException {
        return studentService.findById(id).orElseThrow(() -> new NotFoundException("Student not found."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student st) {
        if (st.getId() == null){
            throw new BadRequestException();
        }
            studentService.add(st);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student st) {
        studentService.add(st);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }


    @ExceptionHandler
    public ResponseEntity<Void> handlNotFoundException(lesson_7.controller.NotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler
    public ResponseEntity<Void> handlBadRequestException(lesson_7.controller.BadRequestException ex) {
        return ResponseEntity.badRequest().build();
    }
}
