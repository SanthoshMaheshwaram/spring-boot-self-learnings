/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.controller;

import org.jangaon.familyfriendsservice.modle.request.RoleForm;
import org.jangaon.familyfriendsservice.modle.request.UserForm;
import org.jangaon.familyfriendsservice.modle.response.GeneralResponse;
import org.jangaon.familyfriendsservice.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/fAndFServices/appRoles")
public class RoleController {

    @Autowired
    AppRoleService appRoleService;

    @PostMapping()
    public ResponseEntity<GeneralResponse> saveRole(@RequestBody RoleForm roleForm) {
        return appRoleService.save(roleForm);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<GeneralResponse> listAllAppUsers(@PathVariable String id) {
//        return appRoleService.findById(id);
//    }

    @GetMapping()
    public ResponseEntity<GeneralResponse> listAllAppRoles() {
        return appRoleService.findAll();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<GeneralResponse> updateAppUser(@PathVariable String id, @RequestBody UserForm userForm) {
//        return appRoleService.updateById(id, userForm);
//    }


}
