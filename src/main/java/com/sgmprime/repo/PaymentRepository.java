package com.sgmprime.repo;

import com.sgmprime.model.entitities.Payment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
  Long countByPaymentPkId(Integer paramInteger);
  
  Payment findByPaymentPkId(Integer paramInteger);
  
  @Transactional
  @Modifying
  @Query("update Payment u set u.imageId = ?1 where u.userFkId = ?2 and u.paymentPkId=?3 ")
  int updateProfileImageUrlBasedOnNodeId(String paramString1, String paramString2, int paramInt);
  
  List<Payment> findByUserFkId(String paramString);
  
  Payment findByInvestmentFkIdAndUserFkId(int paramInt, String paramString);
}

