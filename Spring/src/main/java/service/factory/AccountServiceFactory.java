package service.factory;

import service.AccountService;
import utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WangYao
 * @date 2020/4/19
 * @function 将事务控制分离出来
 */
public class AccountServiceFactory {
    private AccountService accountService;
    private TransactionManager manager;

    public void setManager(TransactionManager manager) {
        this.manager = manager;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader()
                , accountService.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object value = null;
                        try {
                            manager.begin();
                            value = method.invoke(accountService, args);
                            manager.commit();
                        } catch (Exception e) {
                            manager.rollback();
//                            e.printStackTrace();
                            throw new RuntimeException();
                        } finally {
                            manager.release();
                        }
                        return value;
                    }
                });
    }
}
