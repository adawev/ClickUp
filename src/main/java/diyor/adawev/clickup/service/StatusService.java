package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.StatusDto;
import diyor.adawev.clickup.dto.WorkspacePermissionDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.CategoryRepo;
import diyor.adawev.clickup.repository.ProjectRepo;
import diyor.adawev.clickup.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    StatusRepo statusRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public List<Status> getAll(){
        return statusRepo.findAll();
    }
    public Status getById(Integer id){
        return statusRepo.findById(id).get();
    }

    public Result create(StatusDto statusDto) {
        Status status = new Status();
        status.setName(statusDto.getName());
        Project project = projectRepo.findById(statusDto.getProject()).get();
        status.setProject((List<Project>) project);
        Category category = categoryRepo.findById(statusDto.getCategory()).get();
        status.setCategory((List<Category>) category);
        status.setColor(statusDto.getColor());
        statusRepo.save(status);
        return new Result(true, "Status Created");
    }

    public Result update(Integer id, StatusDto statusDto) {
        Optional<Status> byId = statusRepo.findById(id);
        if (byId.isPresent()) {
            Status status = byId.get();
            status.setName(statusDto.getName());
            Project project = projectRepo.findById(statusDto.getProject()).get();
            status.setProject((List<Project>) project);
            Category category = categoryRepo.findById(statusDto.getCategory()).get();
            status.setCategory((List<Category>) category);
            status.setColor(statusDto.getColor());
            statusRepo.save(status);
            return new Result(true, "Status Updated");
        }
        return new Result(false, "Status Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<Status> byId = statusRepo.findById(id);
        if (byId.isPresent()) {
            statusRepo.delete(byId.get());
            return new Result(true, "Status Deleted");
        }
        return new Result(true, "Status Id not found");
    }
}
