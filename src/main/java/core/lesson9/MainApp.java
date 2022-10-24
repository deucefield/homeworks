package core.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp {
    static ArrayList<Course> coursesList = new ArrayList<>();
    static String[] courses = {"Основы тестирования ПО", "Техники тест-дизайна",
            "Тестирование WEB", "Java Core", "Автоматизация Web UI на Java", "Основы баз данных",
            "Тестирование backened на Java", "Git. Базовый курс", "Linux. Рабочая станция"};

    public static void main(String[] args) {
        fillList(coursesList);
        List<Student> students = createStudents(10);
        Course example = new Course("Java Core");

        getUnique(students);
        getInterested(students);
        getComparisoned(students, example);
    }

    public static void getUnique(List<Student> students) {
        System.out.println("=====================================================");
        List<Course> unique = students.stream()
                .flatMap(s -> s.getStudentCourses().stream())
                .distinct()
                .collect(Collectors.toList());
        for(Course c: unique) {System.out.println(c);}
    }

    public static void getInterested(List<Student> students) {
        System.out.println('\n'+"=====================================================");
        List<Student> interested = students.stream()
                .sorted((s1, s2) -> s2.getStudentCourses().size() - s1.getStudentCourses().size())
                .limit(3)
                .collect(Collectors.toList());
        for(Student s: interested) {System.out.println(s);}
    }

    public static void getComparisoned(List<Student> students, Course example) {
        System.out.println('\n'+"=====================================================");
        List<Student> comparison = students.stream()
                .filter(s->s.getStudentCourses().contains(example))
                .collect(Collectors.toList());

        for(Student s: comparison) {System.out.println(s);}
    }

    static void fillList(ArrayList<Course> coursesList) {
        for(String str: courses) {
            Course c = new Course(str);
            coursesList.add(c);
        }
    }

    static List<Student> createStudents(int quantity) {               // Спасибо большое товарищу spyvy за помощь
        Random random = new Random();
        ArrayList<Student> result = new ArrayList<>();

        for(int i=0; i < quantity; i++) {
            ArrayList<Course> courses = new ArrayList<>();
            for(int j=0; j < coursesList.size(); j++) {
                if(random.nextInt(100) < 20) {
                    courses.add(coursesList.get(j));
                }
            }
            if(courses.size() == 0) i--;
            else result.add(new Student("Student" + i, courses));
        }

        return result;
    }
}
