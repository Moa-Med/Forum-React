package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/*
    @TODO AutoWire PostService and create the methods needed to implement the API.
    Don't forget to add necessary annotations.
 */

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/posts/{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/posts")
    public Post save(@RequestBody Post newPost) {
        return postService.save(newPost);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Long id) {
        postService.deleteById(id);
    }

    @PutMapping("/tasks/{id}") //not sure about this implementation on Service side, maybe it needs to be also by id
    public Post update(@PathVariable Post updatedPost) {
        return postService.update(updatedPost)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
