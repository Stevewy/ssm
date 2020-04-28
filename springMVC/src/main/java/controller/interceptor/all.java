package controller.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WangYao
 * @date 2020/4/28
 * @function 拦截器
 */
public class all implements HandlerInterceptor {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return true 放行, false不放行
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截前的方法");
        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response); //直接跳,但是还是放行了
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("执行后,跳转前");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("跳转后");
    }

}
