package HomeWork09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWork09 {


    public static void main(String[] args) {

        List <Student> students = getList();

        //1 задание : функция принимающая список студентов и возвращающая список уникальных курсов
        students.stream().flatMap(student -> student.getCourses().stream())
                        .distinct()
                        .collect(Collectors.toList());

        students.stream().flatMap(student ->
                student.getCourses().stream()).collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("------------------------------");



        //2 задание : функция принимающая на вход список студентов и возвращающая список 3х самых любознательных
        students.stream()
                .sorted((student1, student2) -> student2.getCourses().size() - student1.getCourses().size()).limit(3).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("------------------------------");



        //3 задание : функция принимающая на вход список студентов и экземпляр курса, возвращающая список студентов посещающих этот курс
        Course popularCourse = new Course("Math");
        students.stream().filter(student ->
                student.getCourses().contains(popularCourse)).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("Спасибо за курс - JAVA.CORE !");

    }


        private static List <Student> getList()
    {
        List <Course> courses = new ArrayList<>();

        courses.add(new Course("Math")); // 0
        courses.add(new Course("Rus")); // 1
        courses.add(new Course("Engl")); // 2
        courses.add(new Course("Bio"));  // 3
        courses.add(new Course("Franch")); // 4
        courses.add(new Course("Physics")); // 5
        courses.add(new Course("IT")); // 6
        courses.add(new Course("Literature")); // 7
        courses.add(new Course("Singing")); // 8
        courses.add(new Course("History")); // 9

        List <Course> coursesList1 = new ArrayList<>();
        coursesList1.add(courses.get(9));
        coursesList1.add(courses.get(1));
        coursesList1.add(courses.get(2));
        coursesList1.add(courses.get(3));

        List <Course> coursesList2 = new ArrayList<>();
        coursesList2.add(courses.get(0));;
        coursesList2.add(courses.get(4));
        coursesList2.add(courses.get(5));

        List <Course> coursesList3 = new ArrayList<>();
        coursesList3.add(courses.get(8));
        coursesList3.add(courses.get(1));
        coursesList3.add(courses.get(4));
        coursesList3.add(courses.get(6));

        List <Course> coursesList4 = new ArrayList<>();;
        coursesList4.add(courses.get(3));
        coursesList4.add(courses.get(7));
        coursesList4.add(courses.get(4));
        coursesList4.add(courses.get(2));
        coursesList4.add(courses.get(0));

        List <Course> coursesList5 = new ArrayList<>();;
        coursesList5.add(courses.get(0));
        coursesList5.add(courses.get(9));
        coursesList5.add(courses.get(6));
        coursesList5.add(courses.get(7));

        List <Student> student = new ArrayList<>();
        Student student1 = new Student("Bob", coursesList1); //4
        Student student2 = new Student("John", coursesList2); //3
        Student student3 = new Student("Tom", coursesList3); //4
        Student student4 = new Student("Frank",coursesList4); //5
        Student student5 = new Student("Anna", coursesList5); //4
        student.add(student1);
        student.add(student2);
        student.add(student3);
        student.add(student4);
        student.add(student5);

        System.out.println(student);
        return student;

    }

    }




