package ru.bcomms.address.repository;

import org.springframework.stereotype.Repository;
import ru.bcomms.address.entity.Country;

@Repository
public interface CountryRepository extends CommonRepository<Country> {
}
