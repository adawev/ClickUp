package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CheckListDto;
import diyor.adawev.clickup.dto.TaskUserDto;
import diyor.adawev.clickup.model.CheckList;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.TaskUser;
import diyor.adawev.clickup.service.TaskUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-user")
public class TaskUserController {
    @Autowired
    TaskUserService taskUserService;

    @GetMapping
    public List<TaskUser> getAll() {
        return taskUserService.getAll();
    }
    @GetMapping("/{id}")
    public TaskUser getById(@PathVariable Integer id) {
        return taskUserService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody TaskUserDto taskUserDto) {
        return taskUserService.create(taskUserDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody TaskUserDto taskUserDto) {
        return taskUserService.update(id, taskUserDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return taskUserService.delete(id);
    }

}
