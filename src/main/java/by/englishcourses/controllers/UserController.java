package by.englishcourses.controllers;

import by.englishcourses.models.Student;
import by.englishcourses.models.Teacher;
import by.englishcourses.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final TeacherRepository teacherRepository;

    @GetMapping("/add")
    public String add() {
        teacherRepository.save(new Teacher().addStudentToTeacher(new Student()));
        return "index";
    }
}
