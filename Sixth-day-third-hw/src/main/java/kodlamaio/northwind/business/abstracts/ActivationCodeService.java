package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Employee;
import kodlamaio.northwind.entities.concretes.Employer;

public interface ActivationCodeService {
    DataResult activateCandidateAccountByEmail(Candidate candidate, String activationCode);
    DataResult activateEmployerAccountByEmail(Employer Employer, String activationCode);
    DataResult activateEmployerAccountByHrmsPersonal(Employer employer, Employee employee);
}
