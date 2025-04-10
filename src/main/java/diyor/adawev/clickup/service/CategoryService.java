package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CategoryDto;
import diyor.adawev.clickup.dto.ProjectDto;
import diyor.adawev.clickup.model.Category;
import diyor.adawev.clickup.model.Project;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Space;
import diyor.adawev.clickup.repository.CategoryRepo;
import diyor.adawev.clickup.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProjectRepo projectRepo;

    public List<Category> getAll(){
        return categoryRepo.findAll();
    }
    public Category getById(Integer id){
        return categoryRepo.findById(id).get();
    }

    public Result create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        Project project = projectRepo.findById(categoryDto.getProject()).get();
        category.setProject((List<Project>) project);
        category.setAchieved(categoryDto.isAchieved());
        category.setColor(categoryDto.getColor());
        categoryRepo.save(category);
        return new Result(true, "Category Created");
    }

    public Result update(Integer id, CategoryDto categoryDto) {
        Optional<Category> byId = categoryRepo.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(categoryDto.getName());
            Project project = projectRepo.findById(categoryDto.getProject()).get();
            category.setProject((List<Project>) project);
            category.setAchieved(categoryDto.isAchieved());
            category.setColor(categoryDto.getColor());
            categoryRepo.save(category);
            return new Result(true, "Category Updated");
        }
        return new Result(false, "Category Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<Category> byId = categoryRepo.findById(id);
        if (byId.isPresent()) {
            categoryRepo.delete(byId.get());
            return new Result(true, "Category Deleted");
        }
        return new Result(true, "Category Id not found");
    }
}
