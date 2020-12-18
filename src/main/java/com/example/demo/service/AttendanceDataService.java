package com.example.demo.service;

import com.example.demo.model.AttendanceData;

public interface AttendanceDataService {
	
	/**
	 * 插入一条记录
	 * @param attendanceData
	 * @return
	 */
	Integer insert(AttendanceData attendanceData);

}
