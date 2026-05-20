package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	// método derivado
    User findByName(String name);
    
    // método derivado
    User findByEmail(String email);

    // Ejemplo de JPQL, siempre esta en el Repository
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User buscarPorEmail(String email);

    // Haciendo uso de NamedQuery
    List<User> searchByName(String name);
    
}
