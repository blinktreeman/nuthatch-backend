package ru.bcomms.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bcomms.address.entity.Address;
import ru.bcomms.address.service.AddressService;

@RestController
@RequestMapping(value = "/api/v1/address")
public class AddressController extends AbstractController<Address, AddressService> {

    @Autowired
    protected AddressController(AddressService service) {
        super(service);
    }
}
