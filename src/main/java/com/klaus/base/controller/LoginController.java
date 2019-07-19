package com.klaus.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @RequestMapping("/")
    public ModelAndView loginPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/login.do")
    public ModelAndView login(HttpServletRequest request){
        String userId = request.getParameter("usrId");
        String password = request.getParameter("pwd");
        ModelAndView mv = new ModelAndView();
        if(userId.equals("wfq")&&password.equals("1")){
            mv.setViewName("userManage");
        }else{
            mv.setViewName("login");
        }

        return mv;
    }
}
