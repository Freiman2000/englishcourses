package by.englishcourses.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String firstName;
//    private String secondName;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "image_id")
//    private Image image;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    @ManyToMany
    private List<Lesson> lessons = new ArrayList<>();

    public Teacher addStudentToTeacher(Student student) {
        student.setTeacher(this);
        students.add(student);
        return this;
    }

    public Teacher addLessonToTeacher(Lesson lesson) {
        lessons.add(lesson);
        return this;
    }

    public Teacher deleteLessonToTeacher(Lesson lesson) {
        lessons.remove(lesson);
        return this;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", students=" + students +
                ", lessons=" + lessons +
                '}';
    }
}
