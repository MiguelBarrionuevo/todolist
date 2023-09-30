package bo.edu.ucb.ingsoftware.todolist.repository;

import bo.edu.ucb.ingsoftware.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
