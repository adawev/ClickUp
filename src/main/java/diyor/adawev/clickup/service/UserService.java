package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.UserDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAll(){
        return userRepo.findAll();
    }
    public User getById(Integer id){
        return userRepo.findById(id).get();
    }

    public Result create(UserDto userDto) {
        boolean exists = userRepo.existsByEmail(userDto.getEmail());
        if(!exists){
            return new Result(false, "Email already exist");
        }
        User user = new User();
        user.setFull_name(userDto.getFull_name());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setColor(userDto.getColor());
        user.setInitial_letter(userDto.getInitial_letter());
        user.setAvatar(userDto.getAvatar_id());
        userRepo.save(user);
        return new Result(true, "User Created");
    }

    public Result update(Integer id, UserDto userDto) {
        Optional<User> byId = userRepo.findById(id);
        if (byId.isPresent()) {
            boolean exists = userRepo.existsByEmail(userDto.getEmail());
            if(!exists){
                return new Result(false, "Email already exist");
            }
            User user = byId.get();
            user.setFull_name(userDto.getFull_name());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setColor(userDto.getColor());
            user.setInitial_letter(userDto.getInitial_letter());
            user.setAvatar(userDto.getAvatar_id());
            userRepo.save(user);
            return new Result(true, "User Updated");
        }
        return new Result(false, "User Not Found");
    }

    public Result delete(Integer id) {
        userRepo.deleteById(id);

        return new Result(true, "User Deleted");
    }

}
