package bo.edu.ucb.ingsoftware.todolist.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "tasks", schema = "todolist")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Primary Key unico y autoincrementable
    private long id;
    @Column
    private String name;
    @Column
    private Date dueDate;
    @Column
    private String label;
    @Column
    private boolean completed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
