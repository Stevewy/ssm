package service.impl;

import dao.AccountDao;
import entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.AccountService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/13
 * @function 业务层实现代码
 */
/*
 * Component   创建对象放到bean里面
 * Controller 表现层
 * Service 业务层
 * Repository 持久层
 *
 * Autowired  自动注入 唯一匹配直接注入,多个匹配按名称作为id寻找,否则报错
 * Qualifier  按名称注入(不能单独对属性使用,可以对方法参数使用)
 * Resource   按id注入
 *
 * Scope 作用范围 单例 多例
 *
 * PreDestroy 销毁方法
 * PostConstruct 初始化方法
 */
@Scope("prototype")
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao = null;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountDao.deleteAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void transfer(Integer aid, Integer bid, Double money) {
        Account a = accountDao.findAccountById(aid);
        Account b = accountDao.findAccountById(bid);
        if(a.getMoney() < money)
            throw new RuntimeException("钱不够了");
        a.setMoney(a.getMoney()-money);
        b.setMoney(b.getMoney()+money);
        accountDao.updateAccount(a);
//        int aaa = 1/0;
        accountDao.updateAccount(b);
    }

}
