package developer.rentACar.dataAccess.abstracts;

import developer.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BrandRepository {
    List<Brand> getAll();

}
