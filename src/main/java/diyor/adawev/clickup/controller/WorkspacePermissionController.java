package diyor.adawev.clickup.controller;

import diyor.adawev.clickup.dto.ClickAppDto;
import diyor.adawev.clickup.dto.WorkspacePermissionDto;
import diyor.adawev.clickup.model.ClickApp;
import diyor.adawev.clickup.model.Result;
import diyor.adawev.clickup.model.WorkspacePermission;
import diyor.adawev.clickup.service.WorkspacePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace-permission")
public class WorkspacePermissionController {
    @Autowired
    WorkspacePermissionService workspacePermissionService;

    @GetMapping
    public List<WorkspacePermission> getAll() {
        return workspacePermissionService.getAll();
    }
    @GetMapping("/{id}")
    public WorkspacePermission getById(@PathVariable Integer id) {
        return workspacePermissionService.getById(id);
    }
    @PostMapping
    public Result create(@RequestBody WorkspacePermissionDto workspacePermissionDto) {
        return workspacePermissionService.create(workspacePermissionDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody WorkspacePermissionDto workspacePermissionDto) {
        return workspacePermissionService.update(id, workspacePermissionDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return workspacePermissionService.delete(id);
    }
}
