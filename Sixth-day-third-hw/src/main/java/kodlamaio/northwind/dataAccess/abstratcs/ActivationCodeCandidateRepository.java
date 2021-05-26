package kodlamaio.northwind.dataAccess.abstratcs;

import kodlamaio.northwind.entities.concretes.ActivationCodeCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationCodeCandidateRepository extends JpaRepository<ActivationCodeCandidate,Integer> {
}
