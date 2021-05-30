package kodlamaio.northwind.adapter.concretes;

import kodlamaio.northwind.adapter.abstracts.ServiceAdapter;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.mernisService.JGPKPSPublicSoap;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class MernisServiceAdapter implements ServiceAdapter {
    public boolean checkIfRealPerson(Candidate candidate) throws Exception {
        JGPKPSPublicSoap client = new JGPKPSPublicSoap();
      //  LocalDate localDate = candidate.getBirthDay().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      //  int year  = localDate.getYear();
        return client.TCKimlikNoDogrula(Long.valueOf(candidate.getTc_no()),candidate.getFirstName().toUpperCase(),candidate.getLastName().toUpperCase(),1999);
    }
}
