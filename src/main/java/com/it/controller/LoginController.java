package com.it.controller;

import com.it.entity.R;
import com.it.entity.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String Index(){
        return "index";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "page/welcome";
    }

    @RequestMapping("/login")
    public String login(){
        return "login/login";
    }

    @ResponseBody
    @RequestMapping("/loginChack")
    public R loginChack(@RequestParam("username") String username,@RequestParam("password")String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userService.queryUser(user);
        if (user1!=null){
            return R.ok("请求成功");
        }
        else {
            return R.fail("登录失败，请检查用户名或密码");
        }
    }

}
