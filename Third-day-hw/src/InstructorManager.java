public class InstructorManager extends UserManager{
    public void instructorInfo(Instructor instructor){
        System.out.println( instructor.getCourseName()+" is given by "+instructor.getFirst_name()+" "+instructor.getLast_name());
    }
}
