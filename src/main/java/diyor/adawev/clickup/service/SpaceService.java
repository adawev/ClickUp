package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.SpaceDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {
    @Autowired
    SpaceRepo spaceRepo;
    @Autowired
    WorkspaceRepo workspaceRepo;
    @Autowired
    IconRepo iconRepo;
    @Autowired
    AttachmentRepo attachmentRepo;
    @Autowired
    UserRepo userRepo;

    public List<Space> getAll(){
        return spaceRepo.findAll();
    }
    public Space getById(Integer id){
        return spaceRepo.findById(id).get();
    }

    public Result create(SpaceDto spaceDto) {
        Space space = new Space();
        space.setName(spaceDto.getName());
        space.setColor(spaceDto.getColor());
        Workspace workspace = workspaceRepo.findById(spaceDto.getWorkspace()).get();
        space.setWorkspace(workspace);
        space.setInitial_letter(spaceDto.getInitial_letter());
        Icon icon = iconRepo.findById(spaceDto.getIcon()).get();
        space.setIcon(icon);
        Attachment attachment = attachmentRepo.findById(spaceDto.getAvatar_id()).get();
        space.setAvatar_id(attachment);
        User user = userRepo.findById(spaceDto.getOwner()).get();
        space.setOwner(user);
        spaceRepo.save(space);
        return new Result(true, "Space Created");
    }

    public Result update(Integer id, SpaceDto spaceDto) {
        Optional<Space> byId = spaceRepo.findById(id);
        if (byId.isPresent()) {
            Space space = byId.get();
            space.setName(spaceDto.getName());
            space.setColor(spaceDto.getColor());
            Workspace workspace = workspaceRepo.findById(spaceDto.getWorkspace()).get();
            space.setWorkspace(workspace);
            space.setInitial_letter(spaceDto.getInitial_letter());
            Icon icon = iconRepo.findById(spaceDto.getIcon()).get();
            space.setIcon(icon);
            Attachment attachment = attachmentRepo.findById(spaceDto.getAvatar_id()).get();
            space.setAvatar_id(attachment);
            User user = userRepo.findById(spaceDto.getOwner()).get();
            space.setOwner(user);
            spaceRepo.save(space);
            return new Result(true, "Space Updated");
        }
        return new Result(false, "Space Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<Space> byId = spaceRepo.findById(id);
        if (byId.isPresent()) {
            spaceRepo.delete(byId.get());
            return new Result(true, "Space Deleted");
        }
        return new Result(true, "Space Id not found");
    }
}
