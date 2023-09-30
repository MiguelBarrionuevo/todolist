package bo.edu.ucb.ingsoftware.todolist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tags", schema = "tagsystem")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
