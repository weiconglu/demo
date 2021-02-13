package time;

import java.time.LocalDateTime;

public class TestLocalDateTime {

	public static void main(String[] args) {
		
		// LocalDate LocalTime LocalDateTime
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);  // <------ 1
		
		System.out.println(localDateTime.plusYears(2)); // <------ 当对LocalDateTime对象操作后会产生一个新的对象实例，原实例不变，线程安全

		System.out.println(localDateTime);  // <------ 2
		
//		LocalDateTime localDateTime2 = LocalDateTime.of(2021, 2, 30, 12, 0); // <------ 因为2021-2-30这个日期是非法的，会抛出异常
		LocalDateTime localDateTime2 = LocalDateTime.of(2021, 2, 3, 12, 0);
		System.out.println(localDateTime2);
		
	}

}
