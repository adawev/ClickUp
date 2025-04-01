package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.UserDto;
import diyor.adawev.clickup.dto.WorkspaceDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.model.Workspace;
import diyor.adawev.clickup.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {
    @Autowired
    WorkspaceService workspaceService;

    @GetMapping
    public List<Workspace> getAll() {
        return workspaceService.getAll();
    }
    @GetMapping("/{id}")
    public Workspace getById(@PathVariable Integer id) {
        return workspaceService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody WorkspaceDto workspaceDto) {
        return workspaceService.create(workspaceDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody WorkspaceDto workspaceDto) {
        return workspaceService.update(id, workspaceDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return workspaceService.delete(id);
    }

}
