package com.ironhack.final_project.repository;

import com.ironhack.final_project.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

    List<Coffee> findAllByCreatedBy(Integer id);
    List<Coffee> findAllByNameContaining(String str);
}
