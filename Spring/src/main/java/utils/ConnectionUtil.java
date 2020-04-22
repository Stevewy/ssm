package utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author WangYao
 * @date 2020/4/19
 * @function 连接工具
 */
public class ConnectionUtil {
    private DataSource dataSource;
    private ThreadLocal<Connection> t = new ThreadLocal<>();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection(){
        Connection connection = t.get();
        if(connection == null){
            System.out.println("第一次获取数据");
            try {
                connection = dataSource.getConnection();
                t.set(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void removeConnection(){
        t.remove();
        System.out.println("销毁了数据");
    }
}
