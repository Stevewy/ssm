package mybatis.session;

import mybatis.cfg.Configuration;
import mybatis.util.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author WangYao
 * @date 2020/4/6
 * @function 创建SqlSessionFactory
 */
public class SqlSessionFactoryBuilder {

    /**
     * 构建工厂
     * @param in 字节流
     * @return 工厂
     */
    public SqlSessionFactory build(InputStream in) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
