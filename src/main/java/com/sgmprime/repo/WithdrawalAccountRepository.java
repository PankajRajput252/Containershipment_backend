package com.sgmprime.repo;
import com.sgmprime.model.entitities.WithdrawalAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalAccountRepository extends JpaRepository<WithdrawalAccount, Integer> {
  List<WithdrawalAccount> findByUserFkId(String paramString);
  
  WithdrawalAccount findByWithdrawRequestPkId(Integer paramInteger);
  
  Long countByWithdrawRequestPkId(Integer paramInteger);
}

