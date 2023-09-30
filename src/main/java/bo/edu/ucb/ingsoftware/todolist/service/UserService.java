package bo.edu.ucb.ingsoftware.todolist.service;

import bo.edu.ucb.ingsoftware.todolist.model.Task;
import bo.edu.ucb.ingsoftware.todolist.model.User;
import bo.edu.ucb.ingsoftware.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        //No deberia alamcenarse el passwor en texto plano
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User updatedUser) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword()); // Almacena la nueva contraseña en texto plano
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public String authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            // Compara las contraseñas en texto plano (NO recomendado para producción)
            if (!password.equals(user.getPassword())) {
                return "Contraseña incorrecta";
            } else {
                return "Acesso Permitido";
            }

        }
        return "Usuario inexistente";
    }
}
