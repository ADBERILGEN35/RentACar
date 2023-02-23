package developer.rentACar.business.concretes;

import developer.rentACar.business.abstracts.BrandService;
import developer.rentACar.dataAccess.abstracts.BrandRepository;
import developer.rentACar.dataAccess.concretes.InMemoryBrandRepository;
import developer.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {

    private InMemoryBrandRepository brandRepository;

    @Autowired
    public BrandManager(InMemoryBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.getAll();
    }
}
