package bo.edu.ucb.ingsoftware.todolist.repository;

import bo.edu.ucb.ingsoftware.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
