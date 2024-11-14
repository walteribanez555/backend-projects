package demo.walter.projectsapp.application.usecases;

import demo.walter.projectsapp.adapters.repository.RepositoryCallback;
import demo.walter.projectsapp.domain.dto.UpdateProjectDto;
import demo.walter.projectsapp.domain.model.Project;
import demo.walter.projectsapp.domain.repository.ProjectRepository;

public class UpdateProjectUseCase {

    private final ProjectRepository projectRepository;

    public UpdateProjectUseCase(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void execute(Long id, UpdateProjectDto dto, RepositoryCallback<Project> callback) {
        projectRepository.update(id, dto , callback);
    }

}
