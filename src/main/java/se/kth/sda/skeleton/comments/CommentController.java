package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda.skeleton.auth.AuthService;
import se.kth.sda.skeleton.posts.Post;
import se.kth.sda.skeleton.posts.PostService;
import se.kth.sda.skeleton.user.User;
import se.kth.sda.skeleton.user.UserService;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;


    @GetMapping("posts/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable Long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/posts/comment/email")
    public String getEmail(){
        return authService.getLoggedInUserEmail();
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

    @PostMapping("posts/{postId}/comments/{email}")
    public Comment postComment(@RequestBody Comment comment, @PathVariable Long postId, @PathVariable String email) {
        Post post = postService.getByID(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find post with id " + postId.toString()));
        User user = userService.findUserByEmail(email);
        comment.setUser(user);
        comment.setPost(post);
        return commentService.create(comment);
    }
}
