package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CategoryDto;
import diyor.adawev.clickup.dto.PriorityDto;
import diyor.adawev.clickup.model.Category;
import diyor.adawev.clickup.model.Priority;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {
    @Autowired
    PriorityService priorityService;

    @GetMapping
    public List<Priority> getAll() {
        return priorityService.getAll();
    }
    @GetMapping("/{id}")
    public Priority getById(@PathVariable Integer id) {
        return priorityService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody PriorityDto priorityDto) {
        return priorityService.create(priorityDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody PriorityDto priorityDto) {
        return priorityService.update(id, priorityDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return priorityService.delete(id);
    }
}
