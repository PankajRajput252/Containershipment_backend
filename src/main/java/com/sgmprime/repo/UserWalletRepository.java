package com.sgmprime.repo;

import com.sgmprime.model.entitities.UserWallet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet, Integer> {
  Long countByUserWalletPkId(Integer paramInteger);
  
  UserWallet findByUserWalletPkId(Integer paramInteger);
  

    UserWallet findByUserFkId( String userNodeId);
}


