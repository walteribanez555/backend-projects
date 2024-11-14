package demo.walter.projectsapp.application.usecases;

import java.util.List;

import demo.walter.projectsapp.adapters.repository.RepositoryCallback;
import demo.walter.projectsapp.domain.model.Project;
import demo.walter.projectsapp.domain.repository.ProjectRepository;

public class GetProjectsUseCase {


    private final ProjectRepository projectRepository;

    public GetProjectsUseCase(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void execute(RepositoryCallback<List<Project>> callback) {
        projectRepository.findAll(callback);
    }
    

}
