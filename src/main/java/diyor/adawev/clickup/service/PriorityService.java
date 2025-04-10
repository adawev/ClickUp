package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.PriorityDto;
import diyor.adawev.clickup.dto.ProjectDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.IconRepo;
import diyor.adawev.clickup.repository.PriorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityService {
    @Autowired
    PriorityRepo priorityRepo;
    @Autowired
    IconRepo iconRepo;

    public List<Priority> getAll(){
        return priorityRepo.findAll();
    }
    public Priority getById(Integer id){
        return priorityRepo.findById(id).get();
    }

    public Result create(PriorityDto priorityDto) {
        Priority priority = new Priority();
        priority.setName(priorityDto.getName());
        Icon icon = iconRepo.findById(priorityDto.getIcon()).get();
        priority.setIcon((List<Icon>) icon);
        priorityRepo.save(priority);
        return new Result(true, "Priority Created");
    }

    public Result update(Integer id, PriorityDto priorityDto) {
        Optional<Priority> byId = priorityRepo.findById(id);
        if (byId.isPresent()) {
            Priority priority = byId.get();
            priority.setName(priorityDto.getName());
            Icon icon = iconRepo.findById(priorityDto.getIcon()).get();
            priority.setIcon((List<Icon>) icon);
            priorityRepo.save(priority);
            return new Result(true, "Priority Updated");
        }
        return new Result(false, "Priority Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<Priority> byId = priorityRepo.findById(id);
        if (byId.isPresent()) {
            priorityRepo.delete(byId.get());
            return new Result(true, "Priority Deleted");
        }
        return new Result(true, "Priority Id not found");
    }
}