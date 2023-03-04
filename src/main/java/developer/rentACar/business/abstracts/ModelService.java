package developer.rentACar.business.abstracts;

import developer.rentACar.business.requests.CreateModelRequest;
import developer.rentACar.business.responses.GetAllModelsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
