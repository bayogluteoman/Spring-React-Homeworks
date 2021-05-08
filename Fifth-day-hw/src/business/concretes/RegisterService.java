package business.concretes;

import entities.concretes.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterService extends BaseRegisterClass {

    public RegisterService(UserManager userManager) {
        super(userManager);
    }

    @Override
    public boolean checkRegister(User user) {
        if(user.getMail() !=null && user.getFirst_name()!=null &&
                user.getLast_name()!=null && user.getPassword()!=null){
            String regex = "^(.+)@(.+)$";
            boolean usedMail= false;
            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(user.getMail());

            List<User> list = userManager.getUsersList();
            for(User user1: list){
                if(user1.getMail().equals(user.getMail())){
                    usedMail=true;
                    break;
                }
            }

            if (user.getPassword().length() >= 6 && matcher.matches() &&
                    !usedMail && user.getFirst_name().length() >=2 && user.getLast_name().length()>=2) {

                return true;
            }
            return false;
        }
        return false;
    }

}