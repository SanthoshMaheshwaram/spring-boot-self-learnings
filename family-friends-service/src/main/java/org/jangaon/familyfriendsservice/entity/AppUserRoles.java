/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "APP_USER_ROLES")
public class AppUserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APP_USER_ROLES_ID", nullable = false)
    private Long roleId;
//    @Column(name = "role_name", unique = true)
    private String roleName;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "APP_USER_APP_USER_ID") // this column will be created by H-JPA if given
//    @JsonIgnore // otherwise, we may get the stack-over-flow while retrieving the 'AppUser' information alone
//    private AppUser appUser;

    public AppUserRoles() {
    }

    public AppUserRoles(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
//        this.appUser = appUser;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

//    public AppUser getAppUser() {
//        return appUser;
//    }
//
//    public void setAppUser(AppUser appUser) {
//        this.appUser = appUser;
//    }
}
