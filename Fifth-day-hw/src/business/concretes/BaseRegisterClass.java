package business.concretes;

import business.abstracts.IRegisterService;
import entities.concretes.User;

public abstract class BaseRegisterClass implements IRegisterService {

    protected final UserManager userManager;

    protected BaseRegisterClass(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public boolean checkRegister(User user) {
        return false;
    }

    @Override
    public void register(User user) {
        if(checkRegister(user)){
            System.out.println(user.getFirst_name()+" "+user.getLast_name()+ " has successfully " +
                    "registered to the system. Verification mail has been sent" +
                    " yo your mail. Please verify this mail to login");

            userManager.save(user);
        }else{
            System.out.println("Please try again :)");
        }
    }

    @Override
    public void verify(User user) {
        System.out.println("Verification has successfully completed.");
    }
}
