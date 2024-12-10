package ApiStudent.ApiStudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ApiStudent.ApiStudent.model.Student;
import org.springframework.stereotype.Repository;


@Repository
public interface   StudentRepository extends JpaRepository<Student, Long> {
}
