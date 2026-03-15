package com.sgmprime.repo;

import com.sgmprime.model.entitities.WithdrawRequest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawRequestRepository extends JpaRepository<WithdrawRequest, Integer> {
  WithdrawRequest findByWithdrawRequestPkId(Integer paramInteger);
  
  List<WithdrawRequest> findByUserFkId(String paramString);
  
  Long countByWithdrawRequestPkId(Integer paramInteger);
}

