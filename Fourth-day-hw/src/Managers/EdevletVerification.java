package Managers;

import Entities.User;

import java.util.Set;
import java.util.ArrayList;

public class EdevletVerification implements IVerificationService {

    @Override
    public boolean verification(User user, Set<User> userSet) {

        User[] users = new User[userSet.size()];
        userSet.toArray(users);

        for(int i=0;i<users.length;i++){
            User searchedUser = users[i];
            if (user.getFirst_name().equals(searchedUser.getFirst_name())&&
                user.getLast_name().equals(searchedUser.getLast_name())&&
                user.getTc_number()==searchedUser.getTc_number()){
                return true;
            }
        }
        return false;
    }
}
