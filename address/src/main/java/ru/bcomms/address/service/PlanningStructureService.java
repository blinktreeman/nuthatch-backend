package ru.bcomms.address.service;

import org.springframework.stereotype.Service;
import ru.bcomms.address.entity.PlanningStructure;
import ru.bcomms.address.repository.PlanningStructureRepository;

@Service
public class PlanningStructureService extends AbstractService<PlanningStructure, PlanningStructureRepository> {
    public PlanningStructureService(PlanningStructureRepository repository) {
        super(repository);
    }
}
