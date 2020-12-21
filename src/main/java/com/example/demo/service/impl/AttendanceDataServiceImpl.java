package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AttendanceDataMapper;
import com.example.demo.model.AttendanceData;
import com.example.demo.service.AttendanceDataService;

@Service
public class AttendanceDataServiceImpl implements AttendanceDataService {

	@Autowired
	private AttendanceDataMapper attendanceDataMapper;

	@Override
	public Integer add(AttendanceData attendanceData) {
		return attendanceDataMapper.add(attendanceData);
	}

}
