package bo.edu.ucb.ingsoftware.todolist.service;

import bo.edu.ucb.ingsoftware.todolist.model.Task;
import bo.edu.ucb.ingsoftware.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public void markTaskAsCompleted(Long id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        taskOptional.ifPresent(task -> {
            task.setCompleted(true);
            taskRepository.save(task);
        });
    }

    public Task updateTask(Long id, Task updateTask){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()){
            Task task = taskOptional.get();
            task.setName(updateTask.getName());
            task.setName(updateTask.getName());
            task.setLabel(updateTask.getLabel());
            task.setCompleted(updateTask.isCompleted());
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

}
