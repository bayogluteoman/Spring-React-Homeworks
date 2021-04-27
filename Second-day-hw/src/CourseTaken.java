import java.util.List;

public class CourseTaken {

    public void addCourse(Course course){
        System.out.println(course.getCourseName() + " " + "--> Course added");
    }

    public void addStudentToCourse(Student student,Course course){
        System.out.println("Student ID: "+student.getId()+"-"+student.getFirst_name() + " " +student.getLast_name()+" "+ "added in "+course.getCourseName() + " lesson which is given by " +course.getCourseGivenBy()+".");
        student.getCourseTaken().add(course);
    }

    public void getStudents(List<Student> students){
        System.out.println("------Students List------");
        for (Student student : students){
            System.out.println(student.getFirst_name()+ " " + student.getLast_name());
        }
    }
}
