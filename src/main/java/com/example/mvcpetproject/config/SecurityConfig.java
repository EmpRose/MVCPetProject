package com.example.mvcpetproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // Конфигурация безопасности через SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Отключаем CSRF для API
                .authorizeHttpRequests()
                .requestMatchers("/pets/**").authenticated()  // Защищаем все методы "/pets"
                .anyRequest().permitAll()  // Разрешаем все остальные запросы
                .and()
                .httpBasic();  // Используем базовую аутентификацию (будет заменено на JWT в будущем)
        return http.build();
    }

    // Метод для создания PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Настройка пользователей
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user") // Логин
                        .password(passwordEncoder().encode("password")) // Пароль
                        .roles("USER") // Роль
                        .build(),
                User.withUsername("admin") // Второй пользователь
                        .password(passwordEncoder().encode("admin")) // Пароль
                        .roles("ADMIN") // Роль
                        .build()
        );
    }
}
