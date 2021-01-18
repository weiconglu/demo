package com.example.demo.utils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceUtils {
	
	/**
	 * 传入项目中properties文件的路径，返回properties
	 * @param
	 * @return Properties
	 */
	public static Properties getProperties(String propertiesPath) {
		Properties properties = new Properties();
		InputStream in = ResourceUtils.class.getClassLoader().getResourceAsStream(propertiesPath);
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	/**
	 * 关闭此流并释放与此流关联的所有系统资源。如果已经关闭该流，则调用此方法无效。
	 * @param closeable
	 */
	public static void safeClose(Closeable closeable) {
		if (null != closeable) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
