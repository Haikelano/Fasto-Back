package com.comunication.fasto.config;

import com.comunication.fasto.security.JWTAuthenticationFilter;
import com.comunication.fasto.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AuthentificationConfig<Autowired> extends WebSecurityConfigurerAdapter {
    @Qualifier
     private UserDetailsService userDetailsService;
     private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthentificationConfig() {
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*BCryptPasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication()
                .withUser("admin").password(encoder.encode("1234")).roles("ADMIN","USER");*/

        /*auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);*/
    }
    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        security.httpBasic().disable();
        security.csrf().disable();//annuler l'utilisation de csrf (csrf: c,est un password qui utilise spring pour s'authentifier )
        //security.formLogin();
        security.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//deactiver l'implementation du token dans la ssesion
        security.authorizeRequests().antMatchers(HttpMethod.POST,"/**").permitAll();//(permter que au  Role ADMIN accese a /user avec post)
        security.authorizeRequests().antMatchers(HttpMethod.POST,"/login/**").permitAll();

        security.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        security.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        //security.authorizeRequests().anyRequest().authenticated();
    }


}