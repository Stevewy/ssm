package mybatis.session;

import java.sql.SQLException;

/**
 * @author WangYao
 * @date 2020/4/6
 * @function 创建dao接口的代理对象
 */
public interface SqlSession {

    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
