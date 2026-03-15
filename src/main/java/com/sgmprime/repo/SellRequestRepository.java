package com.sgmprime.repo;

import com.sgmprime.model.entitities.SellRequest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRequestRepository extends JpaRepository<SellRequest, Integer> {
  SellRequest findBySellRequestPkId(Integer paramInteger);
  
  Long countBySellRequestPkId(Integer paramInteger);
  
  List<SellRequest> findByUserFkId(String paramString);
}
