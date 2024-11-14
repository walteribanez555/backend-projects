package demo.walter.projectsapp.application.usecases;

import demo.walter.projectsapp.adapters.repository.RepositoryCallback;
import demo.walter.projectsapp.domain.repository.ProjectRepository;

public class DeleteProjectUseCase {

    private final ProjectRepository projectRepository;

    public DeleteProjectUseCase(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void execute(Long id, RepositoryCallback<Void> callback) {
        projectRepository.deleteById(id, callback);
    }

}
