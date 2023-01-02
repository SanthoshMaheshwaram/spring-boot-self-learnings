///**
// * @author Santhosh M
// * @created on 18/12/2020
// * @description Class for testing
// * @version number Java-logger-library v1.0
// */
//
//package org.jangaon.familyfriendsservice.config;
//
//import org.jangaon.familyfriendsservice.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfigOlder extends WebSecurityConfigurerAdapter {
//
//    /*
//        1. suitable only for spring security older than 5.7 version
//        2. below are spring security related dependencies for self-knowledge
//        eg: spring-boot-starter-parent should be of 2.4.2
//        org.springframework.security:spring-security-config:jar:5.4.2:compile
//        org.springframework.security:spring-security-core:jar:5.4.2:compile
//        org.springframework.security:spring-security-web:jar:5.4.2:compile
//        3. rest userDetails and userService are still same
//     */
//
//    @Autowired
//    UserDetailsServiceImpl userDetailsServiceImpl;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(getPasswordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasRole("USER")
//                .antMatchers("/fAndFServices/appUser/register").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable() //disable csrf, will allow http methods like POST/PUT .. etc
//                .httpBasic(); //formLogin, will give "Please Login Form", but httpBasic, will not
//    }
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/ignore1", "/ignore2");
//    }
//
//}
