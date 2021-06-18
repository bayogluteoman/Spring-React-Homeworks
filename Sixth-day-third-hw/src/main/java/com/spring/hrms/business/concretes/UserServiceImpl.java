package com.spring.hrms.business.concretes;

import com.spring.hrms.business.abstracts.UserService;
import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.SuccessDataResult;
import com.spring.hrms.dataAccess.abstracts.UserRepository;
import com.spring.hrms.entities.abstracts.User;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DataResult add(User user) {
        userRepository.save(user);
        return new SuccessDataResult(user,"User has been add.");
    }
}
