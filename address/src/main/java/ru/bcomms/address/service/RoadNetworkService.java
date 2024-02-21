package ru.bcomms.address.service;

import org.springframework.stereotype.Service;
import ru.bcomms.address.entity.RoadNetwork;
import ru.bcomms.address.repository.RoadNetworkRepository;

@Service
public class RoadNetworkService extends AbstractService<RoadNetwork, RoadNetworkRepository> {
    public RoadNetworkService(RoadNetworkRepository repository) {
        super(repository);
    }
}
