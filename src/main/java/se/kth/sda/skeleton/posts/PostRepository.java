package se.kth.sda.skeleton.posts;

/*
    @TODO extend the appropriate JpaRepository to get common database operations for Post
    Add also the correct annotation to describe the Repository.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
