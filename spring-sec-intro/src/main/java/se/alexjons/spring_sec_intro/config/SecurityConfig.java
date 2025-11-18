package se.alexjons.spring_sec_intro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig { // The /config directory is automatically scanned for

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSec) throws Exception { // Filter chain for security
        httpSec
                .csrf(csrf -> csrf.disable()) // Disabled CSRF to allow POST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // Allow everything under /public
                        .requestMatchers("/private/**").authenticated()) // Require auth under /private
                .httpBasic(Customizer.withDefaults());

        return httpSec.build();
    }

    @Bean
    public UserDetailsService userDetailsService() { // In-memory users
        UserDetails user = User
                .withUsername("student")
                .password(passwordEncoder().encode("password")) // Use our encoding for passwords
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder().encode("admin")) // Use our encoding for passwords
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() { // Plain-text is not allowed, so we set a standard encoder
        return new BCryptPasswordEncoder();
    }
}
