package demo.walter.projectsapp.domain.dto;

import java.time.LocalDate;

public class UpdateProjectDto {
    private Long id;
    private String name;
    private LocalDate created_at;
    private Long status;

    public UpdateProjectDto(Long id, String name, LocalDate created_at, Long status) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.status = status;
    }

    public UpdateProjectDto() {
        
    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getCreated_at() {
        return created_at;
    }


    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }


    public Long getStatus() {
        return status;
    }


    public void setStatus(Long status) {
        this.status = status;
    }


}
