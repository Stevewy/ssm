package utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author WangYao
 * @date 2020/4/19
 * @function 事务控制类
 */
@Component("manager")
@Aspect
public class TransactionManager {
    private ConnectionUtil connectionUtil;

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    @Pointcut("execution( * service.impl.*.*(..))")
    public void all(){ }

    @Before("all()")
    public void begin(){
        try {
            connectionUtil.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterReturning("all()")
    public void commit(){
        try {
            connectionUtil.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterThrowing("all()")
    public void rollback(){
        try {
            connectionUtil.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After("all()")
    public void release(){
        try {
            connectionUtil.getConnection().close();
            connectionUtil.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("all()")
    public void stop(ProceedingJoinPoint pip) {
//        pip.proceed()//停下来就不要动了
        System.out.println("停止了思考");
    }
}
