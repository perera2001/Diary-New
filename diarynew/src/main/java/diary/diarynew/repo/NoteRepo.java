package diary.diarynew.repo;

import diary.diarynew.entity.Note;
import diary.diarynew.entity.User;
import diary.diarynew.service.NoteService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface NoteRepo extends JpaRepository<Note, Integer> {
    List<Note> findByUser(User user);
}
