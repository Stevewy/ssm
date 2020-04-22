package dao;

import entity.Account;

import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/13
 * @function 接口
 */
public interface AccountDao {

    void saveAccount(Account account);

    void deleteAccount(Account account);

    void updateAccount(Account account);

    List<Account> findAllAccount();

    Account findAccountById(Integer id);
}
