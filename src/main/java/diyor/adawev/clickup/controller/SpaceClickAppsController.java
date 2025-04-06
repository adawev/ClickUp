package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.ClickAppDto;
import diyor.adawev.clickup.dto.SpaceClickAppsDto;
import diyor.adawev.clickup.model.ClickApp;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.SpaceClickApps;
import diyor.adawev.clickup.service.SpaceClickAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space-click-apps")
public class SpaceClickAppsController {
    @Autowired
    SpaceClickAppsService spaceClickAppsService;

    @GetMapping
    public List<SpaceClickApps> getAll() {
        return spaceClickAppsService.getAll();
    }
    @GetMapping("/{id}")
    public SpaceClickApps getById(@PathVariable Integer id) {
        return spaceClickAppsService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody SpaceClickAppsDto spaceClickAppsDto) {
        return spaceClickAppsService.create(spaceClickAppsDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody SpaceClickAppsDto spaceClickAppsDto) {
        return spaceClickAppsService.update(id, spaceClickAppsDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return spaceClickAppsService.delete(id);
    }
}
