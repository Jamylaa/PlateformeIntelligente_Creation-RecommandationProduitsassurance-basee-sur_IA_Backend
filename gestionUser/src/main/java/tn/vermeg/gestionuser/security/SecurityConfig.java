package tn.vermeg.gestionuser.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tn.vermeg.gestionuser.config.JwtFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    public SecurityConfig(JwtFilter jwtFilter) {this.jwtFilter = jwtFilter;}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
//                        // Routes publiques (login / auth)
                       .requestMatchers("/api/auth/**").permitAll()
                        // Pour tester sans JWT
                        .requestMatchers("/api/admins/**").permitAll()
                        .requestMatchers("/api/clients/**").permitAll()

                        // Toute autre route doit être authentifiée
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    // Pour l'injection de AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();}
}
//                                .requestMatchers("/api/auth/**").permitAll()
//                                .anyRequest().authenticated() // toutes les autres routes protégées
//@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        // Routes publiques
//                        .requestMatchers("/api/auth/**").permitAll()
//                        // Routes admin
//                        .requestMatchers("/api/clients/**").hasRole("ADMIN")
//                        .requestMatchers("/api/admins/createAdmin").permitAll()
//                        .requestMatchers("/api/admins/**").hasRole("ADMIN")
//                        // Toute autre route doit être authentifiée
//                        .anyRequest().authenticated()
//                )
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }