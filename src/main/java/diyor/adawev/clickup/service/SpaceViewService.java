package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.ClickAppDto;
import diyor.adawev.clickup.dto.SpaceViewDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.SpaceRepo;
import diyor.adawev.clickup.repository.SpaceViewRepo;
import diyor.adawev.clickup.repository.ViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceViewService {
    @Autowired
    SpaceViewRepo spaceViewRepo;
    @Autowired
    SpaceRepo spaceRepo;
    @Autowired
    ViewRepo viewRepo;

    public List<SpaceView> getAll(){
        return spaceViewRepo.findAll();
    }
    public SpaceView getById(Integer id){
        return spaceViewRepo.findById(id).get();
    }

    public Result create(SpaceViewDto spaceViewDto) {
        SpaceView spaceView = new SpaceView();
        Space space = spaceRepo.findById(spaceViewDto.getSpace()).get();
        spaceView.setSpace(space);
        View view = viewRepo.findById(spaceViewDto.getView()).get();
        spaceView.setView(view);
        spaceViewRepo.save(spaceView);
        return new Result(true, "Space View Created");
    }

    public Result update(Integer id, SpaceViewDto spaceViewDto) {
        Optional<SpaceView> byId = spaceViewRepo.findById(id);
        if (byId.isPresent()) {
            SpaceView spaceView = byId.get();
            Space space = spaceRepo.findById(spaceViewDto.getSpace()).get();
            spaceView.setSpace(space);
            View view = viewRepo.findById(spaceViewDto.getView()).get();
            spaceView.setView(view);
            spaceViewRepo.save(spaceView);
            return new Result(true, "Space View Updated");
        }
        return new Result(false, "Space View Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<SpaceView> byId = spaceViewRepo.findById(id);
        if (byId.isPresent()) {
            spaceViewRepo.delete(byId.get());
            return new Result(true, "Space View Deleted");
        }
        return new Result(true, "Space View Id not found");
    }
}
