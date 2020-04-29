package service;

import entity.User;

import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/29
 * @function 业务层
 */
public interface UserService {
    List<User> findAllUser();

    void saveUser(User user);
}
