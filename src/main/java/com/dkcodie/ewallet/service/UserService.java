package com.dkcodie.ewallet.service;

import com.dkcodie.ewallet.dto.UserDto;
import com.dkcodie.ewallet.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    User findById(Long id);

    List<UserDto> findAllUsers();

    User getCurrentUserDetails();

    List<User> findAllUsersExceptCurrent();

    void deleteUserById(Long userId);
}
