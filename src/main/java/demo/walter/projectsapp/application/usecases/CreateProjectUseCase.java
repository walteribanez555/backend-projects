package demo.walter.projectsapp.application.usecases;

import demo.walter.projectsapp.adapters.repository.RepositoryCallback;
import demo.walter.projectsapp.domain.dto.CreateProjectDto;
import demo.walter.projectsapp.domain.model.Project;
import demo.walter.projectsapp.domain.repository.ProjectRepository;

public class CreateProjectUseCase {
    private final ProjectRepository projectRepository;

    public CreateProjectUseCase(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void execute(CreateProjectDto dto, RepositoryCallback<Project> callback) {
        projectRepository.save(dto, callback);
    }



}
