package service;

import entity.Account;

import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/13
 * @function 业务层接口
 */
public interface AccountService {

    void saveAccount(Account account);

    void deleteAccount(Account account);

    void updateAccount(Account account);

    List<Account> findAllAccount();

    Account findAccountById(Integer id);

    void transfer(Integer aid, Integer bid, Double money);
}
