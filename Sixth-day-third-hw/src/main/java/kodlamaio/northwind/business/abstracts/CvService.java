package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Cv;
import kodlamaio.northwind.entities.dto.CvDto;

public interface CvService {
    DataResult<Cv> add(int candidateId, Cv cv);

    DataResult<CvDto> getByCandidate_Id(int id);
}
