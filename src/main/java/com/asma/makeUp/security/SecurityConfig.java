package com.asma.makeUp.security;


import org.springframework.beans.factory.annotation.Autowired;



import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    //authentification en memory
    /*
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("MED AZIZ").password(passwordEncoder.encode("1234")).roles("USER","AGENT").build(),
                User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("ADMIN").build()
        );
    }*/




    //l'utilisation de l'annotation bean au demarage spring va appeler la methode securityFilterChain()
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.formLogin().loginPage("/login").permitAll()
         .and()
                .authenticationProvider(authenticationProvider);
            httpSecurity.authorizeRequests().requestMatchers("/webjars/**").permitAll();
        httpSecurity.authorizeRequests().requestMatchers("/api/v1/users/**").permitAll();
        httpSecurity.authorizeRequests().requestMatchers("/showCreate").hasAnyRole("ADMIN");
        httpSecurity.authorizeRequests().requestMatchers("/saveTelephone").hasAnyRole("ADMIN");
        httpSecurity.authorizeRequests().requestMatchers("/listeTelephone")
                .hasAnyRole("ADMIN","USER");
        httpSecurity.authorizeRequests()
                .requestMatchers("/supprimerPhone","/modifierPhone","/updatePhone")
                .hasAnyRole("ADMIN");

        httpSecurity.authorizeRequests().anyRequest().authenticated();

        httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");
        httpSecurity.csrf().disable(); // disable CSRF protection

        return httpSecurity.build();
    }
}



