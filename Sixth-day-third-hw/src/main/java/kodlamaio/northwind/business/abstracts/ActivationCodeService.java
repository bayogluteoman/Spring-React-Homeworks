package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.entities.concretes.Employee;
import kodlamaio.northwind.entities.concretes.Employer;

public interface ActivationCodeService {
    DataResult activateCandidateAccountByEmail(int candidateId);
    DataResult activateEmployerAccountByEmail(int employerId);
    DataResult activateEmployerAccountByHrmsPersonal(int employerId, int employeeId);
}
