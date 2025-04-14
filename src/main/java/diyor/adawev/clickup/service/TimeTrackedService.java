package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CommentDto;
import diyor.adawev.clickup.dto.TimeTrackedDto;
import diyor.adawev.clickup.model.Comment;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Task;
import diyor.adawev.clickup.model.TimeTracked;
import diyor.adawev.clickup.repository.TaskRepo;
import diyor.adawev.clickup.repository.TimeTrackedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeTrackedService {
    @Autowired
    TimeTrackedRepo timeTrackedRepo;
    @Autowired
    TaskRepo taskRepo;

    public List<TimeTracked> getAll(){
        return timeTrackedRepo.findAll();
    }
    public TimeTracked getById(Integer id){
        return timeTrackedRepo.findById(id).get();
    }

    public Result create(TimeTrackedDto timeTrackedDto) {
        TimeTracked timeTracked = new TimeTracked();
        Task task = taskRepo.findById(timeTrackedDto.getTask_id()).get();
        timeTracked.setTask(task);
        timeTrackedRepo.save(timeTracked);
        return new Result(true, "Time Tracked Created");
    }

    public Result update(Integer id, TimeTrackedDto timeTrackedDto) {
        Optional<TimeTracked> byId = timeTrackedRepo.findById(id);
        if (byId.isPresent()) {
            TimeTracked timeTracked = byId.get();
            Task task = taskRepo.findById(timeTrackedDto.getTask_id()).get();
            timeTracked.setTask(task);
            timeTrackedRepo.save(timeTracked);
            return new Result(true, "Time Tracked Updated");
        }
        return new Result(false, "Time Tracked Not Found");
    }

    public Result delete(Integer id) {
        Optional<TimeTracked> byId = timeTrackedRepo.findById(id);
        if (byId.isPresent()) {
            timeTrackedRepo.delete(byId.get());
            return new Result(true, "Time Tracked Deleted");
        }
        return new Result(true, "Time Tracked not found");
    }
}
