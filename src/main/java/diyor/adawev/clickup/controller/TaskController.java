package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.AttachmentDto;
import diyor.adawev.clickup.dto.TaskDto;
import diyor.adawev.clickup.model.Attachment;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Task;
import diyor.adawev.clickup.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Task> all = taskService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        Task byId = taskService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody TaskDto taskDto) {
        Result result = taskService.create(taskDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody TaskDto taskDto) {
        Result update = taskService.update(id, taskDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = taskService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
