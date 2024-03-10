package ru.bcomms.address.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.bcomms.address.dto.StandardizedAddressResponseDto;
import ru.bcomms.address.entity.Address;
import ru.bcomms.address.repository.AddressRepository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository repository;

    @Value("${dadata.client.base-url}")
    private String BASE_URL;
    @Value("${dadata.client.token}")
    private String TOKEN;
    @Value("${dadata.client.secret-key}")
    private String SECRET_KEY;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    // Стандартизируем адрес из строки
    private Optional<Address> standardizeAddress(String address) throws IOException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .POST(HttpRequest
                        .BodyPublishers
                        .ofString("[ \"" + address + "\" ]", StandardCharsets.UTF_8))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Token " + TOKEN)
                .setHeader("X-Secret", SECRET_KEY)
                .build();

        HttpClient client = HttpClient.newHttpClient();
        String responseBody = "";
        // Запрос стандартизации адреса, при недоступности сервиса - пустой ответ
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
        } catch (Exception e) {
            return Optional.empty();
        }

        // Удалить квадратные скобки из ответа
        responseBody = responseBody.substring(1, responseBody.length() - 1);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return Optional.of(objectMapper.readValue(responseBody, Address.class));
    }

    // CRUD methods
    public StandardizedAddressResponseDto saveStandardizedAddress(String address)
            throws IOException {
        return this.standardizeAddress(address)
                .map(value -> {
                    this.save(value);
                    return new StandardizedAddressResponseDto (
                            value.getUuid(),
                            value.toString()
                    );
                })
                .orElseGet(() -> new StandardizedAddressResponseDto(
                        null,
                        address
                ));
    }

    public Address save(Address entity) {
        return repository.save(entity);
    }

    public Optional<Address> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<Address> findAll() {
        return repository.findAll();
    }

    public Address update(Address entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}
