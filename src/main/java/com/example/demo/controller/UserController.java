package com.example.demo.controller;

import java.util.Enumeration;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public User create(@RequestBody UserDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public User update(
            @PathVariable Integer id,
            @RequestBody UserDTO dto
    ) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    
    // Buscar por método derivado del Repository
    @GetMapping("/email/{email}")
    public User getByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }
    
    // Usando JPQL
    @GetMapping("/buscaremail/{email}")
    public User buscarPorEmail(@PathVariable String email) {
        return service.buscarPorEmail(email);
    }
    
    
    // Usando Named Queries
    @GetMapping("/searchbyname/{name}")
    public List<User> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }
    
    @GetMapping("/buscarpornombre")
    public List<User> buscarPorNombre(@RequestParam String name, HttpServletRequest request) {
    	// URL completa
        System.out.println("URL: " + request.getRequestURL());

        // Query params
        System.out.println("Query: " + request.getQueryString());

        // Método HTTP
        System.out.println("Método: " + request.getMethod());

        // Headers
        Enumeration<String> headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            System.out.println(header + ": " + request.getHeader(header));
        }
        return service.searchByName(name);
    }

}
