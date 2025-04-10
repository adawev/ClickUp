package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
