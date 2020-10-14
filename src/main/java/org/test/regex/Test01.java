package org.test.regex;

import java.util.regex.Pattern;

public class Test01 {
	
	/*
	1)訪問日時：2020/07/20 09:00～12:00
	2)訪問場所：東京本社
	3)場所：2/4/8
	4)面会者指名：日電太郎
	5)面会者電話番号：080-5568-8885
	6)訪問者氏名：梅田洋一/斎藤敏也
	7)所属会社：NECソリューションイノベータ/NECソリューションイノベータ
	8)訪問理由：開発中システムの打ち合わせのため
	 */

	public static void main(String[] args) {
		String line = "2020/07/20 09:00～12:00";
		String regex1 = "\\d{4}/\\d{1,2}/\\d{1,2}\\s{1,}\\d{1,2}:\\d{1,2}～\\d{1,2}:\\d{1,2}";  // 2020/07/20 09:00～12:00
		
		System.out.println(Pattern.matches(regex1, line));

	}

}
