package com.site.gamingblog.config;

import com.site.gamingblog.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class Auth extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService myUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/account", "/addCommentToTheGamePost", "/addCommentToTheNews", "/userImageDefault")
                .hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/gamesList","/addGame", "/editGame/{id}", "/userList",
                        "/deleteGame/{id}", "/newsList","/addNews", "/editNews/{id}", "/deleteNews/{id}",
                        "/userStatus/{id}", "/upload")
                .hasAnyAuthority("ADMIN")
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }
}