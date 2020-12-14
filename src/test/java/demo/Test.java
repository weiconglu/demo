package demo;

public class Test {

	public static void main(String[] args) {
		
		double width = 1024;
		double length = 600;
		
		double inch = 7;
		
		double dpi = Math.sqrt(width*width+length*length)/inch;
		
		System.out.println(dpi);

	}

}
