/**
 * @author Santhosh M
 * @created on 18/12/2020
 * @description Class for testing
 * @version number Java-logger-library v1.0
 */

package org.jangaon.familyfriendsservice.config;

import org.jangaon.familyfriendsservice.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfigNewer {

    /*
        1. suitable only for spring security version is or above 5.7
        2. below are spring security related dependencies for self-knowledge
        eg: spring-boot-starter-parent should be of 2.7.2
        org.springframework.security:spring-security-config:jar:5.7.2:compile
        org.springframework.security:spring-security-core:jar:5.7.2:compile
        org.springframework.security:spring-security-web:jar:5.7.2:compile
        3. rest userDetails and userService are still same
     */


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/fAndFServices/admin/").hasRole("ADMIN")
                .antMatchers("/fAndFServices/appUser/").hasAnyRole("ADMIN", "USER")
                .antMatchers("/fAndFServices/appRoles/").hasAnyRole("ADMIN", "USER")
                .antMatchers("/fAndFServices/appUser/register").permitAll()
                .anyRequest().authenticated()
                .and().cors().and()
                .csrf().disable() //disable csrf, will allow http methods like POST/PUT .. etc
                .formLogin().disable()
                .httpBasic(); //formLogin, will give "Please Login Form", but httpBasic, will not, (know what is -- httpBasic(withDefaults()))
        return http.build();
    }

}
