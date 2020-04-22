import entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Date;

/**
 * @author WangYao
 * @date 2020/4/17
 * @function 配置类
 *
 * 代替 bean.xml
 * Configuration
 *      指明该类为配置类,作为AnnotationConfigApplicationContext参数可不写
 * ComponentScan
 *      扫描的包 等同<context:component-scan></context:component-scan>标签
 *
 * Bean
 *      将返回值放入容器,参数为key
 *
 * Import
 *      导入配置类,父子关系,还可以在子类加Configuration注解此时父类要扫描子类所在包
 *      如果想平级,在创建AnnotationConfigApplicationContext传多个参数
 *
 * PropertySource
 *      找properties配置文件
 */
@Configuration
//@ComponentScans(value = {@ComponentScan(basePackages = "dao"), @ComponentScan(basePackages = "service"), @ComponentScan(basePackages = "entity")})
@ComponentScan(basePackages = {"dao","service","entity"})
//@Import(xxx.class)
@PropertySource(value = "classpath:user.properties", encoding = "utf-8")
public class SpringConfiguration {

    @Bean(name = "userByConstructor")
    @Scope("prototype")
    public User getUserByConstructor(){
        return new User(1, "张三", new Date(), "男", "未知");
    }

    @Value("${user.id}")
    private Integer id;

    @Value("${user.username}")
    private String username;

    @Value("${user.address}")
    private String address;

    @Value("${user.sex}")
    private String sex;

    @Bean(name = "userBySet")
    public User getUserBySet(){
        User u = new User();
        u.setId(id);
        u.setUsername(username);
        u.setSex(sex);
        u.setAddress(address);
        return u;
    }
}
