package kodlamaio.northwind.dataAccess.abstratcs;

import kodlamaio.northwind.entities.concretes.EmployerActivationByEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerActivationByEmployeeRepository extends JpaRepository<EmployerActivationByEmployee,Integer> {
}
