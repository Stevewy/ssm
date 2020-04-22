package mybatis.cfg;

import lombok.Getter;
import lombok.Setter;

/**
 * @author WangYao
 * @date 2020/4/6
 * @function 封装sql与结果的类名
 */
@Setter
@Getter
public class Mapper {
    private String queryString;
    private String resultType;

}
