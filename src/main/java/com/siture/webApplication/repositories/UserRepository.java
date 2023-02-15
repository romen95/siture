package com.siture.webApplication.repositories;

import com.siture.webApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByphoneNumber(String phoneNumber);
}
