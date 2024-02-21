package ru.bcomms.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.bcomms.address.entity.AbstractEntity;

import java.util.UUID;

@NoRepositoryBean
public interface CommonRepository<E extends AbstractEntity> extends JpaRepository<E, UUID> {
}
