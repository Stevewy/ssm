package mybatis.cfg;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangYao
 * @date 2020/4/6
 * @function
 */
@Getter
@Setter
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String, Mapper> mappers = new HashMap<String, Mapper>();

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }
}
