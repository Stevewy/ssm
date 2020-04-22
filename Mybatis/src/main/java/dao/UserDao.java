package dao;

import entity.QueryVo;
import entity.User;
import mybatis.annotation.Select;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/4
 * @function
 */
public interface UserDao {

    void saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

    //@Select("select * from user")//使用注解
    List<User> findAll();

    User findById(Integer id);

    List<User> findByName(String username);

    int findTotal();

    List<User> findByVo(QueryVo vo);

    List<User> findByCondition(User user);

    List<User> findByIds(QueryVo vo);

    List<User> findAllUserAndAccount();
}
