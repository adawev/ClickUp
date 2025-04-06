package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.SpaceDto;
import diyor.adawev.clickup.dto.WorkspaceUserDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Space;
import diyor.adawev.clickup.model.WorkspaceUser;
import diyor.adawev.clickup.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space")
public class SpaceController {
    @Autowired
    SpaceService spaceService;

    @GetMapping
    public List<Space> getAll() {
        return spaceService.getAll();
    }
    @GetMapping("/{id}")
    public Space getById(@PathVariable Integer id) {
        return spaceService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody SpaceDto spaceDto) {
        return spaceService.create(spaceDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody SpaceDto spaceDto) {
        return spaceService.update(id, spaceDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return spaceService.delete(id);
    }
}
