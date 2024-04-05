package ru.bcomms.buildingobject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bcomms.buildingobject.entity.PermanentObjectInfo;
import ru.bcomms.buildingobject.repository.PermanentObjectInfoRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class PermanentObjectInfoService {
    private final PermanentObjectInfoRepository repository;

    @Autowired
    public PermanentObjectInfoService(PermanentObjectInfoRepository repository) {
        this.repository = repository;
    }

    public PermanentObjectInfo save(PermanentObjectInfo objectInfo) {
        return repository.save(objectInfo);
    }

    public Optional<PermanentObjectInfo> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public Iterable<PermanentObjectInfo> findAll() {
        return repository.findAll();
    }

    public Optional<PermanentObjectInfo> update(PermanentObjectInfo objectInfo) {
        return repository
                .findById(objectInfo.getUuid())
                .map((value) -> repository.save(objectInfo));
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
