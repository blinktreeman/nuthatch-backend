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
public class IndividualEntrepreneurService {
    private final IndividualEntrepreneurRepository repository;
    private final WebClient webClient;

    private final String ADDRESS_SERVICE_URI = "http://address-service/api/v1/address";

    @Autowired
    public IndividualEntrepreneurService(IndividualEntrepreneurRepository repository,
                                         WebClient webClient) {
        this.repository = repository;
        this.webClient = webClient;
    }

    /**
     * Стандартизирует входящий адрес ИП с сохранением в БД
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

    public IndividualEntrepreneur save(IndividualEntrepreneur entity) {
        AddressResponseDto responseDto = standardizeAddress(entity.getAddress());
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
