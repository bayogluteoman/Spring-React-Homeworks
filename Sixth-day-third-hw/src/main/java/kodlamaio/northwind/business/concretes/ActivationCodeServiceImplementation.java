package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ActivationCodeService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstratcs.ActivationCodeCandidateRepository;
import kodlamaio.northwind.dataAccess.abstratcs.ActivationCodeEmployerRepository;
import kodlamaio.northwind.dataAccess.abstratcs.EmployerActivationByEmployeeRepository;
import kodlamaio.northwind.entities.concretes.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivationCodeServiceImplementation implements ActivationCodeService {

    private final ActivationCodeCandidateRepository activationCodeCandidateRepository;
    private final ActivationCodeEmployerRepository activationCodeEmployerRepository;
    private final EmployerActivationByEmployeeRepository employerActivationByEmployeeRepository;

    public ActivationCodeServiceImplementation(ActivationCodeCandidateRepository activationCodeCandidateRepository, ActivationCodeEmployerRepository activationCodeEmployerRepository, EmployerActivationByEmployeeRepository employerActivationByEmployeeRepository) {
        this.activationCodeCandidateRepository = activationCodeCandidateRepository;
        this.activationCodeEmployerRepository = activationCodeEmployerRepository;
        this.employerActivationByEmployeeRepository = employerActivationByEmployeeRepository;
    }


    @Override
    public DataResult activateCandidateAccountByEmail(Candidate candidate, String activationCode) {
        ActivationCodeCandidate activationCodes = new ActivationCodeCandidate();
        activationCodes.setCandidateId(candidate.getId());
        activationCodes.setConfirmed(true);
        activationCodes.setConfirmedDate(new Date());
        activationCodes.setActivationCode(activationCode);
        //activationCodeCandidateRepository.save(activationCodes);
        return new SuccessDataResult(candidate,"Have been verified by e-mail succesfuly");
    }

    @Override
    public DataResult activateEmployerAccountByEmail(Employer Employer, String activationCode) {

        ActivationCodeEmployer activationCodes = new ActivationCodeEmployer();
        activationCodes.setEmployerId(Employer.getId());
        activationCodes.setConfirmed(true);
        activationCodes.setConfirmedDate(new Date());
        activationCodes.setActivationCode(activationCode);
        //activationCodeEmployerRepository.save(activationCodes);
        return new SuccessDataResult(Employer,"Has been verified by e-mail succesfuly");
    }

    @Override
    public DataResult activateEmployerAccountByHrmsPersonal(Employer employer,Employee employee){
        EmployerActivationByEmployee employerActivationByEmployee = new EmployerActivationByEmployee();
        employerActivationByEmployee.setConfirmed(true);
        employerActivationByEmployee.setConfirmedDate(new Date());
        employerActivationByEmployee.setConfirmedEmployeeId(employee.getId());
        employerActivationByEmployee.setEmployerId(employer.getId());
        return new SuccessDataResult(employer,"Has been verified by hrms personal.");

    }
}