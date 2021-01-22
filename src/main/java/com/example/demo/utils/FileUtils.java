package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class FileUtils {

	public static void main(String[] args) {

		File folderFile = new File("D:/git/cppdemo/day01");
		
		// 注意这里的写法，跟folderFile末尾加不加"/"没关系，这里中间必须显式加上"/"
		File xFolder = new File(folderFile.getAbsolutePath() + "/" + TimeUtils.getSimpleString(new Date()));
		boolean xFolderFlag = xFolder.mkdir();

		File[] files = getFiles(folderFile, "cpp", "h");
		
		if (xFolderFlag) {
			BufferedReader bufferedReader = null;
			BufferedWriter bufferedWriter = null;
			char[] data = new char[1024];
			
			for (File file : files) {
				// 这里定义File，如果流在操作时找不到这个文件，会自动尝试创建
				File xFile = new File(xFolder.getAbsolutePath() + "/" + file.getName());
				try {
					bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
					bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xFile), "utf-8"));
					int d;
					while ((d = bufferedReader.read(data)) != -1) {
						bufferedWriter.write(data, 0, d);
					}

				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					ResourceUtils.safeClose(bufferedReader);
					ResourceUtils.safeClose(bufferedWriter);
				}
			}
			data = null;
		}
	}

	/**
	 * 获得某个文件夹下，不包括子文件夹，所有指定扩展名的文件
	 * 
	 * @param pathname
	 * @param extentions 扩展名大小写均可
	 * @return
	 */
	private static File[] getFiles(File pathname, String... extentions) {

		File[] files = null;
		boolean flag = pathname.exists() && pathname.isDirectory() && pathname.canRead();

		// String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.png|.PNG)$";
		StringBuilder sb = new StringBuilder(".+(.");
		for (String extention : extentions) {
			sb.append(extention.toLowerCase()).append("|.");
		}
		sb.deleteCharAt(sb.lastIndexOf(".")).deleteCharAt(sb.lastIndexOf("|")).append(")$");
		String regex = new String(sb);

		if (flag) {
			files = pathname.listFiles(new FileFilter() {
				@Override
				public boolean accept(File filename) {
					if (filename.getName().toLowerCase().matches(regex)) {
						return true;
					}
					return false;
				}
			});
		}

		// files长度可能为0，但肯定不是null
		return files;
	}

}
