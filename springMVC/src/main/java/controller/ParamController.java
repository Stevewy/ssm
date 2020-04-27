package controller;

import entity.Account;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WangYao
 * @date 2020/4/24
 * @function 测试带参数的控制器
 */
@Controller
@RequestMapping("/param")
@SessionAttributes(value = {"放key"})
public class ParamController {

    @RequestMapping("/hello")
    public String param(@RequestParam(name = "name") String name){
        System.out.println(name);
        return "Hello";
    }

    @RequestMapping("/bean")
    public String saveAccount(Account account){
        System.out.println(account);
        return "Hello";
    }

    @ModelAttribute
    public void before(){
        System.out.println("会先执行,如果返回,是返回到要执行的方法的参数上");
    }

    @RequestMapping("/converter")
    public String saveUser(User user, HttpServletRequest request, HttpServletResponse response){ //后两个是SpringMVC自带的
        System.out.println(user);
        return "Hello";
    }
}
