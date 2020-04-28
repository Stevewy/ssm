package controller;

import exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WangYao
 * @date 2020/4/28
 * @function
 */
@Controller
@RequestMapping("/Exception")
public class ExceptionController {

    @RequestMapping("/Exception")
    public String testException() throws SysException{
        try {
            int a = 1/0;
        } catch (Exception e) {
            throw new SysException("出错");
        }
        return "Hello";
    }
}
