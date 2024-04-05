package ru.bcomms.buildingproject.service;

import org.springframework.stereotype.Service;
import ru.bcomms.buildingproject.entity.GraphicPart;
import ru.bcomms.buildingproject.repository.GraphicPartRepository;

@Service
public class GraphicPartService extends CommonService<GraphicPart, GraphicPartRepository> {
    public GraphicPartService(GraphicPartRepository repository) {
        super(repository);
    }
}
