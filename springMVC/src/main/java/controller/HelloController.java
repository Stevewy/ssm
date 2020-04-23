package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WangYao
 * @date 2020/4/23
 * @function 控制器
 */
@Controller
public class HelloController {

    @RequestMapping(path = "hello")
    public String sayHello(){
        System.out.println("Hello");
        return "Hello";
    }
}
