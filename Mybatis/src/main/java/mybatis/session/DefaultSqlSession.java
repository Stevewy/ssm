package mybatis.session;

import mybatis.cfg.Configuration;
import mybatis.util.MapperProxy;
import mybatis.io.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author WangYao
 * @date 2020/4/6
 * @function
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        conn = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 创建代理对象  动态代理(要实现接口,代理接口方法)
     * @param daoInterfaceClass 接口字节码
     * @param <T>
     * @return 代理对象
     *
     * jdk里面
     * Proxy的newProxyInstance方法
     * ClassLoader是代理对象的类加载器,固定写法
     * Class[] 代理对象和被代理对象有相同的方法
     * InvocationHandler 如何代理,是InvocationHandler的实现类,实现invoke方法
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(), conn));
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
