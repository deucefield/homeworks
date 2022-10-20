package core.lesson9;

import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private List<Course> studentCourses;

    public Student(String name, List<Course> studentCourses) {
        this.name = name;
        this.studentCourses = studentCourses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    @Override
    public String toString() {
        return ("Студент " + name + " учится на курсах: " + studentCourses);
    }
}
