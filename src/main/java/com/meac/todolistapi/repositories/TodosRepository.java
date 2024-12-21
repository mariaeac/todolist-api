package com.meac.todolistapi.repositories;

import com.meac.todolistapi.entities.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosRepository extends JpaRepository<Todos, Long> {
}
