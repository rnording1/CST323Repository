package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import com.gcu.business.UserBusinessService;

@Configuration
public class SecurityConfig {

    private final UserBusinessService userBusinessService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public SecurityConfig(UserBusinessService userBusinessService, BCryptPasswordEncoder passwordEncoder) {
        this.userBusinessService = userBusinessService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
    		.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/register", "/login", "/error", "/resources/**", "/css/**", "/js/**", "/img/**", "/favicon.ico").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .failureUrl("/login?error=true")
                    .permitAll()
            )
            .logout(logout -> logout
            		.logoutUrl("/logout")
            		.logoutSuccessUrl("/login?logout")
                    .permitAll()
            );
        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth
            .userDetailsService(userBusinessService)
            .passwordEncoder(passwordEncoder);
    }
}
