import dao.AccountDao;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AccountService;
import service.impl.AccountServiceImpl;

/**
 * @author WangYao
 * @date 2020/4/14
 * @function 测试 代码
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
//@ContextConfiguration(classes = SpringConfiguration.class)
public class Main {

    @Autowired
    @Qualifier("accountService")
    private AccountServiceImpl accountService;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private User userByConstructor;

    @Autowired
    private User userBySet;

    @Test
    public void testFind(){
        System.out.println(accountService.findAllAccount());
    }

    @Test
    public void testProxy(){
        System.out.println(accountService.findAllAccount());
        accountService.transfer(2,1,50d);
        System.out.println(accountService.findAllAccount());
    }

    @Test
    public void testInjectByConstructor(){
        System.out.println(userByConstructor);
    }

    @Test
    public void testInjectBySet(){
        System.out.println(userBySet);
    }

    public static void main(String[] args) {

    }
}
