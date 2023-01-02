package org.jangaon.familyfriendsservice.repository;

import org.jangaon.familyfriendsservice.entity.AppUserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRolesRepository extends JpaRepository<AppUserRoles, Long> {
    boolean existsByRoleName(String roleName);

    Optional<AppUserRoles> findByRoleName(String roleName);
}
