package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.UserDto;
import diyor.adawev.clickup.dto.WorkspaceDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.model.Workspace;
import diyor.adawev.clickup.repository.UserRepo;
import diyor.adawev.clickup.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService {
    @Autowired
    WorkspaceRepo workspaceRepo;
    @Autowired
    UserRepo userRepo;

    public List<Workspace> getAll(){
        return workspaceRepo.findAll();
    }
    public Workspace getById(Integer id){
        return workspaceRepo.findById(id).get();
    }

    public Result create(WorkspaceDto workspaceDto) {
        Workspace workspace = new Workspace();
        workspace.setName(workspaceDto.getName());
        workspace.setColor(workspaceDto.getColor());
        User user = userRepo.findById(workspaceDto.getOwner()).get();
        workspace.setOwner((List<User>) user);
        workspace.setInitial_letter(workspaceDto.getInitial_letter());
        workspace.setAvatar(workspaceDto.getAvatar());
        workspaceRepo.save(workspace);
        return new Result(true, "Workspace Created");
    }

    public Result update(Integer id, WorkspaceDto workspaceDto) {
        Optional<Workspace> byId = workspaceRepo.findById(id);
        if (byId.isPresent()) {
            Workspace workspace = byId.get();
            workspace.setName(workspaceDto.getName());
            workspace.setColor(workspaceDto.getColor());
            User user = userRepo.findById(workspaceDto.getOwner()).get();
            workspace.setOwner((List<User>) user);
            workspace.setInitial_letter(workspaceDto.getInitial_letter());
            workspace.setAvatar(workspaceDto.getAvatar());
            workspaceRepo.save(workspace);
            return new Result(true, "Workspace Updated");
        }
        return new Result(false, "Workspace Not Found");
    }

    public Result delete(Integer id) {
        workspaceRepo.deleteById(id);

        return new Result(true, "Workspace Deleted");
    }
}
