package com.sgmprime.repo;
import com.sgmprime.model.entitities.Container;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerRepository extends JpaRepository<Container, Integer> {
  Container findByContainerPkId(Integer paramInteger);
  
  Long countByContainerPkId(Integer paramInteger);
}


