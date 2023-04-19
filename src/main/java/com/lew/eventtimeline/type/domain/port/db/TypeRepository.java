package com.lew.eventtimeline.type.domain.port.db;

import com.lew.eventtimeline.type.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
