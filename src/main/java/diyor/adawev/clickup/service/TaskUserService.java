package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CommentDto;
import diyor.adawev.clickup.dto.TaskUserDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.TaskRepo;
import diyor.adawev.clickup.repository.TaskUserRepo;
import diyor.adawev.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskUserService {
    @Autowired
    TaskUserRepo taskUserRepo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    UserRepo userRepo;

    public List<TaskUser> getAll(){
        return taskUserRepo.findAll();
    }
    public TaskUser getById(Integer id){
        return taskUserRepo.findById(id).get();
    }

    public Result create(TaskUserDto taskUserDto) {
        TaskUser taskUser = new TaskUser();
        Task task = taskRepo.findById(taskUserDto.getTask_id()).get();
        taskUser.setTask((List<Task>) task);
        User user = userRepo.findById(taskUserDto.getUser_id()).get();
        taskUser.setUser((List<User>) user);
        taskUserRepo.save(taskUser);
        return new Result(true, "Task User Created");
    }

    public Result update(Integer id, TaskUserDto taskUserDto) {
        Optional<TaskUser> byId = taskUserRepo.findById(id);
        if (byId.isPresent()) {
            TaskUser taskUser = byId.get();
            Task task = taskRepo.findById(taskUserDto.getTask_id()).get();
            taskUser.setTask((List<Task>) task);
            User user = userRepo.findById(taskUserDto.getUser_id()).get();
            taskUser.setUser((List<User>) user);
            taskUserRepo.save(taskUser);
            return new Result(true, "Task User Updated");
        }
        return new Result(false, "Task User Not Found");
    }

    public Result delete(Integer id) {
        Optional<TaskUser> byId = taskUserRepo.findById(id);
        if (byId.isPresent()) {
            taskUserRepo.delete(byId.get());
            return new Result(true, "Task User Deleted");
        }
        return new Result(true, "Task User not found");
    }
}
