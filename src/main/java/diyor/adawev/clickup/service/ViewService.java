package diyor.adawev.clickup.service;

import diyor.adawev.clickup.dto.ViewDto;
import diyor.adawev.clickup.model.Icon;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.View;
import diyor.adawev.clickup.repository.IconRepo;
import diyor.adawev.clickup.repository.ViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViewService {
    @Autowired
    ViewRepo viewRepo;
    @Autowired
    IconRepo iconRepo;


    public List<View> getAll(){
        return viewRepo.findAll();
    }
    public View getById(Integer id){
        return viewRepo.findById(id).get();
    }

    public Result create(ViewDto viewDto) {
        View view = new View();
        view.setName(viewDto.getName());
        Icon icon = iconRepo.findById(viewDto.getIcon_id()).get();
        view.setIcon((List<Icon>) icon);
        viewRepo.save(view);
        return new Result(true, "View Created");
    }

    public Result update(Integer id, ViewDto viewDto) {
        Optional<View> byId = viewRepo.findById(id);
        if (byId.isPresent()) {
            View view = byId.get();
            view.setName(viewDto.getName());
            Icon icon = iconRepo.findById(viewDto.getIcon_id()).get();
            view.setIcon((List<Icon>) icon);
            viewRepo.save(view);
            return new Result(true, "View Updated");
        }
        return new Result(false, "View Id Not Found");
    }

    public Result delete(Integer id) {
        Optional<View> byId = viewRepo.findById(id);
        if (byId.isPresent()) {
            viewRepo.delete(byId.get());
            return new Result(true, "View Deleted");
        }
        return new Result(true, "View Id not found");
    }
}
