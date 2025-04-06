package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.WorkspaceRoleDto;
import diyor.adawev.clickup.dto.WorkspaceUserDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.UserRepo;
import diyor.adawev.clickup.repository.WorkspaceRepo;
import diyor.adawev.clickup.repository.WorkspaceRoleRepo;
import diyor.adawev.clickup.repository.WorkspaceUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceUserService {
    @Autowired
    WorkspaceUserRepo workspaceUserRepo;
    @Autowired
    WorkspaceRepo workspaceRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    WorkspaceRoleRepo workspaceRoleRepo;

    public List<WorkspaceUser> getAll(){
        return workspaceUserRepo.findAll();
    }
    public WorkspaceUser getById(Integer id){
        return workspaceUserRepo.findById(id).get();
    }

    public Result create(WorkspaceUserDto workspaceUserDto) {
        WorkspaceUser workspaceUser = new WorkspaceUser();
        Workspace workspace = workspaceRepo.findById(workspaceUserDto.getWorkspace_id()).get();
        workspaceUser.setWorkspace((List<Workspace>) workspace);
        User user = userRepo.findById(workspaceUserDto.getUser_id()).get();
        workspaceUser.setUser((List<User>) user);
        WorkspaceRole workspaceRole = workspaceRoleRepo.findById(workspaceUserDto.getWorkspaceRole_id()).get();
        workspaceUser.setWorkspaceRole(workspaceRole);
        workspaceUserRepo.save(workspaceUser);
        return new Result(true, "Workspace User Created");
    }

    public Result update(Integer id, WorkspaceUserDto workspaceUserDto) {
        Optional<WorkspaceUser> byId = workspaceUserRepo.findById(id);
        if (byId.isPresent()) {
            WorkspaceUser workspaceUser = byId.get();
            Workspace workspace = workspaceRepo.findById(workspaceUserDto.getWorkspace_id()).get();
            workspaceUser.setWorkspace((List<Workspace>) workspace);
            User user = userRepo.findById(workspaceUserDto.getUser_id()).get();
            workspaceUser.setUser((List<User>) user);
            WorkspaceRole workspaceRole = workspaceRoleRepo.findById(workspaceUserDto.getWorkspaceRole_id()).get();
            workspaceUser.setWorkspaceRole(workspaceRole);
            workspaceUserRepo.save(workspaceUser);
            return new Result(true, "Workspace User Updated");
        }
        return new Result(false, "Workspace User Not Found");
    }

    public Result delete(Integer id) {
        Optional<WorkspaceUser> byId = workspaceUserRepo.findById(id);
        if (byId.isPresent()) {
            workspaceUserRepo.delete(byId.get());
            return new Result(true, "Workspace User Deleted");
        }
        return new Result(true, "Workspace User Id not found");
    }
}
