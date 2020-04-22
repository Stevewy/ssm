package dao;

import entity.Account;
import entity.QueryVo;

import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/10
 * @function 账号接口
 */
public interface AccountDao {

    List<Account> findAll();

    List<Account> findAllAccountAndUser();

    List<Account> findByUid(Integer id);
}
