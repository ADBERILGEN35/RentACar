package developer.rentACar.business.concretes;

import developer.rentACar.business.abstracts.ModelService;
import developer.rentACar.business.requests.CreateModelRequest;
import developer.rentACar.business.responses.GetAllModelsResponse;
import developer.rentACar.core.utlities.mappers.ModelMapperService;
import developer.rentACar.dataAccess.abstracts.ModelRepository;
import developer.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
