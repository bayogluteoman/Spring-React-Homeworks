package kodlamaio.northwind.dataAccess.abstratcs;

import kodlamaio.northwind.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {

}