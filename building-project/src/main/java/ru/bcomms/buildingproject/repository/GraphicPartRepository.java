package ru.bcomms.buildingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bcomms.buildingproject.entity.GraphicPart;

import java.util.UUID;

@Repository
public interface GraphicPartRepository extends CommonRepository<GraphicPart> {
}
