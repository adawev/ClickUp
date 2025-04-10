package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.ProjectDto;
import diyor.adawev.clickup.dto.StatusDto;
import diyor.adawev.clickup.model.Project;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Status;
import diyor.adawev.clickup.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAll();
    }
    @GetMapping("/{id}")
    public Project getById(@PathVariable Integer id) {
        return projectService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody ProjectDto projectDto) {
        return projectService.create(projectDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ProjectDto projectDto) {
        return projectService.update(id, projectDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return projectService.delete(id);
    }
}
