package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author WangYao
 * @date 2020/4/26
 * @function 试验返回类型
 */
@Controller
@RequestMapping("/return")
public class ReturnController {

    @RequestMapping("/string")
    public String testString(Model model) {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("王耀");

        model.addAttribute("王耀",user);
        return "ShowUser";
    }

    @RequestMapping("/void")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("成功");
        /*使用这个不会使用视图解析器,所以前缀后缀要加*/
//        request.getRequestDispatcher("/WEB-INF/pages/Hello.jsp").forward(request, response);
        /*重定向不能进文件夹*/
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        /*直接响应*/
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("你好");
    }

    @RequestMapping("/modelAndView")
    public ModelAndView testModelAndView(){
        User user = new User();
        user.setBirthday(new Date());
        user.setName("王耀");

         ModelAndView mv = new ModelAndView();
         mv.addObject("王耀",user);
         mv.setViewName("ShowUser");
         return mv;
    }

    @RequestMapping("/forwardOfRedirect")
    public String testForwardOfRedirect(){
//        使用forward
//        return "forward:/WEB-INF/pages/Hello.jsp";
//        redirect重定向,不能进文件夹
        return "redirect:/index.jsp";
    }

    //这个返回值不是跳转页面,而是到success,使用@ResponseBody可以使User转JavaBean
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User body){ //json转JavaBean, 有现成的包, 只要json的key与JavaBean的属性名一样
        System.out.println(body.getName());
        User user = new User();
        user.setName("王耀");
        return user;
    }
}
