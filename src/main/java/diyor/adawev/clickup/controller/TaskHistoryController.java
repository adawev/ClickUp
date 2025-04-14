package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CheckListDto;
import diyor.adawev.clickup.dto.TaskHistoryDto;
import diyor.adawev.clickup.model.CheckList;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.TaskHistory;
import diyor.adawev.clickup.service.TaskHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-history")
public class TaskHistoryController {
    @Autowired
    TaskHistoryService taskHistoryService;

    @GetMapping
    public List<TaskHistory> getAll() {
        return taskHistoryService.getAll();
    }
    @GetMapping("/{id}")
    public TaskHistory getById(@PathVariable Integer id) {
        return taskHistoryService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody TaskHistoryDto taskHistoryDto) {
        return taskHistoryService.create(taskHistoryDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody TaskHistoryDto taskHistoryDto) {
        return taskHistoryService.update(id, taskHistoryDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return taskHistoryService.delete(id);
    }

}
