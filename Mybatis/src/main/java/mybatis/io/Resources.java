package mybatis.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author WangYao
 * @date 2020/4/6
 * @function
 */
public class Resources {

    /**
     * 根据路径得到字节输出流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) throws IOException {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
