package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.abstracts.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    DataResult add(User user);
}
