package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.ProjectDto;
import diyor.adawev.clickup.dto.ProjectUserDto;
import diyor.adawev.clickup.model.Project;
import diyor.adawev.clickup.model.ProjectUser;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.service.ProjectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-user")
public class ProjectUserController {
    @Autowired
    ProjectUserService projectUserService;

    @GetMapping
    public List<ProjectUser> getAll() {
        return projectUserService.getAll();
    }
    @GetMapping("/{id}")
    public ProjectUser getById(@PathVariable Integer id) {
        return projectUserService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody ProjectUserDto projectUserDto) {
        return projectUserService.create(projectUserDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ProjectUserDto projectUserDto) {
        return projectUserService.update(id, projectUserDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return projectUserService.delete(id);
    }
}
