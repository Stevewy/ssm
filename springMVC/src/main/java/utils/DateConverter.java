package utils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangYao
 * @date 2020/4/24
 * @function
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if (s == null) throw new RuntimeException("参数错误");
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("参数错误");
        }
    }
}
