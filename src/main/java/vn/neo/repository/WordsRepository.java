package vn.neo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.neo.entity.Words;

public interface WordsRepository extends JpaRepository<Words, Long> {
}
