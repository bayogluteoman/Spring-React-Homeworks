import java.util.ArrayList;
import java.util.List;

public class Student {

    private String first_name;
    private String last_name;
    private int id;
    private List<Course> courseTaken = new ArrayList<>();

    public Student(String first_name, String last_name, int id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourseTaken() {
        return courseTaken;
    }

    public void setCourseTaken(List<Course> courseTaken) {
        this.courseTaken = courseTaken;
    }
}
