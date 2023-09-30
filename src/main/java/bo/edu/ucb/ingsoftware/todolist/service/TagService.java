package bo.edu.ucb.ingsoftware.todolist.service;

import bo.edu.ucb.ingsoftware.todolist.model.Tag;
import bo.edu.ucb.ingsoftware.todolist.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Optional<Tag> getTagById(Long tagId) {
        return tagRepository.findById(tagId);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }
    public Optional<Tag> updateTag(Long tagId, Tag updatedTag) {
        Optional<Tag> existingTag = tagRepository.findById(tagId);
        if (existingTag.isPresent()) {
            Tag tagToUpdate = existingTag.get();
            tagToUpdate.setName(updatedTag.getName());
            return Optional.of(tagRepository.save(tagToUpdate));
        } else {
            return Optional.empty();
        }
    }
}
