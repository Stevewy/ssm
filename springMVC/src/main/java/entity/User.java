package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangYao
 * @date 2020/4/24
 * @function
 */
@Getter
@Setter
@ToString
public class User implements Serializable {

    private String name;
    private Date birthday;
}
