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
public class LegalEntityService {
    private final LegalEntityRepository repository;
    private final WebClient webClient;

    private final String ADDRESS_SERVICE_URI = "http://address-service/api/v1/address";

    public LegalEntityService(LegalEntityRepository repository, WebClient webClient) {
        this.repository = repository;
        this.webClient = webClient;
    }

    /**
     * Стандартизирует входящий адрес ЮЛ с сохранением в БД
     * @param address Адрес для стандартизации
     * @return Dto: UUID записи в БД, String - стандартизированный адрес
     */
    private AddressResponseDto standardizeAddress(String address) {
        return webClient
                .post()
                .uri(ADDRESS_SERVICE_URI + "/save-standardized?address=" + address)
                .retrieve()
                .bodyToMono(AddressResponseDto.class)
                .block();
    }

    public LegalEntity save(LegalEntity entity) {
        AddressResponseDto responseDto = standardizeAddress(entity.getAddress());
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
