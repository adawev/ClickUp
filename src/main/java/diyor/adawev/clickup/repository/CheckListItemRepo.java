package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.CheckListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckListItemRepo extends JpaRepository<CheckListItem, Integer> {
}
