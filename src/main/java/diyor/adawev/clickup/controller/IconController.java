package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.IconDto;
import diyor.adawev.clickup.dto.UserDto;
import diyor.adawev.clickup.model.Icon;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icon")
public class IconController {
    @Autowired
    IconService iconService;

    @GetMapping
    public List<Icon> getAll() {
        return iconService.getAll();
    }
    @GetMapping("/{id}")
    public Icon getById(@PathVariable Integer id) {
        return iconService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody IconDto iconDto) {
        return iconService.create(iconDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody IconDto iconDto) {
        return iconService.update(id, iconDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return iconService.delete(id);
    }

}
