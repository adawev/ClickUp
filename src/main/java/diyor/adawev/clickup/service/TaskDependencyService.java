package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.TaskDependencyDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Task;
import diyor.adawev.clickup.model.TaskDependency;
import diyor.adawev.clickup.repository.TaskDependencyRepo;
import diyor.adawev.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskDependencyService {
    @Autowired
    TaskDependencyRepo taskDependencyRepo;
    @Autowired
    TaskRepo taskRepo;

    public List<TaskDependency> getAll(){
        return taskDependencyRepo.findAll();
    }
    public TaskDependency getById(Integer id){
        return taskDependencyRepo.findById(id).get();
    }

    public Result create(TaskDependencyDto taskDependencyDto) {
        TaskDependency taskDependency = new TaskDependency();
        Task task = taskRepo.findById(taskDependencyDto.getTask_id()).get();
        taskDependency.setTask(task);
        return new Result(true, "Task Dependency Created");
    }

    public Result update(Integer id, TaskDependencyDto taskDependencyDto) {
        Optional<TaskDependency> byId = taskDependencyRepo.findById(id);
        if (byId.isPresent()) {
            TaskDependency taskDependency = byId.get();
            Task task = taskRepo.findById(taskDependencyDto.getTask_id()).get();
            taskDependency.setTask(task);
            return new Result(true, "Task Dependency Updated");
        }
        return new Result(false, "Task Dependency Not Found");
    }

    public Result delete(Integer id) {
        Optional<TaskDependency> byId = taskDependencyRepo.findById(id);
        if (byId.isPresent()) {
            taskDependencyRepo.delete(byId.get());
            return new Result(true, "Task Dependency Deleted");
        }
        return new Result(true, "Task Dependency not found");
    }
}
