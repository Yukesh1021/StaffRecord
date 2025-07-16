package com.example.StaffRecord.Service;

import com.example.StaffRecord.model.users;
import com.example.StaffRecord.Repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final userRepository userRepository;

    public UserServiceImpl(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<users> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveUser(users user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
