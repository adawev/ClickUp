package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CategoryDto;
import diyor.adawev.clickup.dto.ProjectDto;
import diyor.adawev.clickup.model.Category;
import diyor.adawev.clickup.model.Project;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return categoryService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        return categoryService.update(id, categoryDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return categoryService.delete(id);
    }
}
