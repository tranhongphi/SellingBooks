package com.tranhongphi.webbansach.repository;

import com.tranhongphi.webbansach.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findUserByEmailAndPassword(String email, String password);
    public User findUserByEmail(String email);
    public List<User> findAll();
}
