package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
