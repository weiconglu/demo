package common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertisUtil {
	
	/**
	 * 传入properties文件的路径，返回properties
	 * @param
	 * @return Properties
	 */
	public static Properties getProperties(String propertiesPath) {
		Properties properties = new Properties();
		InputStream in = PropertisUtil.class.getClassLoader().getResourceAsStream(propertiesPath);
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	/**
	 * 获取 application-pro.properties
	 * 注意：这个文件名已写成固定的
	 * @return
	 */
	public static Properties getProperties() {
		Properties properties = new Properties();
		InputStream in = PropertisUtil.class.getClassLoader().getResourceAsStream("application-pro.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
