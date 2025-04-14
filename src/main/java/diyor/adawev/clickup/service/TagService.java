package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CommentDto;
import diyor.adawev.clickup.dto.TagDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.TagRepo;
import diyor.adawev.clickup.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepo tagRepo;
    @Autowired
    WorkspaceRepo workspaceRepo;

    public List<Tag> getAll(){
        return tagRepo.findAll();
    }
    public Tag getById(Integer id){
        return tagRepo.findById(id).get();
    }

    public Result create(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        tag.setColor(tagDto.getColor());
        Workspace workspace = workspaceRepo.findById(tagDto.getWorkspace_id()).get();
        tag.setWorkspace((List<Workspace>) workspace);
        tagRepo.save(tag);
        return new Result(true, "Tag Created");
    }

    public Result update(Integer id, TagDto tagDto) {
        Optional<Tag> byId = tagRepo.findById(id);
        if (byId.isPresent()) {
            Tag tag = byId.get();
            tag.setName(tagDto.getName());
            tag.setColor(tagDto.getColor());
            Workspace workspace = workspaceRepo.findById(tagDto.getWorkspace_id()).get();
            tag.setWorkspace((List<Workspace>) workspace);
            tagRepo.save(tag);
            return new Result(true, "Tag Updated");
        }
        return new Result(false, "Tag Not Found");
    }

    public Result delete(Integer id) {
        Optional<Tag> byId = tagRepo.findById(id);
        if (byId.isPresent()) {
            tagRepo.delete(byId.get());
            return new Result(true, "Tag Deleted");
        }
        return new Result(true, "Tag not found");
    }
}
