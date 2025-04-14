package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CheckListDto;
import diyor.adawev.clickup.dto.TaskAttachmentDto;
import diyor.adawev.clickup.model.CheckList;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.TaskAttachment;
import diyor.adawev.clickup.service.TaskAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-attachment")
public class TaskAttachmentController {
    @Autowired
    TaskAttachmentService taskAttachmentService;

    @GetMapping
    public List<TaskAttachment> getAll() {
        return taskAttachmentService.getAll();
    }
    @GetMapping("/{id}")
    public TaskAttachment getById(@PathVariable Integer id) {
        return taskAttachmentService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody TaskAttachmentDto taskAttachmentDto) {
        return taskAttachmentService.create(taskAttachmentDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody TaskAttachmentDto taskAttachmentDto) {
        return taskAttachmentService.update(id, taskAttachmentDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return taskAttachmentService.delete(id);
    }

}
