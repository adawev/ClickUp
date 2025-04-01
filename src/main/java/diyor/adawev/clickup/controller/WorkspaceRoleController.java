package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.WorkspaceDto;
import diyor.adawev.clickup.dto.WorkspaceRoleDto;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.Workspace;
import diyor.adawev.clickup.model.WorkspaceRole;
import diyor.adawev.clickup.service.WorkspaceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace-role")
public class WorkspaceRoleController {
    @Autowired
    WorkspaceRoleService workspaceRoleService;

    @GetMapping
    public List<WorkspaceRole> getAll() {
        return workspaceRoleService.getAll();
    }
    @GetMapping("/{id}")
    public WorkspaceRole getById(@PathVariable Integer id) {
        return workspaceRoleService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody WorkspaceRoleDto workspaceRoleDto) {
        return workspaceRoleService.create(workspaceRoleDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody WorkspaceRoleDto workspaceRoleDto) {
        return workspaceRoleService.update(id, workspaceRoleDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return workspaceRoleService.delete(id);
    }

}
