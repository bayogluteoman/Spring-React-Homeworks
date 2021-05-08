package dataAccess.concretes;

import dataAccess.abstracts.IUserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements IUserDao {
    List<User> usersList = new ArrayList<>();

    @Override
    public void save(User user) {
        System.out.println(user.getFirst_name()+" "+user.getLast_name()+ " has saved to database.");
        usersList.add(user);
    }

    @Override
    public List<User> getUsers() {
        return usersList;
    }
}
