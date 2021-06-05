package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getAllByActivatedTrue();
    List<JobAdvertisement> getAllByActivatedTrue(Sort sort);
    List<JobAdvertisement> getAllByEmployerId(int id);
    List<JobAdvertisement> getAllByEmployer_CompanyName(String companyName);
}
