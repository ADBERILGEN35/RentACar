package developer.rentACar.dataAccess.concretes;

import developer.rentACar.dataAccess.abstracts.BrandRepository;
import developer.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBrandRepository implements BrandRepository {

    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands = new ArrayList<Brand>();
        brands.add(new Brand(1, "AUDI"));
        brands.add(new Brand(2, "BMW"));
        brands.add(new Brand(3, "Mercedes"));
        brands.add(new Brand(4, "Ford"));
        brands.add(new Brand(5, "Renault"));
        brands.add(new Brand(6, "KIA"));
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }


}
