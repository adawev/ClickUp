package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.CategoryUserDto;
import diyor.adawev.clickup.dto.TagDto;
import diyor.adawev.clickup.model.CategoryUser;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Tag;
import diyor.adawev.clickup.service.CategoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category-user")
public class CategoryUserController {
    @Autowired
    CategoryUserService categoryUserService;

    @GetMapping
    public List<CategoryUser> getAll() {
        return categoryUserService.getAll();
    }
    @GetMapping("/{id}")
    public CategoryUser getById(@PathVariable Integer id) {
        return categoryUserService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody CategoryUserDto categoryUserDto) {
        return categoryUserService.create(categoryUserDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CategoryUserDto categoryUserDto) {
        return categoryUserService.update(id, categoryUserDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return categoryUserService.delete(id);
    }
}
