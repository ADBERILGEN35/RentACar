package developer.rentACar.business.concretes;

import developer.rentACar.business.abstracts.BrandService;
import developer.rentACar.business.requests.CreateBrandRequest;
import developer.rentACar.business.requests.UpdateBrandRequest;
import developer.rentACar.business.responses.GetAllBrandsResponse;
import developer.rentACar.business.responses.GetByIdBrandResonse;
import developer.rentACar.business.rules.BrandBusinessRules;
import developer.rentACar.core.utlities.mappers.ModelMapperService;
import developer.rentACar.dataAccess.abstracts.BrandRepository;
import developer.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(br -> this.modelMapperService.forResponse()
                        .map(br, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResonse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResonse resonse = this.modelMapperService.forResponse()
                .map(brand, GetByIdBrandResonse.class);
        return resonse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}
