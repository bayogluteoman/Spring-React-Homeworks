package kodlamaio.northwind.adapter.abstracts;


import kodlamaio.northwind.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public interface ServiceAdapter {
   boolean checkIfRealPerson(Candidate candidate) throws Exception;
}
