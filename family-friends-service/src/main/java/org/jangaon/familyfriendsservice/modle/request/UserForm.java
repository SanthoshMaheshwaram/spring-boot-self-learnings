/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.modle.request;

import org.jangaon.familyfriendsservice.entity.AppUserRoles;

import java.util.Set;

public class UserForm {

    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private Set<AppUserRoles> userRoles;

    public UserForm() {
    }

    public UserForm(String userName, String userPassword, String userEmail, String userPhone, Set<AppUserRoles> userRoles) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userRoles = userRoles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Set<AppUserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<AppUserRoles> userRoles) {
        this.userRoles = userRoles;
    }
}
