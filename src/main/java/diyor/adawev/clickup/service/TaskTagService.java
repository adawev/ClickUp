package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CommentDto;
import diyor.adawev.clickup.dto.TaskTagDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.TagRepo;
import diyor.adawev.clickup.repository.TaskRepo;
import diyor.adawev.clickup.repository.TaskTagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskTagService {
    @Autowired
    TaskTagRepo taskTagRepo;
    @Autowired
    TagRepo tagRepo;
    @Autowired
    TaskRepo taskRepo;

    public List<TaskTag> getAll(){
        return taskTagRepo.findAll();
    }
    public TaskTag getById(Integer id){
        return taskTagRepo.findById(id).get();
    }

    public Result create(TaskTagDto taskTagDto) {
        TaskTag taskTag = new TaskTag();
        Tag tag = tagRepo.findById(taskTagDto.getTag_id()).get();
        taskTag.setTag((List<Tag>) tag);
        Task task = taskRepo.findById(taskTagDto.getTask_id()).get();
        taskTag.setTask((List<Task>) task);
        taskTagRepo.save(taskTag);
        return new Result(true, "Task Tag Created");
    }

    public Result update(Integer id, TaskTagDto taskTagDto) {
        Optional<TaskTag> byId = taskTagRepo.findById(id);
        if (byId.isPresent()) {
            TaskTag taskTag = byId.get();
            Tag tag = tagRepo.findById(taskTagDto.getTag_id()).get();
            taskTag.setTag((List<Tag>) tag);
            Task task = taskRepo.findById(taskTagDto.getTask_id()).get();
            taskTag.setTask((List<Task>) task);
            taskTagRepo.save(taskTag);
            return new Result(true, "Task Tag Updated");
        }
        return new Result(false, "Task Tag Not Found");
    }

    public Result delete(Integer id) {
        Optional<TaskTag> byId = taskTagRepo.findById(id);
        if (byId.isPresent()) {
            taskTagRepo.delete(byId.get());
            return new Result(true, "Task Tag Deleted");
        }
        return new Result(true, "Task Tag not found");
    }
}
