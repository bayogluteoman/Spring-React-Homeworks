import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;
    private String courseDay;
    private String courseContent;

    public String getCourseGivenBy() {
        return courseGivenBy;
    }

    public void setCourseGivenBy(String courseGivenBy) {
        this.courseGivenBy = courseGivenBy;
    }

    private String courseGivenBy;

    public List<Student> getCourseTakenBy() {
        return courseTakenBy;
    }

    public void setCourseTakenBy(List<Student> courseTakenBy) {
        this.courseTakenBy = courseTakenBy;
    }

    private List<Student> courseTakenBy = new ArrayList<>();


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(String courseDay) {
        this.courseDay = courseDay;
    }

    public String getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent;
    }

    public Course(String courseName, String courseDay, String courseContent, String courseGivenBy ){
        this.courseName=courseName;
        this.courseDay=courseDay;
        this.courseContent=courseContent;
        this.courseGivenBy= courseGivenBy;

    }
}
