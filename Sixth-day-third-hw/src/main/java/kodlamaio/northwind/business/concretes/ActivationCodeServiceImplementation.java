package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ActivationCodeService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstratcs.*;
import kodlamaio.northwind.entities.concretes.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivationCodeServiceImplementation implements ActivationCodeService {

    private final ActivationCodeCandidateRepository activationCodeCandidateRepository;
    private final ActivationCodeEmployerRepository activationCodeEmployerRepository;
    private final EmployerActivationByEmployeeRepository employerActivationByEmployeeRepository;
    private final CandidateRepository candidateRepository;
    private final EmployerRepository employerRepository;
    private final EmployeeRepository employeeRepository;

    public ActivationCodeServiceImplementation(ActivationCodeCandidateRepository activationCodeCandidateRepository, ActivationCodeEmployerRepository activationCodeEmployerRepository, EmployerActivationByEmployeeRepository employerActivationByEmployeeRepository,CandidateRepository candidateRepository,EmployerRepository employerRepository,EmployeeRepository employeeRepository) {
        this.activationCodeCandidateRepository = activationCodeCandidateRepository;
        this.activationCodeEmployerRepository = activationCodeEmployerRepository;
        this.employerActivationByEmployeeRepository = employerActivationByEmployeeRepository;
        this.candidateRepository = candidateRepository;
        this.employerRepository = employerRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public DataResult activateCandidateAccountByEmail(int candidateId) {
        ActivationCodeCandidate activationCodeCandidate = new ActivationCodeCandidate();
        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        activationCodeCandidate.setCandidate(candidate);
        activationCodeCandidate.setConfirmedDate(new Date());
        activationCodeCandidate.setConfirmed(true);
        activationCodeCandidate.setActivationCode("sampleCode");
        candidate.setActivationCodeCandidate(activationCodeCandidate);
        activationCodeCandidateRepository.save(activationCodeCandidate);
        return new SuccessDataResult(candidate,"Have been verified by e-mail succesfuly");
    }

    @Override
    public DataResult activateEmployerAccountByEmail(int employerId) {
        Employer employer = employerRepository.findById(employerId).orElse(null);
        ActivationCodeEmployer activationCodeEmployer = new ActivationCodeEmployer();
        activationCodeEmployer.setEmployer(employer);
        activationCodeEmployer.setConfirmedDate(new Date());
        activationCodeEmployer.setActivationCode("sampleCode");
        activationCodeEmployer.setConfirmed(true);
        employer.setActivationCodeEmployer(activationCodeEmployer);
        activationCodeEmployerRepository.save(activationCodeEmployer);
        return new SuccessDataResult(employer,"Has been verified by e-mail succesfuly");
    }

    @Override
    public DataResult activateEmployerAccountByHrmsPersonal(int employerId, int employeeId){
        Employer employer = employerRepository.findById(employerId).orElse(null);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        EmployerActivationByEmployee employerActivationByEmployee = new EmployerActivationByEmployee();
        employerActivationByEmployee.setConfirmed(true);
        employerActivationByEmployee.setConfirmedDate(new Date());
        employerActivationByEmployee.setEmployee(employee);
        employerActivationByEmployee.setEmployer(employer);
        employerActivationByEmployeeRepository.save(employerActivationByEmployee);
        return new SuccessDataResult(employer,"Has been verified by hrms personal.");

    }
}