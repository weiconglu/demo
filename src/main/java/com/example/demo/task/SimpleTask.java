package com.example.demo.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

import com.example.demo.utils.TimeUtils;

/**
 * 
 * @author Administrator
 *
 */
//@Configuration
//@EnableScheduling
public class SimpleTask {
	
	@Scheduled(fixedRate = 10000)
	private void sayHello() {
		System.out.println("-----------------Hello, 我是一个Task job示例，每10秒钟执行一次 "+TimeUtils.getBeautifulString(new Date())+"--------------------");
	}

}
