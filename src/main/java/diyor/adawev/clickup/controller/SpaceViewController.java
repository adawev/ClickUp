package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.ClickAppDto;
import diyor.adawev.clickup.dto.SpaceViewDto;
import diyor.adawev.clickup.model.ClickApp;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.SpaceView;
import diyor.adawev.clickup.service.SpaceViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space-view")
public class SpaceViewController {
    @Autowired
    SpaceViewService spaceViewService;

    @GetMapping
    public List<SpaceView> getAll() {
        return spaceViewService.getAll();
    }
    @GetMapping("/{id}")
    public SpaceView getById(@PathVariable Integer id) {
        return spaceViewService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody SpaceViewDto spaceViewDto) {
        return spaceViewService.create(spaceViewDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody SpaceViewDto spaceViewDto) {
        return spaceViewService.update(id, spaceViewDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return spaceViewService.delete(id);
    }
}
