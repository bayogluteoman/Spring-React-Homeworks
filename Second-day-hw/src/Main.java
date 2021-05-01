import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Teoman","Bayoğlu",1);
        Student student2 = new Student("Yusuf","Bayoğlu",2);

        Course course1 = new Course("React","27/04/2021","We are going to learn how to use React in web development.","Engin Demiroğ");
        Course course2 = new Course("Spring","17/04/2021","We are going to learn how use Spring for backend web application.","Engin Demiroğ");

        course1.getCourseTakenBy().add(student1);
        course2.getCourseTakenBy().add(student2);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        CourseTaken courseTaken = new CourseTaken();
        courseTaken.addCourse(course1);
        courseTaken.addCourse(course2);

        courseTaken.addStudentToCourse(student1,course1);
        courseTaken.addStudentToCourse(student2,course2);

        courseTaken.getStudents(students);

    }
}
