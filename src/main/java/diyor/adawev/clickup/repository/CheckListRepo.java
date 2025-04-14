package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckListRepo extends JpaRepository<CheckList, Integer> {
}
