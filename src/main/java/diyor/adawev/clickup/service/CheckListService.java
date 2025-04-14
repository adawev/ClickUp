package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CheckListDto;
import diyor.adawev.clickup.dto.CommentDto;
import diyor.adawev.clickup.model.CheckList;
import diyor.adawev.clickup.model.Comment;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Task;
import diyor.adawev.clickup.repository.CheckListRepo;
import diyor.adawev.clickup.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListService {
    @Autowired
    CheckListRepo checkListRepo;
    @Autowired
    TaskRepo taskRepo;

    public List<CheckList> getAll(){
        return checkListRepo.findAll();
    }
    public CheckList getById(Integer id){
        return checkListRepo.findById(id).get();
    }

    public Result create(CheckListDto checkListDto) {
        CheckList checkList = new CheckList();
        checkList.setName(checkListDto.getName());
        Task task = taskRepo.findById(checkListDto.getTask()).get();
        checkList.setTask((List<Task>) task);
        checkListRepo.save(checkList);
        return new Result(true, "CheckList Created");
    }

    public Result update(Integer id, CheckListDto checkListDto) {
        Optional<CheckList> byId = checkListRepo.findById(id);
        if (byId.isPresent()) {
            CheckList checkList = byId.get();
            checkList.setName(checkListDto.getName());
            Task task = taskRepo.findById(checkListDto.getTask()).get();
            checkList.setTask((List<Task>) task);
            checkListRepo.save(checkList);
            return new Result(true, "Check List Updated");
        }
        return new Result(false, "Check List Not Found");
    }

    public Result delete(Integer id) {
        Optional<CheckList> byId = checkListRepo.findById(id);
        if (byId.isPresent()) {
            checkListRepo.delete(byId.get());
            return new Result(true, "Check List Deleted");
        }
        return new Result(true, "Check List not found");
    }
}
