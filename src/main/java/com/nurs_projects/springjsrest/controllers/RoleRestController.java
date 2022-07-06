package com.nurs_projects.springjsrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nurs_projects.springjsrest.model.Role;
import com.nurs_projects.springjsrest.services.RoleService;

import java.util.List;

@RestController
@RequestMapping("api/roles")
@CrossOrigin
public class RoleRestController {
    private final RoleService roleService;

    @Autowired
    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    ResponseEntity<List<Role>>getAllRoles(){
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Role> getRoleById(@PathVariable("id") Long id){
        return new ResponseEntity<>(roleService.getRole(id), HttpStatus.OK);
    }
}