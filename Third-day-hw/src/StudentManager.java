public class StudentManager extends UserManager{
    public void addStudent(Student student){
        System.out.println(student.getFirst_name()+" "+ student.getLast_name()+" (student) added");
    }

    public void listStudent(Student student){
        System.out.println("ID:"+ student.getId()+" --> "+student.getFirst_name()+" "+ student.getLast_name()+" has "+student.getTakenCourse()+" course .");
    }
}
