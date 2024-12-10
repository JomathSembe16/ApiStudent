package ApiStudent.ApiStudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ApiStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStudentApplication.class, args);
	}

}
