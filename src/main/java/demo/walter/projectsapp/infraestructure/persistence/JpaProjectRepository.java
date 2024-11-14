package demo.walter.projectsapp.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectRepository extends JpaRepository<ProjectEntity, Long>{

}
