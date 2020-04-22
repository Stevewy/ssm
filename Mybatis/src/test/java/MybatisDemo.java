

import dao.AccountDao;
import dao.UserDao;
import entity.Account;
import entity.QueryVo;
import entity.User;
//import mybatis.io.Resources;
//import mybatis.session.SqlSession;
//import mybatis.session.SqlSessionFactory;
//import mybatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/4
 * @function 测试用例
 *
 * 1.使用mybatis来增删改查
 * 2.多表查询 一对多,一对一,多对多
 * 3.缓存
 */
public class MybatisDemo {
    private static InputStream in;
    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory factory;
    private static SqlSession session;

    //重复代码利用
    @Before
    public void init() throws Exception {
        //读取(不使用相对路径和绝对路径,使用类加载器)
        in = Resources.getResourceAsStream("SqlMap.xml");
        //工厂(构建者模式) 通过配置文件来创建工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //SqlSession对象(工厂方法)
        session = factory.openSession(false);//参数自动提交
    }

    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 增删改查
     */

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("王耀");
        user.setAddress("北京");
        user.setSex("男");
        user.setBirthday(new Date());

        UserDao userDao = session.getMapper(UserDao.class);
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void testDelete() {
        UserDao userDao = session.getMapper(UserDao.class);
        userDao.deleteUser(51);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("王耀");
        user.setAddress("北京");
        user.setSex("男");
        user.setBirthday(new Date());

        UserDao userDao = session.getMapper(UserDao.class);
        userDao.updateUser(user);
    }

    @Test
    public void testFindAll() {
        UserDao userDao = session.getMapper(UserDao.class);
        for (User user : userDao.findAll())
            System.out.println(user);
        AccountDao accountDao = session.getMapper(AccountDao.class);
        for (Account account : accountDao.findAll())
            System.out.println(account);
    }

    @Test
    public void testFindById() {
        UserDao userDao = session.getMapper(UserDao.class);
        System.out.println(userDao.findById(50));
    }

    @Test
    public void testFindByName() {
        UserDao userDao = session.getMapper(UserDao.class);
        for (User user : userDao.findByName("%王%"))
            System.out.println(user);
    }

    @Test
    public void testFindTotal() {
        UserDao userDao = session.getMapper(UserDao.class);
        System.out.println(userDao.findTotal());
    }

    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        UserDao userDao = session.getMapper(UserDao.class);
        for (User u : userDao.findByVo(vo))
            System.out.println(u);
    }

    @Test
    public void testFindByCondition() {
        UserDao userDao = session.getMapper(UserDao.class);
        User u = new User();
        u.setUsername("王耀");
//        u.setSex("好");
        for (User user : userDao.findByCondition(u))
            System.out.println(user);
    }

    @Test
    public void testFindByIds() {
        UserDao userDao = session.getMapper(UserDao.class);
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(41);
        list.add(50);
        vo.setIds(list);
        for (User user : userDao.findByIds(vo))
            System.out.println(user);
    }

    @Test
    public void testFindAllAccountAndUser() {
        AccountDao accountDao = session.getMapper(AccountDao.class);
        for (Account account : accountDao.findAllAccountAndUser())
            System.out.println(account);
    }

    @Test
    public void testFindAllUserAndAccount() {
        UserDao userDao = session.getMapper(UserDao.class);
        for (User user : userDao.findAllUserAndAccount())
            System.out.println(user);
    }

    @Test
    public void testFirstLevelCache(){
        UserDao userDao = session.getMapper(UserDao.class);
        User user1 = userDao.findById(41);
        User user2 = userDao.findById(41);
        System.out.println(user1 == user2);
        UserDao nuserDao = session.getMapper(UserDao.class);
        System.out.println(userDao == nuserDao);  //可见代理对象不一样
        User user3 = nuserDao.findById(41);
        System.out.println(user1 == user3);       //但是查出来的结果是一个

//        session.clearCache(); 这个和close都会清空缓存
    }

    @Test
    public void testClearCache(){
        //得到user1,做更改时他地址不变,但是重写查user2不是从缓存读取而是从数据库重新读,
        UserDao userDao = session.getMapper(UserDao.class);
        User user1 = userDao.findById(41);
        System.out.println(user1.getUsername());
        user1.setUsername("你好");
        userDao.updateUser(user1);
        User user2 = userDao.findById(41);
        System.out.println(user2.getUsername());
        session.rollback();
        User user3 = userDao.findById(41);
        System.out.println(user3.getUsername());
    }

    public static void main(String[] args) throws Exception {

    }
}
