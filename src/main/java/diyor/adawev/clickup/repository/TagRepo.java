package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, Integer> {
}
