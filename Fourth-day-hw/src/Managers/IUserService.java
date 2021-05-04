package Managers;

import Entities.User;

import java.util.Set;

public interface IUserService {
    void add(User user);
    void update(User user,int price);
    void delete(User user);
    Set<User> getUsers();
}
