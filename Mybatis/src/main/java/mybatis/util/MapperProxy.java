package mybatis.util;

import mybatis.cfg.Mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author WangYao
 * @date 2020/4/6
 * @function
 */
public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 方法增强
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取类名
        String className = method.getDeclaringClass().getName();
        //3.得到key
        String key = className+'.'+methodName;
//        System.out.println(mappers);
        //4.得到mapper
        Mapper mapper = mappers.get(key);
        if(mapper == null)
            throw new IllegalArgumentException("参数出错");
        //5.用工具类
        return new Executor().selectList(mapper, conn);
    }
}
