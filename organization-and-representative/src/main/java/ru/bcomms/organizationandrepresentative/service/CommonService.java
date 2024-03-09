package ru.bcomms.organizationandrepresentative.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import ru.bcomms.organizationandrepresentative.dto.AddressResponseDto;


public abstract class CommonService {
    private final WebClient webClient;

    @Value("${address.service.uri}")
    private String ADDRESS_SERVICE_URI;

    public CommonService(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Стандартизирует входящий адрес ЮЛ с сохранением в БД
     * @param address Адрес для стандартизации
     * @return Dto: UUID записи в БД, String - стандартизированный адрес
     */
    protected AddressResponseDto standardizeAddress(String address) {
        return webClient
                .post()
                .uri(ADDRESS_SERVICE_URI + "/save-standardized?address=" + address)
                .retrieve()
                .bodyToMono(AddressResponseDto.class)
                .block();
    }
}
