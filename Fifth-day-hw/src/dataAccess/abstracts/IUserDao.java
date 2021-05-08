package dataAccess.abstracts;

import entities.concretes.User;

import java.util.List;

public interface IUserDao {
    void save(User user);
    List<User> getUsers();
}
