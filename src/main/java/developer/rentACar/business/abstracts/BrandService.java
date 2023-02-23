package developer.rentACar.business.abstracts;

import developer.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BrandService {
    List<Brand> getAll();

}
