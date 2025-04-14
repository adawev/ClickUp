package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CheckListDto;
import diyor.adawev.clickup.dto.CheckListItemDto;
import diyor.adawev.clickup.model.CheckList;
import diyor.adawev.clickup.model.CheckListItem;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.service.CheckListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklist-item")
public class CheckListItemController {
    @Autowired
    CheckListItemService checkListItemService;

    @GetMapping
    public List<CheckListItem> getAll() {
        return checkListItemService.getAll();
    }
    @GetMapping("/{id}")
    public CheckListItem getById(@PathVariable Integer id) {
        return checkListItemService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody CheckListItemDto checkListItemDto) {
        return checkListItemService.create(checkListItemDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CheckListItemDto checkListItemDto) {
        return checkListItemService.update(id, checkListItemDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return checkListItemService.delete(id);
    }

}
