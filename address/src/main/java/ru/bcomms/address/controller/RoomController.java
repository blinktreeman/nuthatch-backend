package ru.bcomms.address.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bcomms.address.entity.Room;
import ru.bcomms.address.service.RoomService;

@RestController
@RequestMapping(value = "/api/v1/room")
public class RoomController extends AbstractController<Room, RoomService> {
    public RoomController(RoomService service) {
        super(service);
    }
}
