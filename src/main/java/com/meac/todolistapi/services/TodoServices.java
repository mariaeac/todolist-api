package com.meac.todolistapi.services;

import com.meac.todolistapi.entities.Todos;
import com.meac.todolistapi.entities.User;
import com.meac.todolistapi.repositories.TodosRepository;
import com.meac.todolistapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {

    @Autowired
    private TodosRepository todosRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Todos> findTasksByUserId(Long userId) {
        return todosRepository.findByUserId(userId);
    }

    public Todos create(Todos task, Long userId) {

    }


}
