package demo.walter.projectsapp.adapters.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import demo.walter.projectsapp.domain.dto.CreateProjectDto;
import demo.walter.projectsapp.domain.dto.UpdateProjectDto;
import demo.walter.projectsapp.domain.model.Project;
import demo.walter.projectsapp.domain.repository.ProjectRepository;
import demo.walter.projectsapp.infraestructure.persistence.JpaProjectRepository;
import demo.walter.projectsapp.infraestructure.persistence.ProjectEntity;


@Repository
public class ProjectRepositoryImpl implements ProjectRepository {


    private final JpaProjectRepository jpaProjectRepository;

    public ProjectRepositoryImpl(JpaProjectRepository jpaProjectRepository) {
        this.jpaProjectRepository = jpaProjectRepository;
    }


    @Override
    public void save(CreateProjectDto dto, RepositoryCallback<Project> callback) {
        try{
            ProjectEntity entity  = new ProjectEntity();
            entity.setName(dto.getName());
            entity.setStatus(1L);

            LocalDate now = LocalDate.now();
            entity.setCreated_at(now);
            
            ProjectEntity savedEntity = jpaProjectRepository.save(entity);

            callback.onSuccess(mapToDomain(savedEntity));
        }catch(Exception e){
            callback.onError(e);
        }

   
   
    }

    @Override
    public void findAll(RepositoryCallback<List<Project>> callback) {
        try{
            List<ProjectEntity> entities = jpaProjectRepository.findAll();
            List<Project> projects = entities.stream()
                    .map(this::mapToDomain)
                    .collect(Collectors.toList());
            callback.onSuccess(projects);
        }catch(Exception e){
            callback.onError(e);
        }
    }

    @Override
    public void deleteById(Long id, RepositoryCallback<Void> callback) {
        try {
            jpaProjectRepository.deleteById(id);
            callback.onSuccess(null);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    @Override
    public void update(Long id, UpdateProjectDto dto, RepositoryCallback<Project> callback) {
        try {
            ProjectEntity entity = jpaProjectRepository.findById(id).orElseThrow();
            entity.setName(dto.getName());
            entity.setStatus(dto.getStatus());
            entity.setCreated_at(dto.getCreated_at());
            ProjectEntity updatedEntity = jpaProjectRepository.save(entity);
            callback.onSuccess(mapToDomain(updatedEntity));
        } catch (Exception e) {
            callback.onError(e);
        }
        


    }


    private Project mapToDomain(ProjectEntity entity) {
        return new Project(entity.getId(), entity.getName(), entity.getCreated_at(), entity.getStatus());
    }

}
