package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.AttachmentDto;
import diyor.adawev.clickup.dto.WorkspaceDto;
import diyor.adawev.clickup.model.Attachment;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.model.Workspace;
import diyor.adawev.clickup.repository.AttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepo attachmentRepo;

    public List<Attachment> getAll(){
        return attachmentRepo.findAll();
    }
    public Attachment getById(Integer id){
        return attachmentRepo.findById(id).get();
    }

    public Result create(AttachmentDto attachmentDto) {
        Attachment attachment = new Attachment();
        attachment.setName(attachmentDto.getName());
        attachment.setOriginal_name(attachmentDto.getOriginal_name());
        attachment.setSize(attachmentDto.getSize());
        attachment.setContent_type(attachmentDto.getContent_type());
        attachmentRepo.save(attachment);
        return new Result(true, "Attachment Created");
    }

    public Result update(Integer id, AttachmentDto attachmentDto) {
        Optional<Attachment> byId = attachmentRepo.findById(id);
        if (byId.isPresent()) {
            Attachment attachment = byId.get();
            attachment.setName(attachmentDto.getName());
            attachment.setOriginal_name(attachmentDto.getOriginal_name());
            attachment.setSize(attachmentDto.getSize());
            attachment.setContent_type(attachmentDto.getContent_type());
            attachmentRepo.save(attachment);
            return new Result(true, "Attachment Updated");
        }
        return new Result(false, "Attachment Not Found");
    }

    public Result delete(Integer id) {
        attachmentRepo.deleteById(id);
        return new Result(true, "Attachment Deleted");
    }
}
