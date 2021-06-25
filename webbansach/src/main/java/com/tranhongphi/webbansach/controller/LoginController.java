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
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping({"/Login",""})
    public String GetLogin(HttpSession session) {
        User user = new User();
        session.setAttribute("userRegister", user);
        return "user/Login";
    }

    @PostMapping("/Login")
    public String PostLogin(HttpServletRequest request, HttpSession session, Model model) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User userLogin = userService.findUserByEmailAndPassword(email, password);
        if(userLogin!=null) {
            session.setAttribute("userLogin", userLogin);
            if(userLogin.getUserRole()==1) {
                return "redirect:admin";
            }
            else {return "redirect:user/index";
            }
        }
        else {
            model.addAttribute("mess", "Email or password is not correct");
            return "user/Login";
        }
    }
}
