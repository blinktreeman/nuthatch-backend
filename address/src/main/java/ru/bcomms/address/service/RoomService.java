package ru.bcomms.address.service;

import org.springframework.stereotype.Service;
import ru.bcomms.address.entity.Room;
import ru.bcomms.address.repository.RoomRepository;

@Service
public class RoomService extends AbstractService<Room, RoomRepository> {
    public RoomService(RoomRepository repository) {
        super(repository);
    }
}
