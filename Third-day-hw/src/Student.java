public class Student extends User{
    private String takenCourse;

    public Student(){}

    public Student(String takenCourse, int id, String first_name, String last_name){
        super(id,first_name,last_name);
        this.takenCourse= takenCourse;
    }

    public String getTakenCourse() {
        return takenCourse;
    }

    public void setTakenCourse(String takenCourse) {
        this.takenCourse = takenCourse;
    }

}
