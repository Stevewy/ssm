package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author WangYao
 * @date 2020/4/11
 * @function
 */
@Getter
@Setter
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;
    //从表是一对一
    private User user;

    @Override
    public String toString() {
        if (user != null)
            return "Account{" +
                    "id=" + id +
                    ", uid=" + uid +
                    ", money=" + money +
                    ", user=" + user +
                    '}';
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
