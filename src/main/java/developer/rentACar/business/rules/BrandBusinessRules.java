package developer.rentACar.business.rules;

import developer.rentACar.core.utlities.exceptions.BusinnessException;
import developer.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if (this.brandRepository.existsByName(name)) {
            throw new BusinnessException("Brand name already exists");
        }
    }
}
