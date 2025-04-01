package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.IconDto;
import diyor.adawev.clickup.dto.UserDto;
import diyor.adawev.clickup.model.Attachment;
import diyor.adawev.clickup.model.Icon;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.repository.AttachmentRepo;
import diyor.adawev.clickup.repository.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconService {
    @Autowired
    IconRepo iconRepo;
    @Autowired
    AttachmentRepo attachmentRepo;

    public List<Icon> getAll(){
        return iconRepo.findAll();
    }
    public Icon getById(Integer id){
        return iconRepo.findById(id).get();
    }

    public Result create(IconDto iconDto) {
        Icon icon = new Icon();
        Attachment attachment = attachmentRepo.findById(iconDto.getAttachment()).get();
        icon.setAttachment(attachment);
        icon.setColor(iconDto.getColor());
        icon.setInitial_letter(iconDto.getInitial_letter());
        iconRepo.save(icon);
        return new Result(true, "Icon Created");
    }

    public Result update(Integer id, IconDto iconDto) {
        Optional<Icon> byId = iconRepo.findById(id);
        if (byId.isPresent()) {
            Icon icon = byId.get();
            Attachment attachment = attachmentRepo.findById(iconDto.getAttachment()).get();
            icon.setAttachment(attachment);
            icon.setColor(iconDto.getColor());
            icon.setInitial_letter(iconDto.getInitial_letter());
            iconRepo.save(icon);
            return new Result(true, "Icon Created");
        }
        return new Result(false, "Icon Not Found");
    }

    public Result delete(Integer id) {
        iconRepo.deleteById(id);

        return new Result(true, "Icon Deleted");
    }
}
