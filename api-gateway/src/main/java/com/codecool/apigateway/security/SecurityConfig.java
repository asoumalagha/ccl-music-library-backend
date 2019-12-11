package com.codecool.apigateway.security;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
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
                .antMatchers("musicservice/songs").permitAll()
                .antMatchers(HttpMethod.GET, "musicservice/songs/search/**").permitAll()
                .antMatchers(HttpMethod.GET,"musicservice/songs/user/**").authenticated()
                .antMatchers(HttpMethod.POST,"musicservice/songs/user/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"musicservice/songs/user/**").authenticated()
                .antMatchers(HttpMethod.OPTIONS,"musicservice/songs/user/**").permitAll()
                .antMatchers("musicservice/registration").permitAll()// allowed by anyone
                .antMatchers("musicservice/auth/signin").permitAll()
                .antMatchers( "musicservice/user/add").permitAll()
                .antMatchers( "musicservice/user/delete").authenticated()
                .antMatchers( "musicservice/user/list").authenticated()// allowed by anyone
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
