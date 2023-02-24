package developer.rentACar.business.abstracts;

import developer.rentACar.business.requests.CreateBrandRequest;
import developer.rentACar.business.responses.GetAllBrandsResponse;
import developer.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    void add(CreateBrandRequest createBrandRequest);

}
