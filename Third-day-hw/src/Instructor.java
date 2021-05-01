public class Instructor extends User {

    private String courseName;

    public Instructor(){}


    public Instructor(String courseName,int id, String first_name, String last_name) {
        super(id, first_name, last_name);
        this.courseName = courseName;

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


}
