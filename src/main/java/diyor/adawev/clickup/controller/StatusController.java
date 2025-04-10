package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.SpaceViewDto;
import diyor.adawev.clickup.dto.StatusDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.SpaceView;
import diyor.adawev.clickup.model.Status;
import diyor.adawev.clickup.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    StatusService statusService;

    @GetMapping
    public List<Status> getAll() {
        return statusService.getAll();
    }
    @GetMapping("/{id}")
    public Status getById(@PathVariable Integer id) {
        return statusService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody StatusDto statusDto) {
        return statusService.create(statusDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody StatusDto statusDto) {
        return statusService.update(id, statusDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return statusService.delete(id);
    }
}
