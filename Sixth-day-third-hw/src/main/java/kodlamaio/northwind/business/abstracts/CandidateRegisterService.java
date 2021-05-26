package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public interface CandidateRegisterService {
    DataResult register(Candidate candidate) throws Exception;
    boolean checkIfUserExistBefore(Candidate candidate);
    boolean checkCanditateIfRealPerson(Candidate candidate) throws Exception;
}