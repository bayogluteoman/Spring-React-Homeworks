package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ActivationCodeService;
import kodlamaio.northwind.business.abstracts.EmployerRegisterService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstratcs.EmployeeRepository;
import kodlamaio.northwind.dataAccess.abstratcs.EmployerRepository;
import kodlamaio.northwind.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerRegisterServiceImplement implements EmployerRegisterService {

    private final EmployerRepository employerRepository;
    private final ActivationCodeService activationCodeService;
    private final EmployeeRepository employeeRepository;

    public EmployerRegisterServiceImplement(EmployerRepository employerRepository, ActivationCodeService activationCodeService, EmployeeRepository employeeRepository) {
        this.employerRepository = employerRepository;
        this.activationCodeService = activationCodeService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DataResult register(Employer employer) throws Exception {
        if (checkIfEmployerExistBefore(employer))
            return new ErrorDataResult(employer,"There is a registered employer with same e-mail address.");
        if (!checkNullFields(employer))
            return new ErrorDataResult(employer,"Must be filled all fields.");
        activationCodeService.activateEmployerAccountByEmail(employer,"ffazccc222sd2gdfhas2");
        employerRepository.save(employer);
        return new SuccessDataResult(employer,"Succesfully registered.");
    }

    @Override
    public boolean checkIfEmployerExistBefore(Employer employer) {
        List<Employer> employerList = employerRepository.findAll();
        for (Employer employer2 : employerList){
            if (employer2.getEMail().equals(employer.getEMail()))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkNullFields(Employer employer) {
        if (employer.getEMail() != null && employer.getCompanyName()!=null && employer.getTelephoneNumber() !=null && employer.getWebSite()!=null && employer.getPassword()!=null){
            return true;
        }else return false;
    }
}
