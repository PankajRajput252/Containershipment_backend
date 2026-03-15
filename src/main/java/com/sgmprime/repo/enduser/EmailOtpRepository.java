package com.sgmprime.repo.enduser;

import com.sgmprime.model.entitities.enduser.EmailOtp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailOtpRepository extends JpaRepository<EmailOtp,Integer> {
    EmailOtp findTopByUserNodeIdOrderByCreatedDatetimeDesc(String userNodeId);
}
