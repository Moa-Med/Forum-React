package se.kth.sda.skeleton.comments;
import se.kth.sda.skeleton.posts.Post;
import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "body")
    private String body;

    @ManyToOne
    private Post post;

    public Comment() {
    }

    public Comment(Long id, String body, Post post) {
        this.id = id;
        this.body = body;
        this.post = post;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
}
