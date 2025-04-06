package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.WorkspaceRoleDto;
import diyor.adawev.clickup.dto.WorkspaceUserDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.WorkspaceRole;
import diyor.adawev.clickup.model.WorkspaceUser;
import diyor.adawev.clickup.service.WorkspaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace-user")
public class WorkspaceUserController {
    @Autowired
    WorkspaceUserService workspaceUserService;

    @GetMapping
    public List<WorkspaceUser> getAll() {
        return workspaceUserService.getAll();
    }
    @GetMapping("/{id}")
    public WorkspaceUser getById(@PathVariable Integer id) {
        return workspaceUserService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody WorkspaceUserDto workspaceUserDto) {
        return workspaceUserService.create(workspaceUserDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody WorkspaceUserDto workspaceUserDto) {
        return workspaceUserService.update(id, workspaceUserDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return workspaceUserService.delete(id);
    }

}
