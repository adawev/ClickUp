package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.ClickAppDto;
import diyor.adawev.clickup.dto.SpaceDto;
import diyor.adawev.clickup.model.ClickApp;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Space;
import diyor.adawev.clickup.service.ClickAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/click-app")
public class ClickAppController {
    @Autowired
    ClickAppService clickAppService;

    @GetMapping
    public List<ClickApp> getAll() {
        return clickAppService.getAll();
    }
    @GetMapping("/{id}")
    public ClickApp getById(@PathVariable Integer id) {
        return clickAppService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody ClickAppDto clickAppDto) {
        return clickAppService.create(clickAppDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ClickAppDto clickAppDto) {
        return clickAppService.update(id, clickAppDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return clickAppService.delete(id);
    }
}
