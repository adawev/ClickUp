package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.WorkspaceDto;
import diyor.adawev.clickup.dto.WorkspaceRoleDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.model.Workspace;
import diyor.adawev.clickup.model.WorkspaceRole;
import diyor.adawev.clickup.repository.WorkspaceRepo;
import diyor.adawev.clickup.repository.WorkspaceRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceRoleService {
    @Autowired
    WorkspaceRoleRepo workspaceRoleRepo;
    @Autowired
    WorkspaceRepo workspaceRepo;

    public List<WorkspaceRole> getAll(){
        return workspaceRoleRepo.findAll();
    }
    public WorkspaceRole getById(Integer id){
        return workspaceRoleRepo.findById(id).get();
    }

    public Result create(WorkspaceRoleDto workspaceRoleDto) {
        WorkspaceRole workspaceRole = new WorkspaceRole();

        Workspace workspace = workspaceRepo.findById(workspaceRoleDto.getWorkspace()).get();
        workspaceRole.setWorkspace((List<Workspace>) workspace);
        workspaceRole.setName(workspaceRoleDto.getName());
        workspaceRole.setExtends_role(workspaceRoleDto.getExtends_role());
        workspaceRoleRepo.save(workspaceRole);
        return new Result(true, "Workspace Role Created");
    }

    public Result update(Integer id, WorkspaceRoleDto workspaceRoleDto) {
        Optional<WorkspaceRole> byId = workspaceRoleRepo.findById(id);
        if (byId.isPresent()) {
            WorkspaceRole workspaceRole = byId.get();
            Workspace workspace = workspaceRepo.findById(workspaceRoleDto.getWorkspace()).get();
            workspaceRole.setWorkspace((List<Workspace>) workspace);
            workspaceRole.setName(workspaceRoleDto.getName());
            workspaceRole.setExtends_role(workspaceRoleDto.getExtends_role());
            workspaceRoleRepo.save(workspaceRole);
            return new Result(true, "Workspace Role Updated");
        }
        return new Result(false, "Workspace Role Not Found");
    }

    public Result delete(Integer id) {
        Optional<WorkspaceRole> byId = workspaceRoleRepo.findById(id);
        if (byId.isPresent()) {
            workspaceRoleRepo.delete(byId.get());
            return new Result(true, "Workspace Role Deleted");
        }
        return new Result(true, "Workspace Role Id not found");
    }
}
