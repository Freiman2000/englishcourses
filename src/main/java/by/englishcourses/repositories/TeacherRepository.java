package by.englishcourses.repositories;

import by.englishcourses.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher getTeacherById(Long id);
}
