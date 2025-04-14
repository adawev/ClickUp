package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.TagDto;
import diyor.adawev.clickup.dto.TaskTagDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Tag;
import diyor.adawev.clickup.model.TaskTag;
import diyor.adawev.clickup.service.TaskTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-tag")
public class TaskTagController {
    @Autowired
    TaskTagService taskTagService;

    @GetMapping
    public List<TaskTag> getAll() {
        return taskTagService.getAll();
    }
    @GetMapping("/{id}")
    public TaskTag getById(@PathVariable Integer id) {
        return taskTagService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody TaskTagDto taskTagDto) {
        return taskTagService.create(taskTagDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody TaskTagDto taskTagDto) {
        return taskTagService.update(id, taskTagDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return taskTagService.delete(id);
    }
}
