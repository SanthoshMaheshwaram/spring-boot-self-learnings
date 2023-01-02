/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.service;

import org.jangaon.familyfriendsservice.entity.AppUser;
import org.jangaon.familyfriendsservice.entity.AppUserRoles;
import org.jangaon.familyfriendsservice.modle.request.UserForm;
import org.jangaon.familyfriendsservice.modle.response.GeneralResponse;
import org.jangaon.familyfriendsservice.repository.AppUserRepository;
import org.jangaon.familyfriendsservice.repository.AppUserRolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    AppUserRolesRepository appUserRolesRepository;

    private static final Logger logger = LoggerFactory.getLogger(AppUserRoles.class);

    public ResponseEntity<GeneralResponse> save(UserForm userForm) {
        GeneralResponse generalResponse = new GeneralResponse();
        HttpStatus httpStatus;
        try {
            String userId = UUID.randomUUID().toString();
            AppUser appUserObject = new AppUser();
            appUserObject.setUserId(userId);
            appUserObject.setUserName(userForm.getUserName());
            appUserObject.setUserPassword(userForm.getUserPassword());
            appUserObject.setUserEmail(userForm.getUserEmail());
            appUserObject.setUserPhone(userForm.getUserPhone());
            userForm.getUserRoles().forEach(role -> {
                logger.info("checking if role name exists, roleName :: " + role.getRoleName());
//                if (appUserRolesRepository.existsByRoleName(role.getRoleName())) {
//                    logger.info("given role name already exists, so update it with users, roleName :: " + role.getRoleName());
//                    Optional<AppUserRoles> optionalAppRoles = appUserRolesRepository.findByRoleName(role.getRoleName());
//                    AppUserRoles appUserRolesObject = optionalAppRoles.get();
//                    appUserRolesObject.setAppUser(appUserObject);
//                    appUserObject.getUserRoles().add(appUserRolesObject);
//                    appUserRolesRepository.save(appUserRolesObject);
//                } else {
                    logger.info("given role doesn't exists, so creating role first and adding users to it, roleName :: " + role.getRoleName());
                    AppUserRoles appUserRolesObject = new AppUserRoles();
                    appUserRolesObject.setRoleName(role.getRoleName());
//                    appUserRolesObject.setAppUser(appUserObject);
                    appUserObject.getUserRoles().add(appUserRolesObject);
                    appUserRolesRepository.save(appUserRolesObject);
//                }
            });
            AppUser appUser = userRepository.save(appUserObject);
            generalResponse.setMessage("user registered successfully!");
            generalResponse.setSuccess(true);
            generalResponse.setResponseObject(appUser);
            httpStatus = HttpStatus.OK;
        } catch (Exception ex) {
            generalResponse.setMessage("failed to register user, with ex :: " + ex.getMessage());
            generalResponse.setSuccess(false);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(generalResponse, httpStatus);
    }

    public ResponseEntity<GeneralResponse> findAll() {
        GeneralResponse generalResponse = new GeneralResponse();
        HttpStatus httpStatus;
        try {
            List<AppUser> appUserList = userRepository.findAll();
            if (!appUserList.isEmpty()) {
                generalResponse.setMessage("users found successfully!");
                generalResponse.setSuccess(true);
                generalResponse.setResponseObject(appUserList);
                httpStatus = HttpStatus.OK;
            } else {
                generalResponse.setMessage("no users found");
                generalResponse.setSuccess(false);
                httpStatus = HttpStatus.NOT_FOUND;
            }
        } catch (Exception ex) {
            generalResponse.setMessage("failed to fetch users, with ex :: " + ex.getMessage());
            generalResponse.setSuccess(false);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(generalResponse, httpStatus);
    }

    public ResponseEntity<GeneralResponse> findById(String id) {
        GeneralResponse generalResponse = new GeneralResponse();
        HttpStatus httpStatus;
        try {
            Optional<AppUser> optionalAppUser = userRepository.findById(id);
            if (!optionalAppUser.isEmpty()) {
                generalResponse.setMessage("user found successfully!");
                generalResponse.setSuccess(true);
                generalResponse.setResponseObject(optionalAppUser.get());
                httpStatus = HttpStatus.OK;
            } else {
                generalResponse.setMessage("user not found");
                generalResponse.setSuccess(false);
                httpStatus = HttpStatus.NOT_FOUND;
            }
        } catch (Exception ex) {
            generalResponse.setMessage("failed to fetch user, with ex :: " + ex.getMessage());
            generalResponse.setSuccess(false);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(generalResponse, httpStatus);
    }

    public ResponseEntity<GeneralResponse> updateById(String id, UserForm userForm) {
        GeneralResponse generalResponse = new GeneralResponse();
        HttpStatus httpStatus;
        try {
            Optional<AppUser> optionalAppUser = userRepository.findById(id);
            if (!optionalAppUser.isEmpty()) {
                BeanUtils.copyProperties(userForm, optionalAppUser);
                generalResponse.setMessage("user updated successfully!");
                generalResponse.setSuccess(true);
                generalResponse.setResponseObject(optionalAppUser);
                httpStatus = HttpStatus.OK;
            } else {
                generalResponse.setMessage("user not found");
                generalResponse.setSuccess(false);
                httpStatus = HttpStatus.NOT_FOUND;
            }
        } catch (Exception ex) {
            generalResponse.setMessage("failed to update user, with ex :: " + ex.getMessage());
            generalResponse.setSuccess(false);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(generalResponse, httpStatus);
    }
}
