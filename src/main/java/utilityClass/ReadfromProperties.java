package utilityClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadfromProperties {
public static String readproperties(String key) throws IOException {
Properties prop=new Properties();
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\nimapconfiguration\\test.properties");
prop.load(fis);
String key1=prop.getProperty(key);
return key1;
}
}
