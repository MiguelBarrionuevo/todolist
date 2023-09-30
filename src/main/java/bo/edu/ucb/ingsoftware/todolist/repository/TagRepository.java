package bo.edu.ucb.ingsoftware.todolist.repository;

import bo.edu.ucb.ingsoftware.todolist.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
