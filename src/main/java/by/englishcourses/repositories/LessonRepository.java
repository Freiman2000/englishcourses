package by.englishcourses.repositories;

import by.englishcourses.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository  extends JpaRepository<Lesson, Long> {
    Lesson getLessonById(Long id);
}
