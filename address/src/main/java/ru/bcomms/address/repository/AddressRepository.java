package ru.bcomms.address.repository;

import org.springframework.stereotype.Repository;
import ru.bcomms.address.entity.Address;

@Repository
public interface AddressRepository extends CommonRepository<Address> {
}
