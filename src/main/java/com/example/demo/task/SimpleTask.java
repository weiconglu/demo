package com.example.demo.task;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.demo.utils.TimeUtils;

/**
 * 
 * @author lu_weicong
 *
 */
@Configuration
@EnableScheduling
public class SimpleTask {
	
	// fixedRate 表示时间间隔，单位毫秒
	// fixedDelay 表示任务间隔
	@Scheduled(fixedDelay = 10000)
	private void sayHello() {
		System.out.println("-----------------Hello, 我是一个Task job示例，每10秒钟执行一次 "+TimeUtils.getBeautifulString(new Date())+"--------------------");
	}

}
