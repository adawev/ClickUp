package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CommentDto;
import diyor.adawev.clickup.dto.TaskHistoryDto;
import diyor.adawev.clickup.model.Comment;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Task;
import diyor.adawev.clickup.model.TaskHistory;
import diyor.adawev.clickup.repository.TaskHistoryRepo;
import diyor.adawev.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskHistoryService {
    @Autowired
    TaskHistoryRepo taskHistoryRepo;
    @Autowired
    TaskRepo taskRepo;

    public List<TaskHistory> getAll(){
        return taskHistoryRepo.findAll();
    }
    public TaskHistory getById(Integer id){
        return taskHistoryRepo.findById(id).get();
    }

    public Result create(TaskHistoryDto taskHistoryDto) {
        TaskHistory taskHistory = new TaskHistory();
        Task task = taskRepo.findById(taskHistoryDto.getTask_id()).get();
        taskHistory.setTask(task);
        taskHistory.setChange_field_name(taskHistoryDto.getChange_field_name());
        taskHistory.setBefore(taskHistoryDto.getBefore());
        taskHistory.setAfter(taskHistoryDto.getAfter());
        taskHistory.setData(taskHistoryDto.getData());
        taskHistoryRepo.save(taskHistory);
        return new Result(true, "Task History Created");
    }

    public Result update(Integer id, TaskHistoryDto taskHistoryDto) {
        Optional<TaskHistory> byId = taskHistoryRepo.findById(id);
        if (byId.isPresent()) {
            TaskHistory taskHistory = byId.get();
            Task task = taskRepo.findById(taskHistoryDto.getTask_id()).get();
            taskHistory.setTask(task);
            taskHistory.setChange_field_name(taskHistoryDto.getChange_field_name());
            taskHistory.setBefore(taskHistoryDto.getBefore());
            taskHistory.setAfter(taskHistoryDto.getAfter());
            taskHistory.setData(taskHistoryDto.getData());
            taskHistoryRepo.save(taskHistory);
            return new Result(true, "Task History Updated");
        }
        return new Result(false, "Task History Not Found");
    }

    public Result delete(Integer id) {
        Optional<TaskHistory> byId = taskHistoryRepo.findById(id);
        if (byId.isPresent()) {
            taskHistoryRepo.delete(byId.get());
            return new Result(true, "Task History Deleted");
        }
        return new Result(true, "Task History not found");
    }
}
