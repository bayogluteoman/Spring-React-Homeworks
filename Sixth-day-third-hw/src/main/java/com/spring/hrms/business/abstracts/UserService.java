package com.spring.hrms.business.abstracts;

import com.spring.hrms.core.utilities.results.DataResult;
import com.spring.hrms.core.utilities.results.Result;
import com.spring.hrms.entities.abstracts.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    DataResult add(User user);
}
