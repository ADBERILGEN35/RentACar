package developer.rentACar.webApi.controllers;

import developer.rentACar.business.abstracts.BrandService;
import developer.rentACar.business.requests.CreateBrandRequest;
import developer.rentACar.business.requests.UpdateBrandRequest;
import developer.rentACar.business.responses.GetAllBrandsResponse;
import developer.rentACar.business.responses.GetByIdBrandResonse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @GetMapping("/{id}")
    public GetByIdBrandResonse getByIdBrandResonses(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }
}
