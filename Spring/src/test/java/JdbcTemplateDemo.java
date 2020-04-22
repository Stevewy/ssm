import entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AccountService;


/**
 * @author WangYao
 * @date 2020/4/18
 * @function JdbcTemplate用法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class JdbcTemplateDemo {

    @Autowired
    private AccountService accountService;

    @Test
    public void select(){
        System.out.println(accountService.findAllAccount());
    }

    @Test
    public void save(){
        Account account = new Account();
        account.setId(50);
        account.setUid(49);
        account.setMoney(500d);
        accountService.saveAccount(account);
    }

    @Test
    public void update(){
        Account account = new Account();
        account.setId(50);
        account.setUid(49);
        account.setMoney(5000d);
        accountService.updateAccount(account);
    }

    @Test
    public void delete(){
        Account account = new Account();
        account.setId(50);
        account.setUid(49);
        account.setMoney(500d);
        accountService.deleteAccount(account);
    }

    public static void main(String[] args) {

    }
}
