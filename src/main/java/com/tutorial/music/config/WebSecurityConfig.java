package com.tutorial.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private static final String[] PUBLIC_PATHS = {
            "/application-user"
    };

    private static final String[] ADMIN_PATHS = {
            "\\/artist"
    };

    private static final String[] USER_PATHS = {
            "/artist/by-name",
            "/artist/by-year",
            "/artist/by-year/from/\\d{4}/to/\\d{4}"
    };

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http.csrf()
                .disable()
            .authorizeRequests()
                .regexMatchers(PUBLIC_PATHS).permitAll()
                .regexMatchers(ADMIN_PATHS).hasRole("ADMIN")
                .regexMatchers(USER_PATHS).hasAnyRole("ADMIN", "USER")
            .anyRequest()
                .authenticated()
            .and()
                .logout()
                .logoutRequestMatcher(new RegexRequestMatcher("\\/logout", "POST"))
            .and()
                .httpBasic();
        // @formatter:on
        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(
            HttpSecurity httpSecurity,
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

}
