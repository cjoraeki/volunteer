package com.example.volunteer.repository;

import com.example.volunteer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

//    Optional<User> findByIdUuid(String uuid);
//    Optional<User> findByEmail(String uuid);
//    boolean existsByEmail(String email);
}
