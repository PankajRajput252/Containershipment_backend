 package com.sgmprime.service.ServiceImpl;

 import com.sgmprime.model.FinalResponse;
 import com.sgmprime.model.User;
 import com.sgmprime.model.Util;
 import com.sgmprime.model.entitities.Container;
 import com.sgmprime.model.entitities.Investment;
 import com.sgmprime.model.entitities.Payment;
 import com.sgmprime.model.entitities.RoiTransaction;
 import com.sgmprime.model.entitities.SellRequest;
 import com.sgmprime.model.entitities.UserWallet;
 import com.sgmprime.model.entitities.WithdrawRequest;
 import com.sgmprime.model.entitities.WithdrawalAccount;
 import com.sgmprime.model.entitities.enduser.EmailOtp;
 import com.sgmprime.model.entitities.enduser.SupportTicket;
 import com.sgmprime.repo.ContainerRepository;

 import com.sgmprime.repo.InvestmentRepository;
 import com.sgmprime.repo.PaymentRepository;
 import com.sgmprime.repo.RoiTransactionRepository;
 import com.sgmprime.repo.SellRequestRepository;

 import com.sgmprime.repo.UserRepository;
 import com.sgmprime.repo.UserWalletRepository;
 import com.sgmprime.repo.WithdrawRequestRepository;
 import com.sgmprime.repo.WithdrawalAccountRepository;
 import com.sgmprime.repo.enduser.EmailOtpRepository;
 import com.sgmprime.repo.enduser.SupportTicketRepository;
 import com.sgmprime.service.Service.ContainerService;
 import com.sgmprime.service.Service.ImageUploadService;
 import java.time.LocalDateTime;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.stream.Collectors;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.Pageable;
 import org.springframework.mail.SimpleMailMessage;
 import org.springframework.mail.javamail.JavaMailSender;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 @Service
 public class ContainerServiceImpl implements ContainerService {
   @Autowired
   private ContainerRepository containerRepository;
   @Autowired
   private InvestmentRepository investmentRepository;
   @Autowired
   private PaymentRepository paymentRepository;
   @Autowired
   private RoiTransactionRepository roiTransactionRepository;
   @Autowired
   private SellRequestRepository sellRequestRepository;
   @Autowired
   private ImageUploadService imageUploadService;
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private UserWalletRepository userWalletRepository;
   @Autowired
   private WithdrawalAccountRepository withdrawalAccountRepository;
   @Autowired
   private WithdrawRequestRepository withdrawRequestRepository;
   @Autowired
   private SupportTicketRepository supportTicketRepository;
   @Autowired
   private EmailOtpRepository emailOtpRepository;
   @Autowired
   private JavaMailSender mailSender;

   public FinalResponse getContainer(Integer inputPkId, Integer inputFkId, int page, int size, String filterBy, String searchValue) { FinalResponse<Container> finalResponse = new FinalResponse();
     Pageable pageable = Util.getPageable(size, page);
     List<Container> containerList = populateContainerView(inputPkId, inputFkId, filterBy, searchValue, pageable);
     Long count = populateContainerViewCount(inputPkId, inputFkId, filterBy);
     finalResponse.setData(containerList);
     finalResponse.setCount(count);
     Util.setSuccessMessage(finalResponse);
     return finalResponse; }

   private Long populateContainerViewCount(Integer inputPkId, Integer inputFkId, String filterBy) { Long count = Long.valueOf(0L);
     if (Util.isDefined(inputPkId)) {
       count = this.containerRepository.countByContainerPkId(inputPkId);
     } else {
       count = Long.valueOf(this.containerRepository.count());
     }

     return count; }


   private List<Container> populateContainerView(Integer inputPkId, Integer inputFkId, String filterBy, String searchValue, Pageable pageable) {
     List<Container> containerList = new ArrayList<>();
     if (Util.isDefined(inputPkId)) {
       Container container = this.containerRepository.findByContainerPkId(inputPkId);
       containerList.add(container);
     } else {
       containerList = this.containerRepository.findAll();
     }
     return containerList;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse addContainer(Container container) {
     FinalResponse finalResponse = new FinalResponse();
     this.containerRepository.save(container);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse updateContainer(Integer containerId, Container container) {
     FinalResponse finalResponse = new FinalResponse();
     this.containerRepository.findById(containerId)
       .map(existing -> {
           existing.setPriceInr(container.getPriceInr());
           return (Container)this.containerRepository.save(existing);
         }).orElseThrow(() -> new RuntimeException("Container not found"));
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse deleteContainer(Integer id) {
     FinalResponse finalResponse = new FinalResponse();
     this.containerRepository.deleteById(id);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse getInvestment(Integer inputPkId, String inputFkId, int page, int size, String filterBy, String searchValue) {
     FinalResponse<Investment> finalResponse = new FinalResponse();
     Pageable pageable = Util.getPageable(size, page);
     List<Investment> investments = populateInvestmentView(inputPkId, inputFkId, filterBy, searchValue, pageable);
     Long count = populateInvestmentViewCount(inputPkId, inputFkId, filterBy);
     finalResponse.setData(investments);
     finalResponse.setCount(count);
     Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }

   private Long populateInvestmentViewCount(Integer inputPkId, String inputFkId, String filterBy) {
     Long count = Long.valueOf(0L);
     if (Util.isDefined(inputPkId)) {
       count = this.investmentRepository.countByInvestmentPkId(inputPkId);
     }
     else if (Util.isDefined(inputFkId)) {
       count = this.investmentRepository.countByUserFkId(inputFkId);
     } else {

       count = Long.valueOf(this.investmentRepository.count());
     }

     return count;
   }

   private List<Investment> populateInvestmentView(Integer inputPkId, String inputFkId, String filterBy, String searchValue, Pageable pageable) {
     List<Investment> investmentList = new ArrayList<>();
     if (Util.isDefined(inputPkId)) {
       Investment investment = this.investmentRepository.findByInvestmentPkId(inputPkId);
       investmentList.add(investment);
     }
     else if (Util.isDefined(inputFkId)) {
       investmentList = this.investmentRepository.findByUserFkId(inputFkId);
     } else {

       investmentList = this.investmentRepository.findAll();
     }
     investmentList.stream().map(investment -> {
           Payment payment = this.paymentRepository.findByInvestmentFkIdAndUserFkId(investment.getInvestmentPkId(), investment.getUserFkId());
           if (Util.isDefined(payment)) {
             String presignedUrl = this.imageUploadService.generatePresignedUrl(payment.getImageId());
             investment.setImageUrl(presignedUrl);
           }
           return investment;
         }).collect(Collectors.toList());
     return investmentList;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse addInvestment(Investment investment) {
     FinalResponse finalResponse = new FinalResponse();
     this.investmentRepository.save(investment);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse updateInvestment(Integer investmentId, Investment investment) {
     FinalResponse finalResponse = new FinalResponse();
     this.investmentRepository.findById(investmentId)
       .map(existing -> {
           existing.setCurrency(investment.getCurrency());
           return (Investment)this.investmentRepository.save(existing);
         }).orElseThrow(() -> new RuntimeException("Investment not found"));
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse deleteInvestment(Integer id) {
     FinalResponse finalResponse = new FinalResponse();
     this.investmentRepository.deleteById(id);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse getPayment(Integer inputPkId, String inputFkId, int page, int size, String filterBy, String searchValue) {
     FinalResponse<Payment> finalResponse = new FinalResponse();
     Pageable pageable = Util.getPageable(size, page);
     List<Payment> paymentList = populatePaymentView(inputPkId, inputFkId, filterBy, searchValue, pageable);
     Long count = populatePaymentViewCount(inputPkId, inputFkId, filterBy);
     finalResponse.setData(paymentList);
     finalResponse.setCount(count);
     Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }

   private Long populatePaymentViewCount(Integer inputPkId, String inputFkId, String filterBy) {
     Long count = Long.valueOf(0L);
     if (Util.isDefined(inputPkId)) {
       count = this.paymentRepository.countByPaymentPkId(inputPkId);
     } else {
       count = Long.valueOf(this.paymentRepository.count());
     }

     return count;
   }

   private List<Payment> populatePaymentView(Integer inputPkId, String inputFkId, String filterBy, String searchValue, Pageable pageable) {
     List<Payment> paymentList = new ArrayList<>();
     if (Util.isDefined(inputPkId)) {
       Payment payment = this.paymentRepository.findByPaymentPkId(inputPkId);
       paymentList.add(payment);
     }
     else if (Util.isDefined(inputFkId)) {
       paymentList = this.paymentRepository.findByUserFkId(inputFkId);
     } else {

       paymentList = this.paymentRepository.findAll();
     }
     paymentList.stream().map(payment -> {
           if (Util.isDefined(payment.getImageId())) {
             String presignedUrl = this.imageUploadService.generatePresignedUrl(payment.getImageId());
             payment.setImageUrl(presignedUrl);
           }
           Investment investment = this.investmentRepository.findByInvestmentPkId(Integer.valueOf(payment.getInvestmentFkId()));
           if (Util.isDefined(investment)) {
             User user = this.userRepository.findByNodeIdAndActiveStateCodeFkId(investment.getUserFkId(), "ACTIVE");
             payment.setUser(user);
           }
           return payment;
         }).collect(Collectors.toList());
     return paymentList;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse addPayment(Payment payment) {
     FinalResponse finalResponse = new FinalResponse();
     payment = (Payment)this.paymentRepository.save(payment);
     finalResponse.setResponse(payment);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse updatePayment(Integer paymentId, Payment payment) {
     FinalResponse finalResponse = new FinalResponse();
     this.paymentRepository.findById(paymentId)
       .map(existing -> {
           existing.setStatus(payment.getStatus());
           return (Payment)this.paymentRepository.save(existing);
         }).orElseThrow(() -> new RuntimeException("Payment not found"));
     this.investmentRepository.updateInvestmentStatus("PAYMENT_APPROVED", payment.getUserFkId(), payment.getInvestmentFkId());
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse deletePayment(Integer id) {
     FinalResponse finalResponse = new FinalResponse();
     this.paymentRepository.deleteById(id);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse getRoiTransaction(Integer inputPkId, String inputFkId, int page, int size, String filterBy, String searchValue) {
     FinalResponse<RoiTransaction> finalResponse = new FinalResponse();
     Pageable pageable = Util.getPageable(size, page);
     List<RoiTransaction> roiTransactionList = populateRoiTransactionView(inputPkId, inputFkId, filterBy, searchValue, pageable);
     Long count = populateRoiTransactionViewCount(inputPkId, inputFkId, filterBy);
     finalResponse.setData(roiTransactionList);
     finalResponse.setCount(count);
     Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }

   private Long populateRoiTransactionViewCount(Integer inputPkId, String inputFkId, String filterBy) {
     Long count = Long.valueOf(0L);
     if (Util.isDefined(inputPkId)) {
       count = this.roiTransactionRepository.countByRoiTxnPkId(inputPkId);
     } else {
       count = Long.valueOf(this.roiTransactionRepository.count());
     }

     return count;
   }

   private List<RoiTransaction> populateRoiTransactionView(Integer inputPkId, String inputFkId, String filterBy, String searchValue, Pageable pageable) {
     List<RoiTransaction> roiTransactionList = new ArrayList<>();
     if (Util.isDefined(inputPkId)) {
       RoiTransaction roiTransaction = this.roiTransactionRepository.findByRoiTxnPkId(inputPkId);
       roiTransactionList.add(roiTransaction);
     }
     else if (Util.isDefined(inputFkId)) {
       roiTransactionList = this.roiTransactionRepository.findByUserFkId(inputFkId);
     } else {

       roiTransactionList = this.roiTransactionRepository.findAll();
     }
     return roiTransactionList;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse addRoiTransaction(RoiTransaction roiTransaction) {
     FinalResponse finalResponse = new FinalResponse();
     roiTransaction.setStatus("ACTIVE");
     this.investmentRepository.updateInvestmentStatus("RENTED", roiTransaction.getUserFkId(), roiTransaction.getInvestmentFkId());
     this.roiTransactionRepository.save(roiTransaction);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse updateRoiTransaction(Integer roiTxnPkId, RoiTransaction roiTransaction) {
     FinalResponse finalResponse = new FinalResponse();
     this.roiTransactionRepository.findById(roiTxnPkId)
       .map(existing -> {
           existing.setStatus(roiTransaction.getStatus());
           return (RoiTransaction)this.roiTransactionRepository.save(existing);
         }).orElseThrow(() -> new RuntimeException("RoiTransaction not found"));
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse deleteRoiTransaction(Integer id) {
     FinalResponse finalResponse = new FinalResponse();
     this.roiTransactionRepository.deleteById(id);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse getSellRequest(Integer inputPkId, String inputFkId, int page, int size, String filterBy, String searchValue) {
     FinalResponse<SellRequest> finalResponse = new FinalResponse();
     Pageable pageable = Util.getPageable(size, page);
     List<SellRequest> sellRequestList = populateSellRequestView(inputPkId, inputFkId, filterBy, searchValue, pageable);
     Long count = populateSellRequestViewCount(inputPkId, inputFkId, filterBy);
     finalResponse.setData(sellRequestList);
     finalResponse.setCount(count);
     Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }

   private Long populateSellRequestViewCount(Integer inputPkId, String inputFkId, String filterBy) {
     Long count = Long.valueOf(0L);
     if (Util.isDefined(inputPkId)) {
       count = this.sellRequestRepository.countBySellRequestPkId(inputPkId);
     } else {
       count = Long.valueOf(this.sellRequestRepository.count());
     }

     return count;
   }

   private List<SellRequest> populateSellRequestView(Integer inputPkId, String inputFkId, String filterBy, String searchValue, Pageable pageable) {
     List<SellRequest> sellRequestList = new ArrayList<>();
     if (Util.isDefined(inputPkId)) {
       SellRequest sellRequest = this.sellRequestRepository.findBySellRequestPkId(inputPkId);
       sellRequestList.add(sellRequest);
     }
     else if (Util.isDefined(inputFkId)) {
       sellRequestList = this.sellRequestRepository.findByUserFkId(inputFkId);
     } else {

       sellRequestList = this.sellRequestRepository.findAll();
     }
     sellRequestList.stream().map(sellRequest -> {
           Investment investment = this.investmentRepository.findByInvestmentPkId(Integer.valueOf(sellRequest.getInvestmentFkId()));

           if (Util.isDefined(investment)) {
             User user = this.userRepository.findByNodeIdAndActiveStateCodeFkId(investment.getUserFkId(), "ACTIVE");
             sellRequest.setUser(user);
             sellRequest.setInvestment(investment);
           }
           return sellRequest;
         }).collect(Collectors.toList());
     return sellRequestList;
   }

   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse addSellRequest(SellRequest sellRequest) {
     FinalResponse finalResponse = new FinalResponse();
     this.sellRequestRepository.save(sellRequest);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse updateSellRequest(Integer sellRequestPkId, SellRequest sellRequest) {
     FinalResponse finalResponse = new FinalResponse();
     this.sellRequestRepository.findById(sellRequestPkId)
       .map(existing -> {
           existing.setStatus(sellRequest.getStatus());
           existing.setApprovedAt(sellRequest.getApprovedAt());
           return (SellRequest)this.sellRequestRepository.save(existing);
         }).orElseThrow(() -> new RuntimeException("SellRequest not found"));
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   @Transactional(rollbackFor = {Exception.class})
   public FinalResponse deleteSellRequest(Integer id) {
     FinalResponse finalResponse = new FinalResponse();
     this.sellRequestRepository.deleteById(id);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse getUserWallet(Integer inputPkId, String inputFkId, int page, int size, String filterBy, String searchValue) {
     FinalResponse<UserWallet> finalResponse = new FinalResponse();
     Pageable pageable = Util.getPageable(size, page);
     List<UserWallet> userWalletList = populateUserWalletView(inputPkId, inputFkId, filterBy, searchValue, pageable);
     Long count = populateUserWalletViewCount(inputPkId, inputFkId, filterBy);
     finalResponse.setData(userWalletList);
     finalResponse.setCount(count);
     Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }

   private Long populateUserWalletViewCount(Integer inputPkId, String inputFkId, String filterBy) {
     Long count = Long.valueOf(0L);
     if (Util.isDefined(inputPkId)) {
       count = this.userWalletRepository.countByUserWalletPkId(inputPkId);
     } else {
       count = Long.valueOf(this.userWalletRepository.count());
     }

     return count;
   }

   private List<UserWallet> populateUserWalletView(Integer inputPkId, String inputFkId, String filterBy, String searchValue, Pageable pageable) {
     List<UserWallet> userWalletList = new ArrayList<>();
     if (Util.isDefined(inputPkId)) {
       UserWallet userWallet = this.userWalletRepository.findByUserWalletPkId(inputPkId);
       userWalletList.add(userWallet);
     }
     else if (Util.isDefined(inputFkId)) {
       userWalletList = this.userWalletRepository.findByUserFkId(inputFkId);
     } else {

       userWalletList = this.userWalletRepository.findAll();
     }
     userWalletList.stream().map(userWallet -> {
           User user = this.userRepository.findByNodeIdAndActiveStateCodeFkId(userWallet.getUserFkId(), "ACTIVE");


           userWallet.setUser(user);

           return userWallet;
         }).collect(Collectors.toList());
     return userWalletList;
   }


   public FinalResponse addUserWallet(UserWallet userWallet) {
     FinalResponse finalResponse = new FinalResponse();
     this.userWalletRepository.save(userWallet);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse updateUserWallet(Integer userWalletPkId, UserWallet userWallet) {
     FinalResponse finalResponse = new FinalResponse();
     this.userWalletRepository.findById(userWalletPkId)
       .map(existing -> {
           existing.setAvailableBalance(userWallet.getAvailableBalance());
           return (UserWallet)this.userWalletRepository.save(existing);
         }).orElseThrow(() -> new RuntimeException("UserWallet not found"));
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse deleteUserWallet(Integer id) {
     FinalResponse finalResponse = new FinalResponse();
     this.userWalletRepository.deleteById(id);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse getWithdrawalAccount(Integer inputPkId, String inputFkId, int page, int size, String filterBy, String searchValue) {
     FinalResponse<WithdrawalAccount> finalResponse = new FinalResponse();
     Pageable pageable = Util.getPageable(size, page);
     List<WithdrawalAccount> withdrawalAccountList = populateWithdrawalAccountView(inputPkId, inputFkId, filterBy, searchValue, pageable);
     Long count = populateWithdrawalAccountCount(inputPkId, inputFkId, filterBy);
     finalResponse.setData(withdrawalAccountList);
     finalResponse.setCount(count);
     Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }

   private Long populateWithdrawalAccountCount(Integer inputPkId, String inputFkId, String filterBy) {
     Long count = Long.valueOf(0L);
     if (Util.isDefined(inputPkId)) {
       count = this.withdrawalAccountRepository.countByWithdrawRequestPkId(inputPkId);
     } else {
       count = Long.valueOf(this.withdrawalAccountRepository.count());
     }

     return count;
   }

   private List<WithdrawalAccount> populateWithdrawalAccountView(Integer inputPkId, String inputFkId, String filterBy, String searchValue, Pageable pageable) {
     List<WithdrawalAccount> withdrawalAccountList = new ArrayList<>();
     if (Util.isDefined(inputPkId)) {
       WithdrawalAccount withdrawalAccount = this.withdrawalAccountRepository.findByWithdrawRequestPkId(inputPkId);
       withdrawalAccountList.add(withdrawalAccount);
     } else if (Util.isDefined(inputFkId)) {
       withdrawalAccountList = this.withdrawalAccountRepository.findByUserFkId(inputFkId);
     } else {
       withdrawalAccountList = this.withdrawalAccountRepository.findAll();
     }
     withdrawalAccountList.stream().map(withdrawalAccount -> {
           User user = this.userRepository.findByNodeIdAndActiveStateCodeFkId(withdrawalAccount.getUserFkId(), "ACTIVE");

           withdrawalAccount.setUser(user);
           return withdrawalAccount;
         }).collect(Collectors.toList());
     return withdrawalAccountList;
   }


   public FinalResponse addWithdrawalAccount(WithdrawalAccount withdrawalAccount) {
     FinalResponse finalResponse = new FinalResponse();
     this.withdrawalAccountRepository.save(withdrawalAccount);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse updateWithdrawalAccount(Integer withdrawalAccountPkId, WithdrawalAccount withdrawalAccount) {
     FinalResponse finalResponse = new FinalResponse();
     this.withdrawalAccountRepository.findById(withdrawalAccountPkId)
       .map(existing -> {
           existing.setAccountNumber(withdrawalAccount.getAccountNumber());
           existing.setAccountHolderName(withdrawalAccount.getAccountHolderName());
           existing.setBankName(withdrawalAccount.getBankName());
           existing.setIfscCode(withdrawalAccount.getIfscCode());
           return (WithdrawalAccount)this.withdrawalAccountRepository.save(existing);
         }).orElseThrow(() -> new RuntimeException("WithdrawalAccount not found"));
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse deleteWithdrawalAccount(Integer id) {
     FinalResponse finalResponse = new FinalResponse();
     this.withdrawalAccountRepository.deleteById(id);
     finalResponse = Util.setSuccessMessage(finalResponse);
     return finalResponse;
   }


   public FinalResponse getWithdrawRequest(Integer inputPkId, String inputFkId, int page, int size, String filterBy, String searchValue) {
     FinalResponse<WithdrawRequest> finalResponse = new FinalResponse();
     Pageable pageable = Util.getPageable(size, page);
     List<WithdrawRequest> withdrawRequestList = populateWithdrawRequestView(inputPkId, inputFkId, filterBy, searchValue, pageable);
     Long count = populateWithdrawRequestCount(inputPkId, inputFkId, filterBy);
     finalResponse.setData(withdrawRequestList);
     finalResponse.setCount(count);
    Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }

  private Long populateWithdrawRequestCount(Integer inputPkId, String inputFkId, String filterBy) {
    Long count = Long.valueOf(0L);
    if (Util.isDefined(inputPkId)) {
      count = this.withdrawRequestRepository.countByWithdrawRequestPkId(inputPkId);
    } else {
      count = Long.valueOf(this.withdrawRequestRepository.count());
    }

    return count;
  }

  private List<WithdrawRequest> populateWithdrawRequestView(Integer inputPkId, String inputFkId, String filterBy, String searchValue, Pageable pageable) {
    List<WithdrawRequest> withdrawRequestList = new ArrayList<>();
    if (Util.isDefined(inputPkId)) {
      WithdrawRequest withdrawRequest = this.withdrawRequestRepository.findByWithdrawRequestPkId(inputPkId);
      withdrawRequestList.add(withdrawRequest);
    } else if (Util.isDefined(inputFkId)) {
      withdrawRequestList = this.withdrawRequestRepository.findByUserFkId(inputFkId);
    } else {
      withdrawRequestList = this.withdrawRequestRepository.findAll();
    }
    withdrawRequestList.stream().map(withdrawalAccount -> {
          User user = this.userRepository.findByNodeIdAndActiveStateCodeFkId(withdrawalAccount.getUserFkId(), "ACTIVE");

          withdrawalAccount.setUser(user);
          return withdrawalAccount;
        }).collect(Collectors.toList());
    return withdrawRequestList;
  }


  public FinalResponse addWithdrawRequest(WithdrawRequest withdrawRequest) {
    FinalResponse finalResponse = new FinalResponse();
    this.withdrawRequestRepository.save(withdrawRequest);
    finalResponse = Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }


  public FinalResponse updateWithdrawRequest(Integer withdrawRequestPkId, WithdrawRequest withdrawRequest) {
    FinalResponse finalResponse = new FinalResponse();
    this.withdrawRequestRepository.findById(withdrawRequestPkId)
      .map(existing -> {
          existing.setStatus(withdrawRequest.getStatus());
          return (WithdrawRequest)this.withdrawRequestRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("withdrawRequest not found"));
    finalResponse = Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }


  public FinalResponse deleteWithdrawRequest(Integer id) {
    FinalResponse finalResponse = new FinalResponse();
    this.withdrawRequestRepository.deleteById(id);
    finalResponse = Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }




  public FinalResponse getSupportTicket(Integer inputPkId, String inputFkId, int page, int size, String filterBy, String searchValue) {
    FinalResponse<SupportTicket> finalResponse = new FinalResponse();
    Pageable pageable = Util.getPageable(size, page);
    List<SupportTicket> supportTicketList = populateSupportTicketView(inputPkId, inputFkId, filterBy, searchValue, pageable);
    Long count = populateSupportTicketCount(inputPkId, inputFkId, filterBy);
    finalResponse.setData(supportTicketList);
    finalResponse.setCount(count);
    Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }



  private Long populateSupportTicketCount(Integer inputPkId, String inputFkId, String filterBy) {
    Long count = Long.valueOf(0L);
    if (Util.isDefined(inputPkId)) {
      count = this.supportTicketRepository.countBySupportTicketPkId(inputPkId);
    }
    else if (Util.isDefined(inputFkId)) {
      count = this.supportTicketRepository.countByUserNodeId(inputFkId);
    } else {

      count = Long.valueOf(this.supportTicketRepository.count());
    }

    return count;
  }

  private List<SupportTicket> populateSupportTicketView(Integer inputPkId, String inputFkId, String filterBy, String searchValue, Pageable pageable) {
    List<SupportTicket> supportTicketList = new ArrayList<>();
    if (Util.isDefined(inputPkId)) {
      SupportTicket supportTicket = this.supportTicketRepository.findBySupportTicketPkId(inputPkId);
      supportTicketList.add(supportTicket);
    }
    else if (Util.isDefined(inputFkId)) {
      supportTicketList = this.supportTicketRepository.findByUserNodeId(inputFkId, pageable);
    } else {

      supportTicketList = this.supportTicketRepository.findAll();
    }
    supportTicketList.stream().map(supportTicket -> {
          String userName = this.userRepository.fetchUserNameBasedOnNodeId(supportTicket.getUserNodeId(),"ACTIVE");
          supportTicket.setUserName(userName);
          return supportTicket;
        }).collect(Collectors.toList());
    return supportTicketList;
  }


  @Transactional(rollbackFor = {Exception.class})
  public FinalResponse addSupportTicket(SupportTicket supportTicket) {
    FinalResponse finalResponse = new FinalResponse();
    supportTicket.setStatus("IN_PROGRESS");
    this.supportTicketRepository.save(supportTicket);
    finalResponse = Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }


  @Transactional(rollbackFor = {Exception.class})
  public FinalResponse updateSupportTicket(Integer id, SupportTicket supportTicket) {
    FinalResponse finalResponse = new FinalResponse();
    this.supportTicketRepository.findById(id)
      .map(existing -> {
          existing.setCategory(supportTicket.getCategory());
          existing.setPriority(supportTicket.getPriority());
          existing.setUserNodeId(supportTicket.getUserNodeId());
          existing.setMessage(supportTicket.getMessage());
          existing.setStatus(supportTicket.getStatus());
          return (SupportTicket)this.supportTicketRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException(" Support ticket  not found"));
    finalResponse = Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }


  @Transactional(rollbackFor = {Exception.class})
  public FinalResponse resolveSupport(Integer id) {
    FinalResponse finalResponse = new FinalResponse();
    this.supportTicketRepository.findById(id)
      .map(existing -> {
          existing.setStatus("RESOLVED");
          return (SupportTicket)this.supportTicketRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException(" Support ticket  not found"));
    finalResponse = Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }


  @Transactional(rollbackFor = {Exception.class})
  public FinalResponse deleteSupportTicket(Integer id) {
    FinalResponse finalResponse = new FinalResponse();
    this.supportTicketRepository.deleteById(id);
    finalResponse = Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }


  public String generateAndSave(String email, String userNodeId) {
    String otp = Util.generateOtp();
    EmailOtp entity = new EmailOtp();
    entity.setEmail(email);
    entity.setOtp(otp);
    entity.setUserNodeId(userNodeId);
    entity.setCreatedDatetime(String.valueOf(LocalDateTime.now()));
    entity.setExpiryTime(System.currentTimeMillis() + 120000L);
    this.emailOtpRepository.save(entity);
    return otp;
  }



  public FinalResponse sendOtp(String email, String otp) {
    FinalResponse finalResponse = new FinalResponse();
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setSubject("Your OTP for Verification");
    message.setText("Your OTP is: " + otp + "\n\nValid for 2 minutes.");

    this.mailSender.send(message);
    finalResponse.setMessage("OTP sent to email");
    finalResponse.setId(otp);
    Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }


  public FinalResponse getOtpForVerification(String userNodeId) {
    FinalResponse finalResponse = new FinalResponse();
    EmailOtp emailOtp = this.emailOtpRepository.findTopByUserNodeIdOrderByCreatedDatetimeDesc(userNodeId);
    finalResponse.setResponse(emailOtp);
    Util.setSuccessMessage(finalResponse);
    return finalResponse;
  }
}

