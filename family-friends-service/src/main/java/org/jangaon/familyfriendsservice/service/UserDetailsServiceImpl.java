/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.service;

import org.jangaon.familyfriendsservice.entity.AppUser;
import org.jangaon.familyfriendsservice.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optionalAppUser = appUserRepository.findByUserName(username);
        if(optionalAppUser.isEmpty())
            throw new UsernameNotFoundException("This give user :: " + username + " :: does not exist");
        return new UserDetailsImpl(optionalAppUser.get());
    }

}
