package bo.edu.ucb.ingsoftware.todolist.controller;

import bo.edu.ucb.ingsoftware.todolist.model.Task;
import bo.edu.ucb.ingsoftware.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/")
    public List<Task> getAllTasks(){
        return taskService.getAllTask();
    }

    @GetMapping(value = "/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id).orElse(null);
    }

    @PostMapping(value = "/")
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping(value = "/{id}/complete")
    public void markTaskAsCompleted(@PathVariable Long id){
        taskService.markTaskAsCompleted(id);
    }

    @PutMapping(value = "/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updateTask){
        Task task = taskService.updateTask(id,updateTask);
        if (task != null){
            return task;
        }else{
            //Envio de Errores especificos
            return null;
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable Long id){
            taskService.deleteTask(id);
    }
}
