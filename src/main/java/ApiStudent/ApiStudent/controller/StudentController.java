package ApiStudent.ApiStudent.controller;

import ApiStudent.ApiStudent.model.Student;
import ApiStudent.ApiStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rest", name = "app_students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/student", name = "create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student add(@RequestBody Student student) {
        return this.studentService.saveEtudiant(student);
    }

    @GetMapping(path = "/students", name = "list")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> list() {
        return this.studentService.getAllStudents();
    }

    @PutMapping(path = "/student/{id}", name = "update")
    @ResponseStatus(HttpStatus.OK)
    public Student update(@RequestBody Student student, @PathVariable Long id) {
        return this.studentService.updateStudent(student, id);
    }

    @DeleteMapping(path ="/student/delete", name="delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody Student student){
        this.studentService.deleteStudent(student);
    }

    @DeleteMapping(path="/student/delete/{id}", name="id_delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        this.studentService.deleteById(id);
    }

}

