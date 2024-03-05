package ru.bcomms.address.service;

import org.springframework.stereotype.Service;
import ru.bcomms.address.entity.Country;
import ru.bcomms.address.repository.CountryRepository;

@Service
public class CountryService extends AbstractService<Country, CountryRepository> {
    public CountryService(CountryRepository repository) {
        super(repository);
    }
}
