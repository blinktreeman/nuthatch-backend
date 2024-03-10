package ru.bcomms.organizationandrepresentative.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.bcomms.organizationandrepresentative.dto.DocumentResponseDto;
import ru.bcomms.organizationandrepresentative.entity.Representative;
import ru.bcomms.organizationandrepresentative.repository.RepresentativeRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class RepresentativeService {
    private final RepresentativeRepository repository;
    private final WebClient webClient;

    @Value("${organization.service.document-service-uri}")
    private String DOCUMENT_SERVICE_URI;

    @Autowired
    public RepresentativeService(RepresentativeRepository repository,
                                 WebClient webClient) {
        this.repository = repository;
        this.webClient = webClient;
    }

    public Iterable<DocumentResponseDto> findAllDocuments() {
        return webClient
                .get()
                .uri(DOCUMENT_SERVICE_URI + "/all")
                .retrieve()
                .bodyToFlux(DocumentResponseDto.class)
                .collectList()
                .block();
    }

    // CRUD methods
    public Representative save(Representative entity) {
        return repository.save(entity);
    }

    public Optional<Representative> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<Representative> findAll() {
        return repository.findAll();
    }

    public Representative update(Representative entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
