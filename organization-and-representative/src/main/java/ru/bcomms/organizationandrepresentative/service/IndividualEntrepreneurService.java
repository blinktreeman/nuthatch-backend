package ru.bcomms.organizationandrepresentative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.bcomms.organizationandrepresentative.dto.AddressResponseDto;
import ru.bcomms.organizationandrepresentative.entity.IndividualEntrepreneur;
import ru.bcomms.organizationandrepresentative.repository.IndividualEntrepreneurRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class IndividualEntrepreneurService extends CommonService {
    private final IndividualEntrepreneurRepository repository;

    @Autowired
    public IndividualEntrepreneurService(IndividualEntrepreneurRepository repository,
                                         WebClient webClient) {
        super(webClient);
        this.repository = repository;
    }

    public IndividualEntrepreneur save(IndividualEntrepreneur entity) {
        AddressResponseDto responseDto = this.standardizeAddress(entity.getAddress());
        entity.setAddressUuid(responseDto.getUuid());
        entity.setAddress(responseDto.getStandardizedAddress());
        return repository.save(entity);
    }

    public Optional<IndividualEntrepreneur> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<IndividualEntrepreneur> findAll() {
        return repository.findAll();
    }

    public IndividualEntrepreneur update(IndividualEntrepreneur entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
