package developer.rentACar.business.abstracts;

import developer.rentACar.business.requests.CreateBrandRequest;
import developer.rentACar.business.requests.UpdateBrandRequest;
import developer.rentACar.business.responses.GetAllBrandsResponse;
import developer.rentACar.business.responses.GetByIdBrandResonse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResonse getById(int id);

    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);


}
