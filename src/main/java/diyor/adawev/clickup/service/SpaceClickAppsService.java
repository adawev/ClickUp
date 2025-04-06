package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.SpaceClickAppsDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.ClickAppRepo;
import diyor.adawev.clickup.repository.SpaceClickAppsRepo;
import diyor.adawev.clickup.repository.SpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceClickAppsService {
    @Autowired
    SpaceClickAppsRepo spaceClickAppsRepo;
    @Autowired
    SpaceRepo spaceRepo;
    @Autowired
    ClickAppRepo clickAppRepo;

    public List<SpaceClickApps> getAll(){
        return spaceClickAppsRepo.findAll();
    }
    public SpaceClickApps getById(Integer id){
        return spaceClickAppsRepo.findById(id).get();
    }

    public Result create(SpaceClickAppsDto spaceClickAppsDto) {
        SpaceClickApps spaceClickApps = new SpaceClickApps();
        Space space = spaceRepo.findById(spaceClickAppsDto.getSpace()).get();
        spaceClickApps.setSpace((List<Space>) space);
        ClickApp clickApp = clickAppRepo.findById(spaceClickAppsDto.getClickApp()).get();
        spaceClickApps.setClickApp((List<ClickApp>) clickApp);
        spaceClickAppsRepo.save(spaceClickApps);
        return new Result(true, "Space Click Apps Created");
    }

    public Result update(Integer id, SpaceClickAppsDto spaceClickAppsDto) {
        Optional<SpaceClickApps> byId = spaceClickAppsRepo.findById(id);
        if (byId.isPresent()) {
            SpaceClickApps spaceClickApps = byId.get();
            Space space = spaceRepo.findById(spaceClickAppsDto.getSpace()).get();
            spaceClickApps.setSpace((List<Space>) space);
            ClickApp clickApp = clickAppRepo.findById(spaceClickAppsDto.getClickApp()).get();
            spaceClickApps.setClickApp((List<ClickApp>) clickApp);
            spaceClickAppsRepo.save(spaceClickApps);
            return new Result(true, "Space Click Apps Updated");
        }
        return new Result(false, "Space Click Apps Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<SpaceClickApps> byId = spaceClickAppsRepo.findById(id);
        if (byId.isPresent()) {
            spaceClickAppsRepo.delete(byId.get());
            return new Result(true, "Space Click Apps Deleted");
        }
        return new Result(true, "Space Click Apps Id not found");
    }
}
