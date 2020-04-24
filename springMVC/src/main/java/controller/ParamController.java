package controller;

import entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WangYao
 * @date 2020/4/24
 * @function
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/hello")
    public String param(String name){
        return name;
    }

    @RequestMapping("/bean")
    public String showAccount(Account account){
        System.out.println(account);
        return "Hello";
    }
}
