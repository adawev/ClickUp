package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.AttachmentDto;
import diyor.adawev.clickup.dto.UserDto;
import diyor.adawev.clickup.model.Attachment;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @GetMapping
    public List<Attachment> getAll() {
        return attachmentService.getAll();
    }
    @GetMapping("/{id}")
    public Attachment getById(@PathVariable Integer id) {
        return attachmentService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody AttachmentDto attachmentDto) {
        return attachmentService.create(attachmentDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody AttachmentDto attachmentDto) {
        return attachmentService.update(id, attachmentDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return attachmentService.delete(id);
    }

}
