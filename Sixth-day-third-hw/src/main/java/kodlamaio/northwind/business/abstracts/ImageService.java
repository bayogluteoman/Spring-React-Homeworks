package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Image;

import java.util.List;

public interface ImageService {
    Result add(Image image);
    DataResult<List<Image>> getByCandidateId(int candidateId);
}
