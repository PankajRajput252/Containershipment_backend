package com.sgmprime.repo;

import com.sgmprime.model.entitities.Investment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface InvestmentRepository extends JpaRepository<Investment, Integer> {
  Long countByInvestmentPkId(Integer paramInteger);
  
  Investment findByInvestmentPkId(Integer paramInteger);
  
  List<Investment> findByUserFkId(String paramString);
  
  Long countByUserFkId(String paramString);
  
  @Transactional
  @Modifying
  @Query("update Investment u set u.status = ?1 where u.userFkId = ?2 and u.investmentPkId=?3 ")
  int updateInvestmentStatus(String paramString1, String paramString2, int paramInt);
}


