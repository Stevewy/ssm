package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author WangYao
 * @date 2020/4/9
 * @function 封装对象,可以使用多个对象来查询
 */
@Getter
@Setter
public class QueryVo {
    private User user;
    private Account account;
    private List<Integer> ids;
}
