package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.ClickAppDto;
import diyor.adawev.clickup.dto.SpaceUserDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.SpaceRepo;
import diyor.adawev.clickup.repository.SpaceUserRepo;
import diyor.adawev.clickup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceUserService {
    @Autowired
    SpaceUserRepo spaceUserRepo;
    @Autowired
    SpaceRepo spaceRepo;
    @Autowired
    UserRepo userRepo;

    public List<SpaceUser> getAll() {
        return spaceUserRepo.findAll();
    }

    public SpaceUser getById(Integer id) {
        return spaceUserRepo.findById(id).get();
    }

    public Result create(SpaceUserDto spaceUserDto) {
        SpaceUser spaceUser = new SpaceUser();
        Space space = spaceRepo.findById(spaceUserDto.getSpace()).get();
        spaceUser.setSpace((List<Space>) space);
        User user = userRepo.findById(spaceUserDto.getMember()).get();
        spaceUser.setMember((List<User>) user);
        spaceUserRepo.save(spaceUser);
        return new Result(true, "Space User Created");
    }

    public Result update(Integer id, SpaceUserDto spaceUserDto) {
        Optional<SpaceUser> byId = spaceUserRepo.findById(id);
        if (byId.isPresent()) {
            SpaceUser spaceUser = byId.get();
            Space space = spaceRepo.findById(spaceUserDto.getSpace()).get();
            spaceUser.setSpace((List<Space>) space);
            User user = userRepo.findById(spaceUserDto.getMember()).get();
            spaceUser.setMember((List<User>) user);
            spaceUserRepo.save(spaceUser);
            return new Result(true, "Space User Updated");
        }
        return new Result(false, "Space User Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<SpaceUser> byId = spaceUserRepo.findById(id);
        if (byId.isPresent()) {
            spaceUserRepo.delete(byId.get());
            return new Result(true, "Space User Deleted");
        }
        return new Result(true, "Space User Id not found");
    }
}
