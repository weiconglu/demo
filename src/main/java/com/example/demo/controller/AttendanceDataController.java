package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AttendanceData;
import com.example.demo.service.AttendanceDataService;
import com.example.demo.utils.TimeUtils;

@RestController
@RequestMapping("attendanceData")
public class AttendanceDataController {

	public enum Headers {
		loginName, fullName, status, startAt, endAt, deskName, siteName, floorName
	}

	@Autowired
	private AttendanceDataService attendanceDataService;

	@GetMapping("/insert")
	public String insert() {

		AttendanceData attendanceData = new AttendanceData();
		try (Reader in = new FileReader("data.csv")) {
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
			for (CSVRecord record : records) {
				attendanceData.setLoginName(record.get(Headers.loginName));
				attendanceData.setFullName(record.get(Headers.fullName));
				attendanceData.setStatus(record.get(Headers.status));
				attendanceData.setStartAt(TimeUtils.getBeautifulTimeString(record.get(Headers.startAt)));
				attendanceData.setEndAt(TimeUtils.getBeautifulTimeString(record.get(Headers.endAt)));
				attendanceData.setDeskName(record.get(Headers.deskName));
				attendanceData.setSiteName(record.get(Headers.siteName));
				attendanceData.setFloorName(record.get(Headers.floorName));
				attendanceDataService.insert(attendanceData);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "未找到文件";
		} catch (IOException e) {
			e.printStackTrace();
			return "文件读取错误";
		} finally {
			attendanceData = null;
		}

		return "数据成功导入到数据库";
	}

}
