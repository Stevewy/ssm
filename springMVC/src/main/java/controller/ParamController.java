package controller;

import entity.Account;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WangYao
 * @date 2020/4/24
 * @function 测试带参数的控制器
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/hello")
    public String param(String name){
        return name;
    }

    @RequestMapping("/bean")
    public String saveAccount(Account account){
        System.out.println(account);
        return "Hello";
    }

    @RequestMapping("/converter")
    public String saveUser(User user, HttpServletRequest request, HttpServletResponse response){ //后两个是SpringMVC自带的
        System.out.println(user);
        return "Hello";
    }
}
