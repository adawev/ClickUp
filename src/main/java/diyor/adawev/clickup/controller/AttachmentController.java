package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.AttachmentDto;
import diyor.adawev.clickup.dto.UserDto;
import diyor.adawev.clickup.model.Attachment;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Attachment> all = attachmentService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        Attachment byId = attachmentService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody AttachmentDto attachmentDto) {
        Result result = attachmentService.create(attachmentDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody AttachmentDto attachmentDto) {
        Result update = attachmentService.update(id, attachmentDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result delete = attachmentService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
