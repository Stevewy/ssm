package service.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author WangYao
 * @date 2020/4/13
 * @function 程序解耦,自己实现来理解,并不会使用
 */
@Deprecated
public class BeanFactory {
    private static Properties properties;
    private static Map<String, Object> beans;

    static {
        try {
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("mybean.properties");
            properties = new Properties();
            properties.load(in);
            beans = new HashMap<String, Object>();
            Enumeration keys = properties.keys();
            while(keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = properties.getProperty(key);
                Object value = Class.forName(beanPath).getDeclaredConstructor().newInstance();
                beans.put(key, value);
            }
        }
        catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties错误");
        }
    }

    public static Object getBean(String BeanName) {
        if (beans.containsKey(BeanName))
            return beans.get(BeanName);
        throw new RuntimeException("没有配置这个类");
    }
}
