package com.levi.log.controller.admin;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.levi.log.pojo.User;
import com.levi.log.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    @Autowired
    UserService us;

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }
    @GetMapping("/index")
    public String indexPage(){
        return "admin/index";
    }


    //登录
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
                        RedirectAttributes redirectAttributes, Model model){
        User user = us.getUser(username);
        if(user != null){
            if(user.getUserPassword().equals(password)){
                //登录成功
                user.setUserPassword(null);
                session.setAttribute("user",user);

                model.addAttribute("user",user);
                return "redirect:/admin/index";
            }else{
                //密码错误
                redirectAttributes.addFlashAttribute("message","密码错误");
                return "redirect:/admin";
            }
        }
        //用户不存在
        redirectAttributes.addFlashAttribute("message","用户不存在");
        return "redirect:/admin";
    }

    //注销
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }

    @PostMapping("/json")
    @ResponseBody
    public String json(){
        User user = new User();
        user.setUserName("leviAckman");
        user.setUserProfilePhoto("/images/profilephoto.jpg");
        return JSON.toJSONString(user);
    }
}
