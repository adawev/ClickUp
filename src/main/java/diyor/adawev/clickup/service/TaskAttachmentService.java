package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CommentDto;
import diyor.adawev.clickup.dto.TaskAttachmentDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.AttachmentRepo;
import diyor.adawev.clickup.repository.TaskAttachmentRepo;
import diyor.adawev.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskAttachmentService {
    @Autowired
    TaskAttachmentRepo taskAttachmentRepo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    AttachmentRepo attachmentRepo;

    public List<TaskAttachment> getAll(){
        return taskAttachmentRepo.findAll();
    }
    public TaskAttachment getById(Integer id){
        return taskAttachmentRepo.findById(id).get();
    }

    public Result create(TaskAttachmentDto taskAttachmentDto) {
        TaskAttachment taskAttachment = new TaskAttachment();
        Task task = taskRepo.findById(taskAttachmentDto.getTask_id()).get();
        taskAttachment.setTask((List<Task>) task);
        Attachment attachment = attachmentRepo.findById(taskAttachmentDto.getAttachment_id()).get();
        taskAttachment.setAttachment((List<Attachment>) attachment);
        taskAttachment.setPin_over_image(taskAttachmentDto.isPin_over_image());
        taskAttachmentRepo.save(taskAttachment);
        return new Result(true, "Task Attachment Created");
    }

    public Result update(Integer id, TaskAttachmentDto taskAttachmentDto) {
        Optional<TaskAttachment> byId = taskAttachmentRepo.findById(id);
        if (byId.isPresent()) {
            TaskAttachment taskAttachment = byId.get();
            Task task = taskRepo.findById(taskAttachmentDto.getTask_id()).get();
            taskAttachment.setTask((List<Task>) task);
            Attachment attachment = attachmentRepo.findById(taskAttachmentDto.getAttachment_id()).get();
            taskAttachment.setAttachment((List<Attachment>) attachment);
            taskAttachment.setPin_over_image(taskAttachmentDto.isPin_over_image());
            taskAttachmentRepo.save(taskAttachment);
            return new Result(true, "Task Attachment Updated");
        }
        return new Result(false, "Task Attachment Not Found");
    }

    public Result delete(Integer id) {
        Optional<TaskAttachment> byId = taskAttachmentRepo.findById(id);
        if (byId.isPresent()) {
            taskAttachmentRepo.delete(byId.get());
            return new Result(true, "Task Attachment Deleted");
        }
        return new Result(true, "Task Attachment not found");
    }
}
