package ru.bcomms.incomingmaterialcontroljournal.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.bcomms.incomingmaterialcontroljournal.dto.RepresentativeDto;
import ru.bcomms.incomingmaterialcontroljournal.entity.IncomingMaterialControlJournal;
import ru.bcomms.incomingmaterialcontroljournal.entity.IncomingMaterialControlJournalTitle;
import ru.bcomms.incomingmaterialcontroljournal.repository.IncomingMaterialControlJournalRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class JournalService {
    private final IncomingMaterialControlJournalRepository repository;
    private final WebClient webClient;
    @Value("${journal.service.organization-service-uri}")
    private String ORGANIZATION_SERVICE_URI;

    public JournalService(IncomingMaterialControlJournalRepository repository, WebClient webClient) {
        this.repository = repository;
        this.webClient = webClient;
    }

    public Iterable<RepresentativeDto> findAllRepresentatives() {
        return webClient
                .get()
                .uri(ORGANIZATION_SERVICE_URI + "/representative/all")
                .retrieve()
                .bodyToFlux(RepresentativeDto.class)
                .collectList()
                .block();
    }
    
    // CRUD methods
    public IncomingMaterialControlJournal save(IncomingMaterialControlJournal entity) {
        return repository.save(entity);
    }

    public Optional<IncomingMaterialControlJournal> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<IncomingMaterialControlJournal> findAll() {
        return repository.findAll();
    }

    public IncomingMaterialControlJournal update(IncomingMaterialControlJournal entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
