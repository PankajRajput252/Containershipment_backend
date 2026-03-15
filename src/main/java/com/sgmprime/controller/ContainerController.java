package com.sgmprime.controller;

import com.sgmprime.FinalException;
import com.sgmprime.model.entitities.*;
import com.sgmprime.model.FinalResponse;
import com.sgmprime.model.Util;
import com.sgmprime.model.entitities.enduser.SupportTicket;
import com.sgmprime.service.Service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin({"*"})
@RestController
@RequestMapping({"/api/container"})
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    @GetMapping({"/getContainer"})
    public FinalResponse getContainer(@RequestParam(value = "inputPkId", required = false) String inputPkId, @RequestParam(value = "inputFkId", required = false) String inputFkId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "25") int size, @RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchValue", required = false) String searchValue) throws FinalException {
        Integer inputPkIdInt = null;
        Integer inputFkIdInt = null;
        if (Util.isDefined(inputPkId)) {
            inputPkIdInt = Util.convertStringToInteger(inputPkId);
        }
        if (Util.isDefined(inputFkId)) {
            inputFkIdInt = Util.convertStringToInteger(inputFkId);
        }
        return this.containerService.getContainer(inputPkIdInt, inputFkIdInt, page, size, filterBy, searchValue);
    }



    @PostMapping({"/addContainer"})
    public FinalResponse addContainer(@RequestBody Container container) throws FinalException {
        return this.containerService.addContainer(container);
    }

    @PutMapping({"/updateContainer/{id}"})
    public FinalResponse updateContainer(@PathVariable Integer id, @RequestBody Container container) {
        return this.containerService.updateContainer(id, container);
    }

    @DeleteMapping({"/deleteContainer/{id}"})
    public FinalResponse deleteContainer(@PathVariable Integer id) {
        return this.containerService.deleteContainer(id);
    }


    @GetMapping({"/getInvestment"})
    public FinalResponse getInvestment(@RequestParam(value = "inputPkId", required = false) String inputPkId, @RequestParam(value = "inputFkId", required = false) String inputFkId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "25") int size, @RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchValue", required = false) String searchValue) throws FinalException {
        Integer inputPkIdInt = null;
        Integer inputFkIdInt = null;
        if (Util.isDefined(inputPkId)) {
            inputPkIdInt = Util.convertStringToInteger(inputPkId);
        }
        return this.containerService.getInvestment(inputPkIdInt, inputFkId, page, size, filterBy, searchValue);
    }

    @PostMapping({"/addInvestment"})
    public FinalResponse addInvestment(@RequestBody Investment investment) throws FinalException {
        return this.containerService.addInvestment(investment);
    }

    @PutMapping({"/updateInvestment/{id}"})
    public FinalResponse updateInvestment(@PathVariable Integer id, @RequestBody Investment investment) {
        return this.containerService.updateInvestment(id, investment);
    }

    @DeleteMapping({"/deleteInvestment/{id}"})
    public FinalResponse deleteInvestment(@PathVariable Integer id) {
        return this.containerService.deleteInvestment(id);
    }


    @GetMapping({"/getPayment"})
    public FinalResponse getPayment(@RequestParam(value = "inputPkId", required = false) String inputPkId, @RequestParam(value = "inputFkId", required = false) String inputFkId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "25") int size, @RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchValue", required = false) String searchValue) throws FinalException {
        Integer inputPkIdInt = null;
        Integer inputFkIdInt = null;
        if (Util.isDefined(inputPkId)) {
            inputPkIdInt = Util.convertStringToInteger(inputPkId);
        }
        return this.containerService.getPayment(inputPkIdInt, inputFkId, page, size, filterBy, searchValue);
    }

    @PostMapping({"/addPayment"})
    public FinalResponse addPayment(@RequestBody Payment payment) throws FinalException {
        return this.containerService.addPayment(payment);
    }

    @PutMapping({"/updatePayment/{id}"})
    public FinalResponse updatePayment(@PathVariable Integer id, @RequestBody Payment payment) {
        return this.containerService.updatePayment(id, payment);
    }

    @DeleteMapping({"/deletePayment/{id}"})
    public FinalResponse deletePayment(@PathVariable Integer id) {
        return this.containerService.deletePayment(id);
    }


    @GetMapping({"/getRoiTransaction"})
    public FinalResponse getRoiTransaction(@RequestParam(value = "inputPkId", required = false) String inputPkId, @RequestParam(value = "inputFkId", required = false) String inputFkId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "25") int size, @RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchValue", required = false) String searchValue) throws FinalException {
        Integer inputPkIdInt = null;
        Integer inputFkIdInt = null;
        if (Util.isDefined(inputPkId)) {
            inputPkIdInt = Util.convertStringToInteger(inputPkId);
        }
        return this.containerService.getRoiTransaction(inputPkIdInt, inputFkId, page, size, filterBy, searchValue);
    }

    @PostMapping({"/addRoiTransaction"})
    public FinalResponse addRoiTransaction(@RequestBody RoiTransaction roiTransaction) throws FinalException {
        return this.containerService.addRoiTransaction(roiTransaction);
    }

    @PutMapping({"/updateRoiTransaction/{id}"})
    public FinalResponse updateRoiTransaction(@PathVariable Integer id, @RequestBody RoiTransaction roiTransaction) {
        return this.containerService.updateRoiTransaction(id, roiTransaction);
    }


    @DeleteMapping({"/deleteRoiTransaction/{id}"})
    public FinalResponse deleteRoiTransaction(@PathVariable Integer id) {
        return this.containerService.deleteRoiTransaction(id);
    }


    @GetMapping({"/getSellRequest"})
    public FinalResponse getSellRequest(@RequestParam(value = "inputPkId", required = false) String inputPkId, @RequestParam(value = "inputFkId", required = false) String inputFkId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "25") int size, @RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchValue", required = false) String searchValue) throws FinalException {
        Integer inputPkIdInt = null;
        Integer inputFkIdInt = null;
        if (Util.isDefined(inputPkId)) {
            inputPkIdInt = Util.convertStringToInteger(inputPkId);
        }

        return this.containerService.getSellRequest(inputPkIdInt, inputFkId, page, size, filterBy, searchValue);
    }

    @PostMapping({"/addSellRequest"})
    public FinalResponse addSellRequest(@RequestBody SellRequest sellRequest) throws FinalException {
        return this.containerService.addSellRequest(sellRequest);
    }

    @PutMapping({"/updateSellRequest/{id}"})
    public FinalResponse updateSellRequest(@PathVariable Integer id, @RequestBody SellRequest sellRequest) {
        return this.containerService.updateSellRequest(id, sellRequest);
    }


    @DeleteMapping({"/deleteSellRequest/{id}"})
    public FinalResponse deleteSellRequest(@PathVariable Integer id) {
        return this.containerService.deleteSellRequest(id);
    }


    @GetMapping({"/getUserWallet"})
    public FinalResponse getUserWallet(@RequestParam(value = "inputPkId", required = false) String inputPkId, @RequestParam(value = "inputFkId", required = false) String inputFkId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "25") int size, @RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchValue", required = false) String searchValue) throws FinalException {
        Integer inputPkIdInt = null;
        Integer inputFkIdInt = null;
        if (Util.isDefined(inputPkId)) {
            inputPkIdInt = Util.convertStringToInteger(inputPkId);
        }

        return this.containerService.getUserWallet(inputPkIdInt, inputFkId, page, size, filterBy, searchValue);
    }

    @PostMapping({"/addUserWallet"})
    public FinalResponse addUserWallet(@RequestBody UserWallet userWallet) throws FinalException {
        return this.containerService.addUserWallet(userWallet);
    }

    @PutMapping({"/updateUserWallet/{id}"})
    public FinalResponse updateUserWallet(@PathVariable Integer id, @RequestBody UserWallet userWallet) {
        return this.containerService.updateUserWallet(id, userWallet);
    }


    @DeleteMapping({"/deleteUserWallet/{id}"})
    public FinalResponse deleteUserWallet(@PathVariable Integer id) {
        return this.containerService.deleteUserWallet(id);
    }


    @GetMapping({"/getWithdrawalAccount"})
    public FinalResponse getWithdrawalAccount(@RequestParam(value = "inputPkId", required = false) String inputPkId, @RequestParam(value = "inputFkId", required = false) String inputFkId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "25") int size, @RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchValue", required = false) String searchValue) throws FinalException {
        Integer inputPkIdInt = null;
        Integer inputFkIdInt = null;
        if (Util.isDefined(inputPkId)) {
            inputPkIdInt = Util.convertStringToInteger(inputPkId);
        }

        return this.containerService.getWithdrawalAccount(inputPkIdInt, inputFkId, page, size, filterBy, searchValue);
    }

    @PostMapping({"/addWithdrawalAccount"})
    public FinalResponse addWithdrawalAccount(@RequestBody WithdrawalAccount withdrawalAccount) throws FinalException {
        return this.containerService.addWithdrawalAccount(withdrawalAccount);
    }

    @PutMapping({"/updateWithdrawalAccount/{id}"})
    public FinalResponse updateWithdrawalAccount(@PathVariable Integer id, @RequestBody WithdrawalAccount withdrawalAccount) {
        return this.containerService.updateWithdrawalAccount(id, withdrawalAccount);
    }


    @DeleteMapping({"/deleteWithdrawalAccount/{id}"})
    public FinalResponse deleteWithdrawalAccount(@PathVariable Integer id) {
        return this.containerService.deleteWithdrawalAccount(id);
    }


    @GetMapping({"/getWithdrawRequest"})
    public FinalResponse getWithdrawRequest(@RequestParam(value = "inputPkId", required = false) String inputPkId, @RequestParam(value = "inputFkId", required = false) String inputFkId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "25") int size, @RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchValue", required = false) String searchValue) throws FinalException {
        Integer inputPkIdInt = null;
        Integer inputFkIdInt = null;
        if (Util.isDefined(inputPkId)) {
            inputPkIdInt = Util.convertStringToInteger(inputPkId);
        }

        return this.containerService.getWithdrawRequest(inputPkIdInt, inputFkId, page, size, filterBy, searchValue);
    }

    @PostMapping({"/addWithdrawRequest"})
    public FinalResponse addWithdrawRequest(@RequestBody WithdrawRequest withdrawRequest) throws FinalException {
        return this.containerService.addWithdrawRequest(withdrawRequest);
    }

    @PutMapping({"/updateWithdrawRequest/{id}"})
    public FinalResponse updateWithdrawRequest(@PathVariable Integer id, @RequestBody WithdrawRequest withdrawRequest) {
        return this.containerService.updateWithdrawRequest(id, withdrawRequest);
    }


    @DeleteMapping({"/deleteWithdrawRequest/{id}"})
    public FinalResponse deleteWithdrawRequest(@PathVariable Integer id) {
        return this.containerService.deleteWithdrawRequest(id);
    }


    @GetMapping({"/getSupportTicket"})
    public FinalResponse getSupportTicket(@RequestParam(value = "inputPkId", required = false) String inputPkId, @RequestParam(value = "inputFkId", required = false) String inputFkId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "25") int size, @RequestParam(value = "filterBy", required = false) String filterBy, @RequestParam(value = "searchValue", required = false) String searchValue) throws FinalException {
        Integer inputPkIdInt = null;
        if (Util.isDefined(inputPkId)) {
            inputPkIdInt = Util.convertStringToInteger(inputPkId);
        }
        return this.containerService.getSupportTicket(inputPkIdInt, inputFkId, page, size, filterBy, searchValue);
    }

    @PostMapping({"/addSupportTicket"})
    public FinalResponse addSupportTicket(@RequestBody SupportTicket supportTicket) throws FinalException {
        return this.containerService.addSupportTicket(supportTicket);
    }

    @PutMapping({"/updateSupportTicket/{id}"})
    public FinalResponse updateSupportTicket(@PathVariable Integer id, @RequestBody SupportTicket supportTicket) {
        return this.containerService.updateSupportTicket(id, supportTicket);
    }

    @PutMapping({"/resolveSupport/{id}"})
    public FinalResponse resolveSupport(@PathVariable Integer id) {
        return this.containerService.resolveSupport(id);
    }

    @DeleteMapping({"/deleteSupportTicket/{id}"})
    public FinalResponse deleteSupportTicket(@PathVariable Integer id) {
        return this.containerService.deleteSupportTicket(id);
    }


    @PostMapping({"/sendEmailOtp"})
    public FinalResponse sendEmailOtp(@RequestParam String email, @RequestParam String userNodeId) throws FinalException {
        String otp = this.containerService.generateAndSave(email, userNodeId);
        return this.containerService.sendOtp(email, otp);
    }


    @GetMapping({"/getOtpForVerification"})
    public FinalResponse getOtpForVerification(@RequestParam("userNodeId") String userNodeId) throws FinalException {
        return this.containerService.getOtpForVerification(userNodeId);
    }

}
