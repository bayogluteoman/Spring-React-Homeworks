package business.concretes;

import entities.concretes.User;

public class GoogleRegisterService extends BaseRegisterClass {

    public GoogleRegisterService(UserManager userManager) {
        super(userManager);
    }

    @Override
    public boolean checkRegister(User user) {
        System.out.println(user.getFirst_name()+" "+user.getLast_name()+" has succesffully registered with Google");
        return true;
    }
}
