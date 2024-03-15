package com.rupesh.todo.repo;

import com.rupesh.todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
    @Query("SELECT p FROM Todo p WHERE " +
            "p.name LIKE CONCAT('%',:query, '%')" +
            "Or p.about LIKE CONCAT('%', :query, '%')")
    List<Todo> searchProducts(String query);
}
