package com.example.OpenAPI.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User API", description = "API for managing users")
public class UserController {

    private List<String> users = new ArrayList<>(List.of("Alice", "Bob", "Charlie"));

    @GetMapping
    @Operation(summary = "Get all users", description = "Returns a list of all users")
    public List<String> getUsers() {
        return users;
    }

    @PostMapping("/add")
    @Operation(summary = "Insert a new user", description = "Adds a new user to the list")
    public String insertUser(@RequestParam String name) {
        users.add(name);
        return "User " + name + " added!";
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete a user", description = "Removes a user from the list by name")
    public String deleteUser(@RequestParam String name) {
        if (users.remove(name)) {
            return "User " + name + " deleted!";
        } else {
            return "User " + name + " not found!";
        }
    }
    
    @PutMapping("/{index}")
    @Operation(summary = "Insert a user ", description = "Insert a user in the list at particular index")
    public String updateUser(@PathVariable int index, @RequestParam String name)
    {
        users.set(index,name);
        return "User updated at index " + index + ": " + name;
    }
    

}
