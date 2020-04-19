package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.skeleton.posts.Post;
import se.kth.sda.skeleton.posts.PostService;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping("posts/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable Long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("posts/{postId}/comments/{id}")
    public Comment getCommentsById(@PathVariable Long id) {
       return commentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Could not find post with id " + id.toString()));

    }

    @DeleteMapping("posts/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
       commentService.deleteById(id);
    }

    @PostMapping("posts/{postId}/comments")
    public Comment postComment(@RequestBody Comment comment, @PathVariable Long postId) {
        Post post = postService.getByID(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find post with id " + postId.toString()));
        comment.setPost(post);
        return commentService.create(comment);
    }
}
