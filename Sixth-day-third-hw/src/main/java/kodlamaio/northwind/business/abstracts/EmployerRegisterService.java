package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Employer;
import org.springframework.stereotype.Service;

@Service
public interface EmployerRegisterService {
    DataResult register(Employer employer) throws Exception;
    boolean checkIfEmployerExistBefore(Employer employer);
    boolean checkNullFields(Employer employer);
}
