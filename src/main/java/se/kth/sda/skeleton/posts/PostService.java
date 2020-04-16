package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
    @TODO Autowire the PostRepository and use it to implement all the service methods.
 */
@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Optional<Post> getByID(Long id) {
        // @TODO get a post by ID if it exists
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        // @TODO save the post to DB and return the saved post
        return postRepository.save(post);
    }

    public Post update(Post post) {
        // @TODO update the post if it exists in DB and return the updated post.
        return postRepository.save(post);
    }

    public void deleteById(Long id) {
        // @TODO delete the post by id
        postRepository.deleteById(id);
    }
}
