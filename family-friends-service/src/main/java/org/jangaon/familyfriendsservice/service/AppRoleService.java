/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.service;

import org.jangaon.familyfriendsservice.config.AspectConfig;
import org.jangaon.familyfriendsservice.entity.AppUser;
import org.jangaon.familyfriendsservice.entity.AppUserRoles;
import org.jangaon.familyfriendsservice.modle.request.RoleForm;
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

@Service
public class AppRoleService {

    private static final Logger logger = LoggerFactory.getLogger(AppUserRoles.class);

    @Autowired
    AppUserRolesRepository appUserRolesRepository;

    public ResponseEntity<GeneralResponse> save(RoleForm roleForm) {
        GeneralResponse generalResponse = new GeneralResponse();
        HttpStatus httpStatus;
        try {
            Set<AppUserRoles> appUserRolesSet = new HashSet<>();
            AppUserRoles appUserRolesObject = new AppUserRoles();
            appUserRolesObject.setRoleName(roleForm.getRoleName());
            logger.info("checking if role name exists, roleName :: " + roleForm.getRoleName());
            if(appUserRolesRepository.existsByRoleName(roleForm.getRoleName())) {
                logger.error("given role name already exists, roleName :: " + roleForm.getRoleName());
                generalResponse.setMessage("role with same name already exists");
                generalResponse.setSuccess(false);
                httpStatus = HttpStatus.BAD_REQUEST;
            } else {
                logger.info("given role name doesn't exists, so creating roleName :: " + roleForm.getRoleName());
                appUserRolesRepository.save(appUserRolesObject);
                appUserRolesSet.add(appUserRolesObject);
                generalResponse.setMessage("role created successfully!");
                generalResponse.setSuccess(true);
                generalResponse.setResponseObject(appUserRolesSet);
                httpStatus = HttpStatus.OK;
            }
        } catch (Exception ex) {
            generalResponse.setMessage("failed to register role, with ex :: " + ex.getMessage());
            generalResponse.setSuccess(false);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(generalResponse, httpStatus);
    }

    public ResponseEntity<GeneralResponse> findAll() {
        GeneralResponse generalResponse = new GeneralResponse();
        HttpStatus httpStatus;
        try {
            List<AppUserRoles> appUserRoles = appUserRolesRepository.findAll();
            if (!appUserRoles.isEmpty()) {
                generalResponse.setMessage("roles found successfully!");
                generalResponse.setSuccess(true);
                generalResponse.setResponseObject(appUserRoles);
                httpStatus = HttpStatus.OK;
            } else {
                generalResponse.setMessage("no roles found");
                generalResponse.setSuccess(false);
                httpStatus = HttpStatus.NOT_FOUND;
            }
        } catch (Exception ex) {
            generalResponse.setMessage("failed to fetch roles, with ex :: " + ex.getMessage());
            generalResponse.setSuccess(false);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(generalResponse, httpStatus);
    }

//    public ResponseEntity<GeneralResponse> findById(String id) {
//        GeneralResponse generalResponse = new GeneralResponse();
//        HttpStatus httpStatus;
//        try {
//            Optional<AppUser> optionalAppUser = userRepository.findById(id);
//            if (!optionalAppUser.isEmpty()) {
//                generalResponse.setMessage("user found successfully!");
//                generalResponse.setSuccess(true);
//                generalResponse.setResponseObject(optionalAppUser.get());
//                httpStatus = HttpStatus.OK;
//            } else {
//                generalResponse.setMessage("user not found");
//                generalResponse.setSuccess(false);
//                httpStatus = HttpStatus.NOT_FOUND;
//            }
//        } catch (Exception ex) {
//            generalResponse.setMessage("failed to fetch user, with ex :: " + ex.getMessage());
//            generalResponse.setSuccess(false);
//            httpStatus = HttpStatus.BAD_REQUEST;
//        }
//        return new ResponseEntity<>(generalResponse, httpStatus);
//    }

//    public ResponseEntity<GeneralResponse> updateById(String id, UserForm userForm) {
//        GeneralResponse generalResponse = new GeneralResponse();
//        HttpStatus httpStatus;
//        try {
//            Optional<AppUser> optionalAppUser = userRepository.findById(id);
//            if (!optionalAppUser.isEmpty()) {
//                BeanUtils.copyProperties(userForm, optionalAppUser);
//                generalResponse.setMessage("user updated successfully!");
//                generalResponse.setSuccess(true);
//                generalResponse.setResponseObject(optionalAppUser);
//                httpStatus = HttpStatus.OK;
//            } else {
//                generalResponse.setMessage("user not found");
//                generalResponse.setSuccess(false);
//                httpStatus = HttpStatus.NOT_FOUND;
//            }
//        } catch (Exception ex) {
//            generalResponse.setMessage("failed to update user, with ex :: " + ex.getMessage());
//            generalResponse.setSuccess(false);
//            httpStatus = HttpStatus.BAD_REQUEST;
//        }
//        return new ResponseEntity<>(generalResponse, httpStatus);
//    }


}
