package com.hcl.pp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {

	@GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        return "redirect:user/login";
    }
}
