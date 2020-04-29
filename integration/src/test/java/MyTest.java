import dao.UserDao;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import java.io.InputStream;
import java.util.Date;

/**
 * @author WangYao
 * @date 2020/4/29
 * @function 测试代码
 */
public class MyTest {

    @Test
    public void testSpringIoc(){
        ApplicationContext a = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = a.getBean("userService", UserService.class);
        System.out.println(userService.findAllUser());
    }

    @Test
    public void testMybatis() throws Exception{
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(resource).openSession();
        UserDao dao = session.getMapper(UserDao.class);
        System.out.println(dao.findAllUser());

        User user = new User();
        user.setId(52);
        user.setUsername("你好");
        user.setBirthday(new Date());
        user.setAddress("北京");
        user.setSex("男");
//        dao.saveUser(user);
//        session.commit();

        session.close();
        resource.close();
    }
}
