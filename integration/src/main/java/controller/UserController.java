package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author WangYao
 * @date 2020/4/29
 * @function 控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("list", userService.findAllUser());
        return "list";
    }

    @RequestMapping("/save")
    public void save(User user, HttpServletRequest request, HttpServletResponse response) throws Exception{
        userService.saveUser(user);
        response.sendRedirect(request.getContextPath()+"/user/findAll");
//        return "list";
    }

}
