package bo.edu.ucb.ingsoftware.todolist.controller;

import bo.edu.ucb.ingsoftware.todolist.model.Tag;
import bo.edu.ucb.ingsoftware.todolist.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("/")
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @GetMapping("/{tagId}")
    public Optional<Tag> getTagById(@PathVariable Long tagId) {
        return tagService.getTagById(tagId);
    }

    @GetMapping("/")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long tagId, @RequestBody Tag updatedTag) {
        Optional<Tag> updated = tagService.updateTag(tagId, updatedTag);

        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable Long tagId) {
        tagService.deleteTag(tagId);
    }
}
