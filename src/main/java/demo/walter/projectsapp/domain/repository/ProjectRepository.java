package demo.walter.projectsapp.domain.repository;

import java.util.List;

import demo.walter.projectsapp.adapters.repository.RepositoryCallback;
import demo.walter.projectsapp.domain.dto.CreateProjectDto;
import demo.walter.projectsapp.domain.dto.UpdateProjectDto;
import demo.walter.projectsapp.domain.model.Project;

public interface ProjectRepository {
    void save(CreateProjectDto  dto, RepositoryCallback<Project> callback);
    void findAll( RepositoryCallback<List<Project>> callback);
    void deleteById(Long id, RepositoryCallback<Void> callback);
    void update(Long id, UpdateProjectDto dto, RepositoryCallback<Project> callback);
    

}
