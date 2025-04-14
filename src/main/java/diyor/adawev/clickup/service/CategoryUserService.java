package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.CategoryUserDto;
import diyor.adawev.clickup.dto.CheckListDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.CategoryRepo;
import diyor.adawev.clickup.repository.CategoryUserRepo;
import diyor.adawev.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryUserService {
    @Autowired
    CategoryUserRepo categoryUserRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    UserRepo userRepo;

    public List<CategoryUser> getAll(){
        return categoryUserRepo.findAll();
    }
    public CategoryUser getById(Integer id){
        return categoryUserRepo.findById(id).get();
    }

    public Result create(CategoryUserDto categoryUserDto) {
        CategoryUser categoryUser = new CategoryUser();
        categoryUser.setName(categoryUserDto.getName());
        Category category = categoryRepo.findById(categoryUserDto.getCategory()).get();
        categoryUser.setCategory((List<Category>) category);
        User user = userRepo.findById(categoryUserDto.getUser()).get();
        categoryUser.setUser((List<User>) user);
        categoryUserRepo.save(categoryUser);
        return new Result(true, "Category User Created");
    }

    public Result update(Integer id, CategoryUserDto categoryUserDto) {
        Optional<CategoryUser> byId = categoryUserRepo.findById(id);
        if (byId.isPresent()) {
            CategoryUser categoryUser = byId.get();
            categoryUser.setName(categoryUserDto.getName());
            Category category = categoryRepo.findById(categoryUserDto.getCategory()).get();
            categoryUser.setCategory((List<Category>) category);
            User user = userRepo.findById(categoryUserDto.getUser()).get();
            categoryUser.setUser((List<User>) user);
            categoryUserRepo.save(categoryUser);
            return new Result(true, "Category User Updated");
        }
        return new Result(false, "Category User Not Found");
    }

    public Result delete(Integer id) {
        Optional<CategoryUser> byId = categoryUserRepo.findById(id);
        if (byId.isPresent()) {
            categoryUserRepo.delete(byId.get());
            return new Result(true, "Category User Deleted");
        }
        return new Result(true, "Category User not found");
    }
}
