package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public User create(UserDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return repo.save(user);
    }

    public User update(Integer id, UserDTO dto) {

        User user = repo.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return repo.save(user);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
    // Metodo derivado
    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }
    
    // JPQL
    public User buscarPorEmail(String email) {
        return repo.buscarPorEmail(email);
    }
    
    // Named Query
    public List<User> searchByName(String name) {
        return repo.searchByName(name);
    }

}
