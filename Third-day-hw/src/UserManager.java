public class UserManager {
    public void add(User user){
        System.out.println(user.getId()+"-"+user.getFirst_name()+" "+ user.getLast_name()+" " + " (user) added.");
    }

    public void update(User user){
        System.out.println(user.getFirst_name() + user.getLast_name() +"updated.");
    }

    public void delete(User user){
        System.out.println(user.getFirst_name() + user.getLast_name() +"deleted.");
    }
}
