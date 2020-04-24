package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WangYao
 * @date 2020/4/23
 * @function 控制器
 */
@Controller
@RequestMapping(path = "/hello")
public class HelloController {

    /*
     * name
     * value 和path一样
     * path 请求的url
     * method 请求方式
     * params key value 需要传入的参数,key与value必须一样
     * headers 包含请求头
     */
    @RequestMapping(path = "/say")
    public String sayHello(){
        System.out.println("Hello");
        return "Hello";
    }
}
