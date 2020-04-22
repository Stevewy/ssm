package mybatis.session;

/**
 * @author WangYao
 * @date 2020/4/6
 * @function 创建SqlSession
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
