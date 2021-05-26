package kodlamaio.northwind.dataAccess.abstratcs;

import kodlamaio.northwind.entities.concretes.ActivationCodeEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationCodeEmployerRepository extends JpaRepository<ActivationCodeEmployer,Integer> {
}