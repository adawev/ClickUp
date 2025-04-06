package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.SpaceUserDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.SpaceUser;
import diyor.adawev.clickup.service.SpaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space-user")
public class SpaceUserController {
    @Autowired
    SpaceUserService spaceUserService;

    @GetMapping
    public List<SpaceUser> getAll() {
        return spaceUserService.getAll();
    }
    @GetMapping("/{id}")
    public SpaceUser getById(@PathVariable Integer id) {
        return spaceUserService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody SpaceUserDto spaceUserDto) {
        return spaceUserService.create(spaceUserDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody SpaceUserDto spaceUserDto) {
        return spaceUserService.update(id, spaceUserDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return spaceUserService.delete(id);
    }
}
