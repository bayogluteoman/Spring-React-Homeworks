package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.EmployerService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.EmployerRepository;
import kodlamaio.northwind.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImplement implements EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerServiceImplement(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerRepository.findAll(),"Listed employers.");
    }

    @Override
    public void validate(Employer employer) {

    }
}
