/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "APP_USER")
public class AppUser {

    @Id
    @Column(name = "APP_USER_ID", nullable = false)
    private String userId;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_roles")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // @ElementCollection (lazy gone when fetch = FetchType.EAGER)
    @JoinTable(name = "user_join_roles",
            joinColumns = { @JoinColumn(name = "APP_USER_ID", referencedColumnName = "APP_USER_ID")},
            inverseJoinColumns = { @JoinColumn(name = "APP_USER_ROLES_ID", referencedColumnName = "APP_USER_ROLES_ID")}
    )
    private Set<AppUserRoles> userRoles = new HashSet<>(); // default fetch is LAZY

    public AppUser() {
    }

    public AppUser(String userId, String userName, String userPassword, String userEmail, String userPhone, Set<AppUserRoles> userRoles) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userRoles = userRoles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
