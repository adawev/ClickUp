package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CheckListDto;
import diyor.adawev.clickup.dto.ProjectDto;
import diyor.adawev.clickup.model.CheckList;
import diyor.adawev.clickup.model.Project;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklist")
public class CheckListController {
    @Autowired
    CheckListService checkListService;

    @GetMapping
    public List<CheckList> getAll() {
        return checkListService.getAll();
    }
    @GetMapping("/{id}")
    public CheckList getById(@PathVariable Integer id) {
        return checkListService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody CheckListDto checkListDto) {
        return checkListService.create(checkListDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CheckListDto checkListDto) {
        return checkListService.update(id, checkListDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return checkListService.delete(id);
    }
}
