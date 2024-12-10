package ApiStudent.ApiStudent.service;


import ApiStudent.ApiStudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ApiStudent.ApiStudent.model.Student;
import ApiStudent.ApiStudent.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student saveEtudiant(Student student){
        return this.studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }

    public Optional<Student> getOneStudent(Long id){
        return this.studentRepository.findById(id);
    }

    public Student updateStudent(Student student, Long id){
        Optional<Student> studentExist=this.studentRepository.findById(id);
        if(!studentExist.isPresent()){
            throw new StudentNotFoundException(String.format("Cet étudiant n'existe pas"));}

        return this.studentRepository.save(student);
    }

    public void deleteById(Long id){
        Optional<Student> studentExist=this.studentRepository.findById(id);
        if(!studentExist.isPresent()){
            throw new StudentNotFoundException(String.format("Cet étudiant n'existe pas"));}

        this.studentRepository.deleteById(id);
    }
    public void deleteStudent(Student student){
        this.studentRepository.delete(student);
    }

}
