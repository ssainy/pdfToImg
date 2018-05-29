/**
 * Created by cch on 2017/5/22.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by cch on 2017/4/26.
 */
public class ReadProper {
    public static Properties readproper(String filepath) {
        InputStream resourceAsStream = Class.class.getResourceAsStream(filepath);
        if (resourceAsStream == null) {
            return null;
        }
        Properties properties = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream, "GBK"));
            properties.load(reader);
        } catch (IOException e) {
        }
        return properties;
    }
}
