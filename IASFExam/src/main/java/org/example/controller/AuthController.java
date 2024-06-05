package org.example.controller;


import org.example.Service.*;
import org.example.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/register")
    public String register(@RequestParam String userId, @RequestParam String password, @RequestParam String role) {
        Member member = new Member();
        member.setUserId(userId);
        member.setPassword(password);
        memberService.registerMember(member, role);
        return "redirect:/auth/login";
    }
}

