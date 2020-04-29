package dao;

import entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/29
 * @function dao层
 */
@Repository("userDao")
public interface UserDao {

    @Select("select * from user")
    List<User> findAllUser();

    @Insert("insert into user(username,address,sex,birthday)values (#{username},#{address},#{sex},#{birthday});")
    void saveUser(User user);

}
