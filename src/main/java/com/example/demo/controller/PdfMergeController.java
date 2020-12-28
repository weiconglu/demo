package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author lu_weicong
 *
 */

@Controller
public class PdfMergeController {
	
//	http://127.0.0.1:8080/demo/pdfMerge
	@RequestMapping("/pdfMerge")
	public String pdfMerge() {
		return "pdfMerge";
	}

}
