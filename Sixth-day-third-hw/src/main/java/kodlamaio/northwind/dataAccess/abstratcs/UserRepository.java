package kodlamaio.northwind.dataAccess.abstratcs;

import kodlamaio.northwind.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}