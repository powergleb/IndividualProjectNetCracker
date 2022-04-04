package diary.dao.repositories;

import diary.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

}