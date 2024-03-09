package ru.bcomms.organizationandrepresentative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.bcomms.organizationandrepresentative.dto.AddressResponseDto;
import ru.bcomms.organizationandrepresentative.entity.LegalEntity;
import ru.bcomms.organizationandrepresentative.repository.LegalEntityRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class LegalEntityService extends CommonService {
    private final LegalEntityRepository repository;

    @Autowired
    public LegalEntityService(LegalEntityRepository repository, WebClient webClient) {
        super(webClient);
        this.repository = repository;
    }

    public LegalEntity save(LegalEntity entity) {
        AddressResponseDto responseDto = this.standardizeAddress(entity.getAddress());
        entity.setAddressUuid(responseDto.getUuid());
        entity.setAddress(responseDto.getStandardizedAddress());
        return repository.save(entity);
    }

    public Optional<LegalEntity> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<LegalEntity> findAll() {
        return repository.findAll();
    }

    public LegalEntity update(LegalEntity entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
