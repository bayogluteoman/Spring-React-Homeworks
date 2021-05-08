package business.abstracts;

import entities.concretes.User;

import java.util.List;

public interface IUserService {
    void login(String mail, String password);
    void save(User user);
    List<User> getUsersList();
}
