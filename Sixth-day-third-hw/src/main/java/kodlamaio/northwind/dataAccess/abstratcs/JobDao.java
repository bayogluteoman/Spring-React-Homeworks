package kodlamaio.northwind.dataAccess.abstratcs;

import kodlamaio.northwind.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDao extends JpaRepository<Job,Integer> {
}
