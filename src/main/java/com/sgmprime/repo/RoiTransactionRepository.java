package com.sgmprime.repo;

import com.sgmprime.model.entitities.RoiTransaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoiTransactionRepository extends JpaRepository<RoiTransaction, Integer> {
  RoiTransaction findByRoiTxnPkId(Integer paramInteger);
  
  Long countByRoiTxnPkId(Integer paramInteger);
  
  List<RoiTransaction> findByUserFkId(String paramString);
}
