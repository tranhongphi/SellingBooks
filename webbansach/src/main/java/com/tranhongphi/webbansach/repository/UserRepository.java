package com.tranhongphi.webbansach.repository;

import com.tranhongphi.webbansach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findUserByEmailAndPassword(String email, String password);
    public User findUserByEmail(String email);
}
