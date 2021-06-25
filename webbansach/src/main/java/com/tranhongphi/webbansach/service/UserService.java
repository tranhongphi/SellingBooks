package com.tranhongphi.webbansach.service;

import com.tranhongphi.webbansach.model.DanhMuc;
import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findUserByEmailAndPassword(String email, String password);
    User findUserByEmail(String email);
    void saveUser(User user);
    Page<User> pagiantionUser(int pageNo, int pageSize);
    boolean save(User user);
}
