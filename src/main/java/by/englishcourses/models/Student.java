package by.englishcourses.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String firstName;
//    private String secondName;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "image_id")
//    private Image image;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    private List<Lesson> lessons = new ArrayList<>();

    public Student addLessonToStudent(Lesson lesson) {
        lessons.add(lesson);
        return this;
    }

    public Student deleteLessonToTeacher(Lesson lesson) {
        lessons.remove(lesson);
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", teacher=" + teacher.getId() +
                ", lessons=" + lessons +
                '}';
    }
}
