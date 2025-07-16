package com.example.StaffRecord.Repository;

import com.example.StaffRecord.model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<users,Integer> {
    @Override
    Optional<users> findById(Integer integer);
}
