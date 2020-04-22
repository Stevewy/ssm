package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author WangYao
 * @date 2020/4/16
 * @function
 */

/*
 * @Value 注入基本类型和String(spring el表达式)
 *
 *
 */
@Setter
@Getter
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
