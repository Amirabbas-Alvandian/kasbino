package com.kasbino.bootcamp.config.security;

import com.kasbino.bootcamp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class securityConfig {

    private final AdminService adminService;
    private final BCryptPasswordEncoder passwordEncoder;

    public securityConfig(AdminService adminService, BCryptPasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
               .cors(AbstractHttpConfigurer::disable)
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(a -> a.requestMatchers("/directory/**").permitAll())
               .authorizeHttpRequests(a -> a.requestMatchers("/admin/register").permitAll())
               .authorizeHttpRequests(a -> a.requestMatchers("/admin/add-user")
                       .hasRole("ADMIN"))

               .httpBasic(withDefaults())
               .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(adminService::findByUsername
        ).passwordEncoder(passwordEncoder);
    }

}
