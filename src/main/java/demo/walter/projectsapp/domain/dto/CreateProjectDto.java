package demo.walter.projectsapp.domain.dto;

public class CreateProjectDto {

    private String name;

    // No-argument constructor needed for deserialization
    public CreateProjectDto() {
    }

    public CreateProjectDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}
