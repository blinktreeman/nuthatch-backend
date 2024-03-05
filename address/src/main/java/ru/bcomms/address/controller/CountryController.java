package ru.bcomms.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcomms.address.entity.Country;
import ru.bcomms.address.service.CountryService;

@RestController
@RequestMapping(value = "/api/v1/country")
public class CountryController extends AbstractController<Country, CountryService> {
    @Autowired
    public CountryController(CountryService service) {
        super(service);
    }
}
