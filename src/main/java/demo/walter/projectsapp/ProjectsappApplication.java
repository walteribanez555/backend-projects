package demo.walter.projectsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProjectsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsappApplication.class, args);
	}

	@GetMapping("/")
	public String defaultResponse() {
		return "Online";
	}

	//Add a mapping for bad urls to return a 404
	@GetMapping("/**")
	public String notFound() {
		return "404 Not Found";
	}

}
