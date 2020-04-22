package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author WangYao
 * @date 2020/4/18
 * @function
 */
@Getter
@Setter
@ToString
public class Account implements Serializable {

    private Integer id;
    private Integer uid;
    private Double money;
}
