package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.StatusDto;
import diyor.adawev.clickup.dto.TaskDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.CategoryRepo;
import diyor.adawev.clickup.repository.PriorityRepo;
import diyor.adawev.clickup.repository.StatusRepo;
import diyor.adawev.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    StatusRepo statusRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    PriorityRepo priorityRepo;

    public List<Task> getAll(){
        return taskRepo.findAll();
    }
    public Task getById(Integer id){
        return taskRepo.findById(id).get();
    }

    public Result create(TaskDto taskDto) {
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        Status status = statusRepo.findById(taskDto.getStatus()).get();
        task.setStatus((List<Status>) status);
        Category category = categoryRepo.findById(taskDto.getCategory()).get();
        task.setCategory((List<Category>) category);
        Priority priority = priorityRepo.findById(taskDto.getPriority()).get();
        task.setPriority((List<Priority>) priority);
        task.setDue_date(taskDto.getDue_date());
        task.setEstimate_time(taskDto.getEstimate_time());
        task.setActivated_date(taskDto.getActivated_date());
        taskRepo.save(task);
        return new Result(true, "Task Created");
    }

    public Result update(Integer id, TaskDto taskDto) {
        Optional<Task> byId = taskRepo.findById(id);
        if (byId.isPresent()) {
            Task task = byId.get();
            task.setName(taskDto.getName());
            task.setDescription(taskDto.getDescription());
            Status status = statusRepo.findById(taskDto.getStatus()).get();
            task.setStatus((List<Status>) status);
            Category category = categoryRepo.findById(taskDto.getCategory()).get();
            task.setCategory((List<Category>) category);
            Priority priority = priorityRepo.findById(taskDto.getPriority()).get();
            task.setPriority((List<Priority>) priority);
            task.setDue_date(taskDto.getDue_date());
            task.setEstimate_time(taskDto.getEstimate_time());
            task.setActivated_date(taskDto.getActivated_date());
            taskRepo.save(task);
            return new Result(true, "Task Updated");
        }
        return new Result(false, "Task Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<Task> byId = taskRepo.findById(id);
        if (byId.isPresent()) {
            taskRepo.delete(byId.get());
            return new Result(true, "Task Deleted");
        }
        return new Result(true, "Task Id not found");
    }
}
