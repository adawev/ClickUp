package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.ClickAppDto;
import diyor.adawev.clickup.dto.WorkspacePermissionDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.WorkspacePermissionRepo;
import diyor.adawev.clickup.repository.WorkspaceRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspacePermissionService {
    @Autowired
    WorkspacePermissionRepo workspacePermissionRepo;
    @Autowired
    WorkspaceRoleRepo workspaceRoleRepo;

    public List<WorkspacePermission> getAll(){
        return workspacePermissionRepo.findAll();
    }
    public WorkspacePermission getById(Integer id){
        return workspacePermissionRepo.findById(id).get();
    }

    public Result create(WorkspacePermissionDto workspacePermissionDto) {
        WorkspacePermission workspacePermission = new WorkspacePermission();
        WorkspaceRole workspaceRole = workspaceRoleRepo.findById(workspacePermissionDto.getWorkspaceRole()).get();
        workspacePermission.setWorkspaceRole(workspaceRole);
        workspacePermissionRepo.save(workspacePermission);
        return new Result(true, "Workspace Permission Created");
    }

    public Result update(Integer id, WorkspacePermissionDto workspacePermissionDto) {
        Optional<WorkspacePermission> byId = workspacePermissionRepo.findById(id);
        if (byId.isPresent()) {
            WorkspacePermission workspacePermission = byId.get();
            WorkspaceRole workspaceRole = workspaceRoleRepo.findById(workspacePermissionDto.getWorkspaceRole()).get();
            workspacePermission.setWorkspaceRole(workspaceRole);
            workspacePermissionRepo.save(workspacePermission);
            return new Result(true, "Workspace Permission Updated");
        }
        return new Result(false, "Workspace Permission Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<WorkspacePermission> byId = workspacePermissionRepo.findById(id);
        if (byId.isPresent()) {
            workspacePermissionRepo.delete(byId.get());
            return new Result(true, "Workspace Permission Deleted");
        }
        return new Result(true, "Workspace Permission Id not found");
    }
}
