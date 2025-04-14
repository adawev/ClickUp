package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CheckListItemDto;
import diyor.adawev.clickup.dto.TagDto;
import diyor.adawev.clickup.model.CheckListItem;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Tag;
import diyor.adawev.clickup.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping
    public List<Tag> getAll() {
        return tagService.getAll();
    }
    @GetMapping("/{id}")
    public Tag getById(@PathVariable Integer id) {
        return tagService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody TagDto tagDto) {
        return tagService.create(tagDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody TagDto tagDto) {
        return tagService.update(id, tagDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return tagService.delete(id);
    }
}
