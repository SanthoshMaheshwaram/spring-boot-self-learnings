package org.jangaon.familyfriendsservice.repository;

import org.jangaon.familyfriendsservice.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

    Optional<AppUser> findByUserName(String userName);

}
