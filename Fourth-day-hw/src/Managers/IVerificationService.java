package Managers;

import Entities.User;

import java.util.Set;

public interface IVerificationService {
    boolean verification(User user, Set<User> userSet);
}
