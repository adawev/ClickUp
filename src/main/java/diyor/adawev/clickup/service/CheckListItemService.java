package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CheckListItemDto;
import diyor.adawev.clickup.dto.CommentDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.CheckListItemRepo;
import diyor.adawev.clickup.repository.CheckListRepo;
import diyor.adawev.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListItemService {
    @Autowired
    CheckListItemRepo checkListItemRepo;
    @Autowired
    CheckListRepo checkListRepo;
    @Autowired
    UserRepo userRepo;

    public List<CheckListItem> getAll(){
        return checkListItemRepo.findAll();
    }
    public CheckListItem getById(Integer id){
        return checkListItemRepo.findById(id).get();
    }

    public Result create(CheckListItemDto checkListItemDto) {
        CheckListItem checkListItem = new CheckListItem();
        checkListItem.setName(checkListItemDto.getName());
        CheckList checkList = checkListRepo.findById(checkListItemDto.getChecklist_id()).get();
        checkListItem.setChecklist(checkList);
        checkListItem.setResolved(checkListItemDto.getResolved());
        User user = userRepo.findById(checkListItemDto.getUser_id()).get();
        checkListItem.setUser((List<User>) user);
        checkListItemRepo.save(checkListItem);
        return new Result(true, "CheckList Item Created");
    }

    public Result update(Integer id, CheckListItemDto checkListItemDto) {
        Optional<CheckListItem> byId = checkListItemRepo.findById(id);
        if (byId.isPresent()) {
            CheckListItem checkListItem = byId.get();
            checkListItem.setName(checkListItemDto.getName());
            CheckList checkList = checkListRepo.findById(checkListItemDto.getChecklist_id()).get();
            checkListItem.setChecklist(checkList);
            checkListItem.setResolved(checkListItemDto.getResolved());
            User user = userRepo.findById(checkListItemDto.getUser_id()).get();
            checkListItem.setUser((List<User>) user);
            checkListItemRepo.save(checkListItem);
            return new Result(true, "CheckList Item Updated");
        }
        return new Result(false, "CheckList Item Not Found");
    }

    public Result delete(Integer id) {
        Optional<CheckListItem> byId = checkListItemRepo.findById(id);
        if (byId.isPresent()) {
            checkListItemRepo.delete(byId.get());
            return new Result(true, "CheckList Item Deleted");
        }
        return new Result(true, "CheckList Item not found");
    }
}
