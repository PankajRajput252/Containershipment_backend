package com.sgmprime.service.Service;

import com.sgmprime.FinalException;
import com.sgmprime.model.FinalResponse;
import com.sgmprime.model.Role;
import com.sgmprime.model.User;

public interface UserService {
    FinalResponse createUser(User user) throws FinalException;

    FinalResponse getUser(Integer inputPkId, String inputFkId, int page, int size, String filterBy, String searchValue) throws FinalException;
//
//    FinalResponse deleteUser(User user) throws FinalException;
//
//    FinalResponse updateUser(User user) throws FinalException;

    FinalResponse addRole(Role role);

    FinalResponse getRole();

     FinalResponse createRegistration(User user) throws FinalException;

    FinalResponse deleteUser(Integer id);

    FinalResponse updateUserStatus(Integer id, String activeStatusCode);
}
