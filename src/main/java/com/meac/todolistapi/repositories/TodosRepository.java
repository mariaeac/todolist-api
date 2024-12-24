package com.meac.todolistapi.repositories;

import com.meac.todolistapi.entities.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodosRepository extends JpaRepository<Todos, Long> {
    List<Todos> findByUserId(Long userId);
}
