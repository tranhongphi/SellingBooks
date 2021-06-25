package com.tranhongphi.webbansach.controller;

import com.tranhongphi.webbansach.model.User;
import com.tranhongphi.webbansach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @GetMapping("/Register")
    public String GetRegister() {return "user/Register";}

    @PostMapping("/Register")
    public String PostRegister(HttpServletRequest request, HttpSession session, Model model) {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        if(!password.equals(repassword)) {
            model.addAttribute("messRegister", "Password is not match");
            return "user/Register";
        }else {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setEmail(email);
            user.setUserRole(2);
            if(userService.findUserByEmail(email)!=null) {
                model.addAttribute("messRegister","Email already exists");
                return "user/Register";
            }else {
                userService.saveUser(user);
                session.setAttribute("userRegister", user);
                return "user/Login";
            }
        }
    }
}
