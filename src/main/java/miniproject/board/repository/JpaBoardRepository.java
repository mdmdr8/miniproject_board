package miniproject.board.repository;

import miniproject.board.domain.Boards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBoardRepository extends JpaRepository<Boards, Integer> {
}
