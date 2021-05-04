package Managers;

import Entities.User;

import java.util.Set;

public class UserManagers implements IUserService {
    Set<User> users;

    public UserManagers(Set<User> users){
        this.users=users;
    }
    @Override
    public void add(User user) {
        System.out.println("New user: "+user.getFirst_name()+" "+user.getLast_name()+" has added.");
        users.add(user);
    }

    @Override
    public void update(User user,int price) {
        user.setMoney(price+user.getMoney());
        System.out.println("User has "+user.getMoney()+"₺.");
    }

    @Override
    public void delete(User user) {
        System.out.println("User: "+user.getFirst_name()+" "+user.getLast_name()+"has been deleted");
    }

    @Override
    public Set<User> getUsers(){
        return users;
    }


}
