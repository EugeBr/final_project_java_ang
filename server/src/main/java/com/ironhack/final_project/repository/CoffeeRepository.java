package com.ironhack.final_project.repository;

import com.ironhack.final_project.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

    List<Coffee> findAllByNameContaining(String str);

    Optional<Coffee> findByName(String name);

    @Query(value = "SELECT * FROM coffee WHERE created_by = :idParam",
            nativeQuery = true)
    List<Coffee> findAllByUserIdParam(@Param("idParam") Integer id);
}
