package ru.bcomms.incomingmaterialcontroljournal.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.bcomms.incomingmaterialcontroljournal.dto.IndividualEntrepreneurDto;
import ru.bcomms.incomingmaterialcontroljournal.dto.LegalEntityDto;
import ru.bcomms.incomingmaterialcontroljournal.entity.MaterialOrItemVerificationInfo;
import ru.bcomms.incomingmaterialcontroljournal.repository.MaterialOrItemVerificationInfoRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class VerificationInfoService {
    private final MaterialOrItemVerificationInfoRepository repository;
    private final WebClient webClient;

    @Value("${journal.service.organization-service-uri}")
    private String ORGANIZATION_SERVICE_URI;

    public VerificationInfoService(MaterialOrItemVerificationInfoRepository repository,
                                   WebClient webClient) {
        this.repository = repository;
        this.webClient = webClient;
    }

    public Iterable<LegalEntityDto> findAllLegalEntities() {
        return webClient
                .get()
                .uri(ORGANIZATION_SERVICE_URI + "/legal-entity/all")
                .retrieve()
                .bodyToFlux(LegalEntityDto.class)
                .collectList()
                .block();
    }

    public Iterable<IndividualEntrepreneurDto> findAllEntrepreneurs() {
        return webClient
                .get()
                .uri(ORGANIZATION_SERVICE_URI + "/individual-entrepreneur/all")
                .retrieve()
                .bodyToFlux(IndividualEntrepreneurDto.class)
                .collectList()
                .block();
    }

    // CRUD methods
    public MaterialOrItemVerificationInfo save(MaterialOrItemVerificationInfo entity) {
        return repository.save(entity);
    }

    public Optional<MaterialOrItemVerificationInfo> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<MaterialOrItemVerificationInfo> findAll() {
        return repository.findAll();
    }

    public MaterialOrItemVerificationInfo update(MaterialOrItemVerificationInfo entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}


