package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.ClickAppDto;
import diyor.adawev.clickup.dto.ViewDto;
import diyor.adawev.clickup.model.ClickApp;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.View;
import diyor.adawev.clickup.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {
    @Autowired
    ViewService viewService;

    @GetMapping
    public List<View> getAll() {
        return viewService.getAll();
    }
    @GetMapping("/{id}")
    public View getById(@PathVariable Integer id) {
        return viewService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody ViewDto viewDto) {
        return viewService.create(viewDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ViewDto viewDto) {
        return viewService.update(id, viewDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return viewService.delete(id);
    }
}
