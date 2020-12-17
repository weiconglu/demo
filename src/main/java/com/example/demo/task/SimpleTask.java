package com.example.demo.task;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.demo.common.utils.TimeUtils;

/**
 * 
 * @author Administrator
 *
 */
@Configuration
@EnableScheduling
public class SimpleTask {
	
	@Scheduled(fixedRate = 10000)
	private void sayHello() {
		System.out.println("-----------------Hello, 我是一个Task job示例，每10秒钟执行一次 "+TimeUtils.getBeautifulTimeString(new Date())+"--------------------");
	}

}
