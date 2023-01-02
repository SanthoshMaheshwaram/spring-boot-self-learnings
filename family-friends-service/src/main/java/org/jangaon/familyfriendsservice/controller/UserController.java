/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.controller;

import org.jangaon.familyfriendsservice.modle.request.UserForm;
import org.jangaon.familyfriendsservice.modle.response.GeneralResponse;
import org.jangaon.familyfriendsservice.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/fAndFServices/appUser")
@CrossOrigin(originPatterns = {"http://localhost:8085", "http://localhost:8086"})
public class UserController {

    @Autowired
    AppUserService appAUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<GeneralResponse> registerAppUser(@RequestBody UserForm userForm) {
        userForm.setUserPassword(passwordEncoder.encode(userForm.getUserPassword()));
        return appAUserService.save(userForm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> listAllAppUsers(@PathVariable String id) {
        return appAUserService.findById(id);
    }

    @GetMapping()
    public ResponseEntity<GeneralResponse> listAllAppUsers() {
        return appAUserService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateAppUser(@PathVariable String id, @RequestBody UserForm userForm) {
        return appAUserService.updateById(id, userForm);
    }


}
