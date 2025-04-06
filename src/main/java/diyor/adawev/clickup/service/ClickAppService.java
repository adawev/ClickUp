package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.ClickAppDto;
import diyor.adawev.clickup.dto.SpaceDto;
import diyor.adawev.clickup.model.*;
import diyor.adawev.clickup.repository.ClickAppRepo;
import diyor.adawev.clickup.repository.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClickAppService {
    @Autowired
    ClickAppRepo clickAppRepo;
    @Autowired
    IconRepo iconRepo;

    public List<ClickApp> getAll(){
        return clickAppRepo.findAll();
    }
    public ClickApp getById(Integer id){
        return clickAppRepo.findById(id).get();
    }

    public Result create(ClickAppDto clickAppDto) {
        ClickApp clickApp = new ClickApp();
        clickApp.setName(clickAppDto.getName());
        Icon icon = iconRepo.findById(clickAppDto.getIcon_id()).get();
        clickApp.setIcon((List<Icon>) icon);
        clickAppRepo.save(clickApp);
        return new Result(true, "Click App Created");
    }

    public Result update(Integer id, ClickAppDto clickAppDto) {
        Optional<ClickApp> byId = clickAppRepo.findById(id);
        if (byId.isPresent()) {
            ClickApp clickApp = byId.get();
            clickApp.setName(clickAppDto.getName());
            Icon icon = iconRepo.findById(clickAppDto.getIcon_id()).get();
            clickApp.setIcon((List<Icon>) icon);
            clickAppRepo.save(clickApp);
            return new Result(true, "Click App Updated");
        }
        return new Result(false, "Click Up Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<ClickApp> byId = clickAppRepo.findById(id);
        if (byId.isPresent()) {
            clickAppRepo.delete(byId.get());
            return new Result(true, "Click App Deleted");
        }
        return new Result(true, "Click App Id not found");
    }
}
