package com.example.StaffRecord.Service;

import com.example.StaffRecord.model.users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<users> getAllUsers();
    Optional<users> getUserById(int id);
    void saveUser(users user);
    void deleteUser(int id);
}
