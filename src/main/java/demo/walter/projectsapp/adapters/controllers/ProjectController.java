package demo.walter.projectsapp.adapters.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.walter.projectsapp.adapters.repository.RepositoryCallback;
import demo.walter.projectsapp.domain.dto.CreateProjectDto;
import demo.walter.projectsapp.domain.dto.UpdateProjectDto;
import demo.walter.projectsapp.domain.model.Project;
import demo.walter.projectsapp.domain.repository.ProjectRepository;
import demo.walter.projectsapp.response.ResponseWrapper;

@RestController
@RequestMapping("/api/v1/project")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @PostMapping
    public CompletableFuture<ResponseWrapper<Project>> createProject(@RequestBody CreateProjectDto dto) {
        CompletableFuture<ResponseWrapper<Project>> future = new CompletableFuture<>();

        projectRepository.save(dto, new RepositoryCallback<Project>() {
            @Override
            public void onSuccess(Project project) {
                future.complete(new ResponseWrapper<>(project, HttpStatus.CREATED.value()));
            }

            @Override
            public void onError(Exception e) {
                future.complete(new ResponseWrapper<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
            }
        });

        return future;
    }

    @GetMapping
    public CompletableFuture<ResponseWrapper<List<Project>>> getProjects() { 
        CompletableFuture<ResponseWrapper<List<Project>>> future = new CompletableFuture<>();

        projectRepository.findAll(new RepositoryCallback<List<Project>>() {
            @Override
            public void onSuccess(List<Project> projects) {
                future.complete(new ResponseWrapper<>(projects, HttpStatus.OK.value()));
            }

            @Override
            public void onError(Exception e) {
                future.complete(new ResponseWrapper<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
            }
        });

        return future;
    }

    @PutMapping
    public CompletableFuture<ResponseWrapper<Project>> updateProject(@RequestParam String id,  @RequestBody UpdateProjectDto dto) {
        CompletableFuture<ResponseWrapper<Project>> future = new CompletableFuture<>();

        projectRepository.update( Long.parseLong(id) ,dto, new RepositoryCallback<Project>() {
            @Override
            public void onSuccess(Project project) {
                future.complete(new ResponseWrapper<>(project, HttpStatus.OK.value()));
            }

            @Override
            public void onError(Exception e) {
                future.complete(new ResponseWrapper<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
            }
        });

        return future;
    }


    @DeleteMapping()
    public CompletableFuture<ResponseWrapper<String>> deleteProject(@RequestParam String id) {
        CompletableFuture<ResponseWrapper<String>> future = new CompletableFuture<>();

        projectRepository.deleteById(Long.parseLong(id), new RepositoryCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                future.complete(new ResponseWrapper<>("Deleted Succesfully", HttpStatus.OK.value()));
            }

            @Override
            public void onError(Exception e) {
                future.complete(new ResponseWrapper<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
            }
        });

        return future;
    }



}
