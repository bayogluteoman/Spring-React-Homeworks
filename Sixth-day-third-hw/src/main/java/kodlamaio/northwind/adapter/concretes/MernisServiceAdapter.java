package kodlamaio.northwind.adapter.concretes;

import kodlamaio.northwind.adapter.abstracts.ServiceAdapter;
import kodlamaio.northwind.entities.concretes.Candidate;
import kodlamaio.northwind.mernisService.JGPKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements ServiceAdapter {
    public boolean checkIfRealPerson(Candidate candidate) throws Exception {
        JGPKPSPublicSoap client = new JGPKPSPublicSoap();
        return client.TCKimlikNoDogrula(Long.valueOf(candidate.getTc_no()),candidate.getFirstName().toUpperCase(),candidate.getLastName().toUpperCase(),candidate.getBirthDay().getYear());
    }
}
