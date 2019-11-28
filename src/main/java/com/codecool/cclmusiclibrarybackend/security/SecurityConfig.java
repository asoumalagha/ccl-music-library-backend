package com.codecool.cclmusiclibrarybackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenServices jwtTokenServices;

    public SecurityConfig(JwtTokenServices jwtTokenServices) {
        this.jwtTokenServices = jwtTokenServices;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //TODO set up proper antMatchers
                .antMatchers("/songs").permitAll()
                .antMatchers("/registration").permitAll()// allowed by anyone
                .antMatchers("/auth/signin").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/songs/search/**").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/songs/list").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.POST, "/songs/add").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.DELETE, "/songs/**").authenticated() // allowed only when signed in
                .antMatchers( "/user/add").permitAll()
                .antMatchers(HttpMethod.GET,"/user/**").authenticated()
                .anyRequest().denyAll() // anything else is denied
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenServices), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
