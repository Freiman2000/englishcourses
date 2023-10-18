package by.englishcourses.controllers;

import by.englishcourses.models.Lesson;
import by.englishcourses.models.Student;
import by.englishcourses.models.Teacher;
import by.englishcourses.repositories.LessonRepository;
import by.englishcourses.repositories.StudentRepository;
import by.englishcourses.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    @GetMapping("/add")
    public String add() {
        Teacher teacher = teacherRepository.getTeacherById(3L);
        Student student = studentRepository.getStudentById(3L);
        Lesson lesson = new Lesson();
        lessonRepository.save(lesson);
        teacher.addLessonToTeacher(lesson);
        student.addLessonToStudent(lesson);
        lessonRepository.save(lesson);
        return "index";
    }

    @GetMapping("/del")
    public String del() {
        Lesson lesson = lessonRepository.getLessonById(2L);
        Student student = studentRepository.getStudentById(3L);
        student.deleteLessonToTeacher(lesson);
        studentRepository.save(student);
        return "index";
    }
}
