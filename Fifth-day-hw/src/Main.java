import business.abstracts.IRegisterService;
import business.abstracts.IUserService;
import business.concretes.GoogleRegisterService;
import business.concretes.RegisterService;
import business.concretes.UserManager;
import dataAccess.abstracts.IUserDao;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {
    public static void main(String[] args) {
       User user = new User(1,"Teoman","Bayoğlu","bayogluteoman@gmail.com","123123");
        User user2 = new User(2,"xxx","yyy","xxx@gmail.com","xxx");
        IUserDao iUserDao = new HibernateUserDao();
        IUserService iUserService = new UserManager(iUserDao);
        IRegisterService iRegisterService = new RegisterService(new UserManager(iUserDao));

        iRegisterService.register(user);
        iRegisterService.verify(user);

        iUserService.login("bayogluteoman@gmail.com","123123");
        IRegisterService googleRegister =  new GoogleRegisterService(new UserManager(iUserDao));

        googleRegister.register(user2);
        googleRegister.verify(user2);

        iUserService.login("xxx@gmail.com","xx");

    }
}
