package business.concretes;

import business.abstracts.IUserService;
import dataAccess.abstracts.IUserDao;
import entities.concretes.User;

import java.util.List;

public class UserManager implements IUserService {

    private final IUserDao iUserDao;

    public UserManager(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public void login(String mail, String password) {
        List<User> userslist = getUsersList();
            for(User user: userslist){
                if(user.getMail().equals(mail)&& user.getPassword().equals(password)){
                    System.out.println(user.getFirst_name()+" "+user.getLast_name()+" has successfully logined.");
                }
            }

        System.out.println("Email or password is wrong !");
    }

    @Override
    public void save(User user) {
        iUserDao.save(user);
    }

    @Override
    public List<User> getUsersList() {
        return iUserDao.getUsers();
    }
}
