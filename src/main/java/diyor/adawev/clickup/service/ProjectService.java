package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.ProjectDto;
import diyor.adawev.clickup.dto.StatusDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.ProjectRepo;
import diyor.adawev.clickup.repository.SpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    SpaceRepo spaceRepo;

    public List<Project> getAll(){
        return projectRepo.findAll();
    }
    public Project getById(Integer id){
        return projectRepo.findById(id).get();
    }

    public Result create(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        Space space = spaceRepo.findById(projectDto.getSpace()).get();
        project.setSpace((List<Space>) space);
        project.setColor(projectDto.getColor());
        projectRepo.save(project);
        return new Result(true, "Project Created");
    }

    public Result update(Integer id, ProjectDto projectDto) {
        Optional<Project> byId = projectRepo.findById(id);
        if (byId.isPresent()) {
            Project project = byId.get();
            project.setName(projectDto.getName());
            Space space = spaceRepo.findById(projectDto.getSpace()).get();
            project.setSpace((List<Space>) space);
            project.setColor(projectDto.getColor());
            projectRepo.save(project);
            return new Result(true, "Project Updated");
        }
        return new Result(false, "Project Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<Project> byId = projectRepo.findById(id);
        if (byId.isPresent()) {
            projectRepo.delete(byId.get());
            return new Result(true, "Project Deleted");
        }
        return new Result(true, "Project Id not found");
    }
}
