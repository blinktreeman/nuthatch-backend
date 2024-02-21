package ru.bcomms.address.service;

import org.springframework.stereotype.Service;
import ru.bcomms.address.entity.Address;
import ru.bcomms.address.repository.AddressRepository;

@Service
public class AddressService extends AbstractService<Address, AddressRepository> {
    public AddressService(AddressRepository repository) {
        super(repository);
    }
}
