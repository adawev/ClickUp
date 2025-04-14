package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CommentDto;
import diyor.adawev.clickup.dto.ProjectUserDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.CommentRepo;
import diyor.adawev.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    TaskRepo taskRepo;

    public List<Comment> getAll(){
        return commentRepo.findAll();
    }
    public Comment getById(Integer id){
        return commentRepo.findById(id).get();
    }

    public Result create(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        Task task = taskRepo.findById(commentDto.getTask()).get();
        comment.setTask((List<Task>) task);
        commentRepo.save(comment);
        return new Result(true, "Comment Created");
    }

    public Result update(Integer id, CommentDto commentDto) {
        Optional<Comment> byId = commentRepo.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();
            comment.setName(commentDto.getName());
            Task task = taskRepo.findById(commentDto.getTask()).get();
            comment.setTask((List<Task>) task);
            commentRepo.save(comment);
            return new Result(true, "Comment Updated");
        }
        return new Result(false, "Comment Not Found");
    }

    public Result delete(Integer id) {
        Optional<Comment> byId = commentRepo.findById(id);
        if (byId.isPresent()) {
            commentRepo.delete(byId.get());
            return new Result(true, "Comment Deleted");
        }
        return new Result(true, "Comment not found");
    }
}
