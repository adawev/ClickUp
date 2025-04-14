package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CheckListDto;
import diyor.adawev.clickup.dto.TimeTrackedDto;
import diyor.adawev.clickup.model.CheckList;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.TimeTracked;
import diyor.adawev.clickup.service.TimeTrackedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-tracked")
public class TimeTrackedController {
    @Autowired
    TimeTrackedService timeTrackedService;

    @GetMapping
    public List<TimeTracked> getAll() {
        return timeTrackedService.getAll();
    }
    @GetMapping("/{id}")
    public TimeTracked getById(@PathVariable Integer id) {
        return timeTrackedService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody TimeTrackedDto timeTrackedDto) {
        return timeTrackedService.create(timeTrackedDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody TimeTrackedDto timeTrackedDto) {
        return timeTrackedService.update(id, timeTrackedDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return timeTrackedService.delete(id);
    }

}
