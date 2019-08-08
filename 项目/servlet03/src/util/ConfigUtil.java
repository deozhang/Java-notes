package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	static Properties p = new Properties();
	static {
		//获取文件流
		InputStream ins = ConfigUtil.class.getClassLoader()
				.getResourceAsStream("config.properties");
		try {
			p.load(ins);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//根据key获取value值
	public static String getValue(String key) {
		return p.getProperty(key);
	}
	public static void main(String[] args) {
		System.out.println(getValue("AdminDAO"));
	}
}
