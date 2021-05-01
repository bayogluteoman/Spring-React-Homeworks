public class Main {

    public static void main(String[] args) {

        User user = new User();
        User user2 = new User();

        Student student = new Student();
        Student student2 = new Student();

        Instructor instructor = new Instructor();
        Instructor instructor2 = new Instructor();

        user.setId(1);
        user.setFirst_name("Teoman");
        user.setLast_name("Bayoğlu");

        user2.setId(2);
        user2.setFirst_name("Ahmet");
        user2.setLast_name("Kaplan");



        student.setId(12);
        student.setFirst_name("Yusuf");
        student.setLast_name("Bayoğlu");
        student.setTakenCourse("Spring");

        student2.setId(23);
        student2.setFirst_name("Mehmet");
        student2.setLast_name("Altın");
        student2.setTakenCourse("C#");


        instructor.setCourseName("Spring");
        instructor.setFirst_name("Engin");
        instructor.setLast_name("Demiroğ");

        instructor2.setCourseName("React");
        instructor2.setFirst_name("Engin");
        instructor2.setLast_name("Demiroğ");

        UserManager userManager = new UserManager();
        userManager.add(user);
        userManager.add(user2);

        InstructorManager instructorMsnager = new InstructorManager();
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent(student);
        studentManager.listStudent(student);
        instructorMsnager.instructorInfo(instructor);
        studentManager.addStudent(student2);
        studentManager.listStudent(student2);
        instructorMsnager.instructorInfo(instructor2);






    }




}
