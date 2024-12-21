package com.meac.todolistapi.config;

import com.meac.todolistapi.entities.Todos;
import com.meac.todolistapi.entities.User;
import com.meac.todolistapi.repositories.TodosRepository;
import com.meac.todolistapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;


@Configuration
@Profile("test")


public class TestConfig implements CommandLineRunner {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodosRepository todosRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Test", "12345");
        userRepository.save(user1);

        Todos task = new Todos(null, "Test1", "Test1", user1);
        Todos task2 = new Todos(null, "Test2", "Test2", user1);

        todosRepository.saveAll(Arrays.asList(task, task2));





    }


    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth ->
                            auth.requestMatchers("/h2-console/**").permitAll()
                    )
                    .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                    .headers(headers -> headers
                            .frameOptions(frameOptions -> frameOptions.sameOrigin())
                    );

            return http.build();
        }
    }

}
