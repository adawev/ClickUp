package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.UserDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

}
