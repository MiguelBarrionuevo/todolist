package bo.edu.ucb.ingsoftware.todolist.controller;

import bo.edu.ucb.ingsoftware.todolist.model.User;
import bo.edu.ucb.ingsoftware.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        // Almacena la contraseña en texto plano (NO recomendado para producción)
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/authenticate")
    public String authenticateUser(@RequestBody User user) {
        // Compara las contraseñas en texto plano (NO recomendado para producción)
        return userService.authenticateUser(user.getUsername(), user.getPassword());
    }

}
