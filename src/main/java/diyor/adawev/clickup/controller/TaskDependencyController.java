package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CheckListDto;
import diyor.adawev.clickup.dto.TaskDependencyDto;
import diyor.adawev.clickup.model.CheckList;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.TaskDependency;
import diyor.adawev.clickup.service.TaskDependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-dependency")
public class TaskDependencyController {
    @Autowired
    TaskDependencyService taskDependencyService;

    @GetMapping
    public List<TaskDependency> getAll() {
        return taskDependencyService.getAll();
    }
    @GetMapping("/{id}")
    public TaskDependency getById(@PathVariable Integer id) {
        return taskDependencyService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody TaskDependencyDto taskDependencyDto) {
        return taskDependencyService.create(taskDependencyDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody TaskDependencyDto taskDependencyDto) {
        return taskDependencyService.update(id, taskDependencyDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return taskDependencyService.delete(id);
    }

}
