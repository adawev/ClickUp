package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.ProjectDto;
import diyor.adawev.clickup.dto.ProjectUserDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.ProjectRepo;
import diyor.adawev.clickup.repository.ProjectUserRepo;
import diyor.adawev.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectUserService {
    @Autowired
    ProjectUserRepo projectUserRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    UserRepo userRepo;

    public List<ProjectUser> getAll(){
        return projectUserRepo.findAll();
    }
    public ProjectUser getById(Integer id){
        return projectUserRepo.findById(id).get();
    }

    public Result create(ProjectUserDto projectUserDto) {
        ProjectUser projectUser = new ProjectUser();
        Project project = projectRepo.findById(projectUserDto.getProject()).get();
        projectUser.setProject(project);
        User user = userRepo.findById(projectUserDto.getUser()).get();
        projectUser.setUser((List<User>) user);
        projectUserRepo.save(projectUser);
        return new Result(true, "Project User Created");
    }

    public Result update(Integer id, ProjectUserDto projectUserDto) {
        Optional<ProjectUser> byId = projectUserRepo.findById(id);
        if (byId.isPresent()) {
            ProjectUser projectUser = byId.get();
            Project project = projectRepo.findById(projectUserDto.getProject()).get();
            projectUser.setProject(project);
            User user = userRepo.findById(projectUserDto.getUser()).get();
            projectUser.setUser((List<User>) user);
            projectUserRepo.save(projectUser);
            return new Result(true, "Project User Updated");
        }
        return new Result(false, "Project User Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<ProjectUser> byId = projectUserRepo.findById(id);
        if (byId.isPresent()) {
            projectUserRepo.delete(byId.get());
            return new Result(true, "Project User Deleted");
        }
        return new Result(true, "Project User Id not found");
    }
}
